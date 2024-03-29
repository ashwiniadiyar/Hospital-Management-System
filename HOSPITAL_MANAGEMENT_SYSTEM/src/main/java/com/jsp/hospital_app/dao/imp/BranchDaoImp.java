package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.BranchDao;
import com.jsp.hospital_app.dto.Branch;
import com.jsp.hospital_app.dto.Hospital;

public class BranchDaoImp implements BranchDao
{

	public Branch saveBranch(int hid, Branch branch) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=entityManager.find(Hospital.class,hid);
		if(hospital !=null)
		{
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}
		return null;
	}

	public Branch getBranch(int bid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Branch branch=entityManager.find(Branch.class, bid);
		return branch;
	}

	public boolean deleteBranch(int bid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, bid);
		if(branch !=null)
		{
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		
		return false;
	}

	public Branch updateBranch(int bid, Branch branch)
	{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch1=entityManager.find(Branch.class, bid);
		if(branch1 !=null)
		{
			branch1.setName(branch.getName());
			branch1.setPhone(branch.getPhone());
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			return branch1; 
		}
		
		return null;
	}

	public List<Branch> getAllBranch() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select b from Branch b");
		List <Branch> branch=query.getResultList();
		return branch;
	}

}
