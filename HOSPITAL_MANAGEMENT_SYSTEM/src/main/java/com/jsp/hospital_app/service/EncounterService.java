package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.EncounterDaoImp;
import com.jsp.hospital_app.dto.Encounter;


public class EncounterService 
{
	public void saveEncounter(Encounter Encounter,int bid)
	{
		EncounterDaoImp daoImp= new EncounterDaoImp();
		Encounter Encounter1=daoImp.saveEncounter(bid,Encounter);
		if(Encounter1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}
	
	public Encounter getEncounter(int eid)
	{
		EncounterDaoImp daoImp= new EncounterDaoImp();
		Encounter Encounter=daoImp.getEncounter(eid);
		if(Encounter !=null)
		{
			return Encounter;
		}
		return null;
	}
	
	public void deleteEncounter(int eid)
	{
		EncounterDaoImp daoImp= new EncounterDaoImp();
		boolean result=daoImp.deleteEncounter(eid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Encounter updateEncounter(int eid,Encounter Encounter)
	{
		EncounterDaoImp daoImp= new EncounterDaoImp();
		Encounter Encounter1=daoImp.updateEncounter(eid, Encounter);
		if(Encounter1!= null)
		{
			return Encounter1;
		}
		return null;
	}
	
	public List <Encounter> getAllEncounter()
	{
		EncounterDaoImp daoImp= new EncounterDaoImp();
		List<Encounter> Encounter=daoImp.getAllencounter();
		
		if(Encounter != null)
		{
			return Encounter;
		}
		return null;
	}
}
