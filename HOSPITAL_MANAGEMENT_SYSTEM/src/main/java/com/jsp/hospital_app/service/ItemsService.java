package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.ItemsDaoImp;
import com.jsp.hospital_app.dao.imp.MedorderDaoImp;
import com.jsp.hospital_app.dto.Items;
import com.jsp.hospital_app.dto.Medorder;

public class ItemsService 
{
	public void saveItems(int mid,Items Items)
	{
		ItemsDaoImp daoImp= new ItemsDaoImp();
		Items Items1=daoImp.saveItems(mid,Items);
		if(Items1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}
	
	public Items getItems(int iid)
	{
		ItemsDaoImp daoImp= new ItemsDaoImp();
		Items Items=daoImp.getItems(iid);
		if(Items !=null)
		{
			return Items;
		}
		return null;
	}
	
	public void deleteItems(int iid)
	{
		ItemsDaoImp daoImp= new ItemsDaoImp();
		boolean result=daoImp.deleteItems(iid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Items updateItems(int iid,Items Items)
	{
		ItemsDaoImp daoImp= new ItemsDaoImp();
		Items Items1=daoImp.updateItems(iid, Items);
		if(Items1!= null)
		{
			return Items1;
		}
		return null;
	}
	
	public List <Items> getAllItems()
	{
		ItemsDaoImp daoImp= new ItemsDaoImp();
		List<Items> Items=daoImp.getAllItems();
		
		if(Items!= null)
		{
			return Items;
		}
		return null;
	}
}
