package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.EncounterDao;
import com.jsp.hospital_app.dto.Encounter;
import com.jsp.hospital_app.dto.Branch;

public class EncounterDaoImp implements EncounterDao
{

	public Encounter saveEncounter(int bid, Encounter encounter) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Branch branch=entityManager.find(Branch.class,bid);
		if(branch !=null)
		{
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return encounter;
		}
		return null;
	}

	public Encounter getEncounter(int eid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();

		Encounter encounter=entityManager.find(Encounter.class, eid);
		return encounter;
	}

	public boolean deleteEncounter(int eid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter !=null)
		{
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Encounter updateEncounter(int eid, Encounter encounter) 
	{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter1=entityManager.find(Encounter.class, eid);
		
		if(encounter1 !=null)
		{
			encounter1.setReason(encounter.getReason());
			encounter1.setDdischarge(encounter.getDdischarge());
			
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();
			return encounter1;
		}

		return null;
	}

	public List<Encounter> getAllencounter() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select s from Encounter s");
		List <Encounter> encounter=query.getResultList();
		
		return encounter;
	}

}
