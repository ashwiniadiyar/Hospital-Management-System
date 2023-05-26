package com.jsp.hospital_app.service;

import java.util.List;


import com.jsp.hospital_app.dao.imp.ObservationDaoImp;
import com.jsp.hospital_app.dto.Observation;

public class ObservationService 
{
	public void saveObservation(int eid,Observation Observation)
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		Observation Observation1=daoImp.saveObservation(eid,Observation);
		if(Observation1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}
	
	public Observation getObservation(int oid)
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		Observation Observation=daoImp.getObservation(oid);
		if(Observation !=null)
		{
			return Observation;
		}
		return null;
	}
	
	public void deleteObservation(int oid)
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		boolean result=daoImp.deleteObservation(oid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Observation updateObservation(int oid,Observation Observation)
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		Observation Observation1=daoImp.updateObservation(oid,Observation);
		if(Observation1!= null)
		{
			return Observation1;
		}
		return null;
	}
	
	public List <Observation> getAllObservation()
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		List<Observation> Observation=daoImp.getAllObservation();
		
		if(Observation!= null)
		{
			return Observation;
		}
		return null;
	}
	
	public List <Observation> getObservationByDoctername(String name)
	{
		ObservationDaoImp daoImp= new ObservationDaoImp();
		List<Observation> Observation=daoImp.getObservationByDoctername(name);
		
		if(Observation!= null)
		{
			return Observation;
		}
		return null;
	}
}
