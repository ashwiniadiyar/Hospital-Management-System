package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.MedorderDao;
import com.jsp.hospital_app.dto.Encounter;
import com.jsp.hospital_app.dto.Medorder;

public class MedorderDaoImp implements MedorderDao
{

	public Medorder saveMedorder(int eid, Medorder medorder)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class,eid);
		if(encounter !=null)
		{
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			return medorder;
		}
		return null;
	}

	public Medorder getMedorder(int mid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Medorder medorder=entityManager.find(Medorder.class,mid);
		
		return medorder;
	}

	public boolean deleteMedorder(int mid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Medorder medorder=entityManager.find(Medorder.class, mid);
		if(medorder !=null)
		{
			entityTransaction.begin();
			entityManager.remove(medorder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Medorder updateMedorder(int mid, Medorder medorder) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Medorder medorder1=entityManager.find(Medorder.class, mid);
		if(medorder1 !=null)
		{
			medorder1.setDname(medorder.getDname());
			entityTransaction.begin();
			entityManager.merge(medorder1);
			entityTransaction.commit();
			return medorder1;
		}
		return null;
	}

	public List<Medorder> getAllMedorder() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Medorder s");
		List <Medorder> medorder=query.getResultList();
		
		return medorder;
	}

	public List<Medorder> getMedorderByDoctername(String name) 
	{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Medorder s where dname=?");
		query.setParameter(1, name);
		List <Medorder> medorder=query.getResultList();
		
		return medorder;
	}

}
