package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.PersonDao;
import com.jsp.hospital_app.dto.Encounter;
import com.jsp.hospital_app.dto.Medorder;
import com.jsp.hospital_app.dto.Person;

public class PersonDaoImp implements PersonDao
{

	public Person savePerson(int eid, Person person) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Encounter encounter=entityManager.find(Encounter.class,eid);
		if(encounter !=null)
		{
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		return null;
	}

	public Person getPerson(int pid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();

		Person person=entityManager.find(Person.class, pid);
		return person;
	}

	public boolean deletePerson(int pid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Person person=entityManager.find(Person.class, pid);
		if(person!=null)
		{
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Person updatePerson(int pid, Person person) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Person person1=entityManager.find(Person.class, pid);

		if( person1!=null)
		{

			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			return person1;
		}
		return null;
	}

	public List<Person> getAllPerson() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();

		Query query=entityManager.createQuery("select s from Person s");
		List <Person> person=query.getResultList();

		return person;
	}

	public List<Person> getAllPersonByGender(String gender) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Medorder s where gender=? ");
		query.setParameter(1, gender);
		List <Person> person=query.getResultList();
		
		return person;
	}

	public List<Person> getAllPersonByAge(int age) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Person s where age=?");
		query.setParameter(1, age);
		List <Person>person=query.getResultList();
		
		return person;
	}

	public List<Person> getAllPersonByPhone(long phone) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select s from Person s where phone=?");
		query.setParameter(1, phone);
		List <Person>person=query.getResultList();
		
		return person;
	}

}
