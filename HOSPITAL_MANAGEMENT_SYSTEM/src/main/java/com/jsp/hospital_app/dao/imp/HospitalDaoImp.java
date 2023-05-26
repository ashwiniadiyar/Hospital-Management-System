package com.jsp.hospital_app.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hospital_app.dao.HospitalDao;
import com.jsp.hospital_app.dto.Hospital;

public class HospitalDaoImp implements HospitalDao
{

	public Hospital saveHospital(Hospital hospital) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		
		return hospital;
	}

	public Hospital getHospitalById(int hid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Hospital hospital =entityManager.find(Hospital.class,hid);

		return hospital;
	}

	public boolean deleteHospitalId(int hid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital =entityManager.find(Hospital.class,hid);
		if(hospital!=null)
		{
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true; 
		}
		return false;
	}

	public Hospital updateHospitalById(int hid, Hospital hospital)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital1=entityManager.find(Hospital.class, hid);
		if(hospital1 !=null)
		{
			hospital1.setName(hospital.getName());
			hospital1.setWebsite(hospital.getWebsite());
			entityTransaction.begin();
			entityManager.merge(hospital1);
			entityTransaction.commit();
			return hospital1; 
		}
		return null;
	}

}
