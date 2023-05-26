package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.UserDao;
import com.jsp.hospital_app.dto.Hospital;
import com.jsp.hospital_app.dto.Person;
import com.jsp.hospital_app.dto.User;

public class UserDaoImp implements UserDao
{

	public User saveUser(User user) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
	}

	public User getUser(int uid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		User user =entityManager.find(User.class,uid);
		return user;
	}

	public boolean deleteUser(int uid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user =entityManager.find(User.class,uid);
		if(user!=null)
		{
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true; 
		}
		return false;
	}

	public User updateUser(int uid, User user) 
	{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		User user1=entityManager.find(User.class, uid);

		if( user1!=null)
		{

			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			return user1;
		}
		return null;
	}

	public List<User> getAllUser() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();

		Query query=entityManager.createQuery("select s from User s");
		List <User> user=query.getResultList();

		return user;
	}

	public List<User> getUserByRole(String role) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from User s where role=?");
		query.setParameter(1, role);
		List <User>user=query.getResultList();
		
		return user;
	}

}
