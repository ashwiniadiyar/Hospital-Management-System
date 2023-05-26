package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.ObservationDao;
import com.jsp.hospital_app.dto.Encounter;
import com.jsp.hospital_app.dto.Medorder;
import com.jsp.hospital_app.dto.Observation;

public class ObservationDaoImp implements ObservationDao 
{

	public Observation saveObservation(int eid, Observation observation) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class,eid);
		if(encounter !=null)
		{
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			return observation;
		}
		return null;
	}

	public Observation getObservation(int oid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();

	     Observation observation=entityManager.find(Observation.class, oid);
		return observation;
	}

	public boolean deleteObservation(int oid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Observation observation=entityManager.find(Observation.class, oid);
		if(observation !=null)
		{
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Observation updateObservation(int oid, Observation observation)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Observation observation1=entityManager.find(Observation.class, oid);
		
		if(observation1 !=null)
		{
			observation1.setRobservattion(observation.getRobservattion());
			observation1.setDname(observation.getDname());
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			return observation1;
		}
		return null;
	}

	public List<Observation> getAllObservation() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Observation s");
		List <Observation> observation=query.getResultList();
		
		return observation;
	}

	public List<Observation> getObservationByDoctername(String name)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Observation from s where dname=? ");
		query.setParameter(1, name);
		List <Observation>observation=query.getResultList();
		
		return observation;
	}

}
