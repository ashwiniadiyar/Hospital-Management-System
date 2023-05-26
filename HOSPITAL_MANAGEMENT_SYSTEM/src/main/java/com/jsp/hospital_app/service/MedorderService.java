package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.MedorderDaoImp;
import com.jsp.hospital_app.dto.Medorder;

public class MedorderService 
{
	public void saveMedorder(int eid,Medorder medorder)
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		Medorder Medorder1=daoImp.saveMedorder(eid,medorder);
		if(Medorder1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}
	
	public Medorder getMedorder(int mid)
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		Medorder Medorder=daoImp.getMedorder(mid);
		if(Medorder !=null)
		{
			return Medorder;
		}
		return null;
	}
	
	public void deleteMedorder(int mid)
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		boolean result=daoImp.deleteMedorder(mid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Medorder updateMedorder(int mid,Medorder medorder)
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		Medorder Medorder1=daoImp.updateMedorder(mid, medorder);
		if(Medorder1!= null)
		{
			return Medorder1;
		}
		return null;
	}
	
	public List <Medorder> getAllMedorder()
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		List<Medorder> Medorder=daoImp.getAllMedorder();
		
		if(Medorder!= null)
		{
			return Medorder;
		}
		return null;
	}
	
	public List <Medorder> getMedorderByDoctername(String name) 
	{
		MedorderDaoImp daoImp= new MedorderDaoImp();
		List<Medorder> Medorder=daoImp.getMedorderByDoctername(name);
		
		if(Medorder!= null)
		{
			return Medorder;
		}
		return null;
	}
}
