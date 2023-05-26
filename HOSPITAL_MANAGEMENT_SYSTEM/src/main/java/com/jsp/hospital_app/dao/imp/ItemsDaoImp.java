package com.jsp.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hospital_app.dao.ItemsDao;
import com.jsp.hospital_app.dto.Encounter;
import com.jsp.hospital_app.dto.Items;
import com.jsp.hospital_app.dto.Medorder;

public class ItemsDaoImp implements ItemsDao
{

	public Items saveItems(int mid, Items items)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Medorder medorder=entityManager.find(Medorder.class,mid);
		if(medorder !=null)
		{
			entityTransaction.begin();
			entityManager.persist(items);
			entityTransaction.commit();
			return items;
		}
		return null;
	}

	public Items getItems(int iid) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		Items items=entityManager.find(Items.class,iid);
		
		return items;
	}

	public boolean deleteItems(int iid)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Items items=entityManager.find(Items.class, iid);
		if(items !=null)
		{
			entityTransaction.begin();
			entityManager.remove(items);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Items updateItems(int iid, Items items)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

		Items items1=entityManager.find(Items.class, iid);
		if(items1 !=null)
		{
			items1.setName(items.getName());
			items1.setCost(items.getCost());
			items1.setQuantity(items.getQuantity());
			entityTransaction.begin();
			entityManager.merge(items1);
			entityTransaction.commit();
			return items1;
		}
		return null;
	}

	public List<Items> getAllItems()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ashwini");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select s from Items s");
		List <Items> items=query.getResultList();
		
		return items;
	}

}
