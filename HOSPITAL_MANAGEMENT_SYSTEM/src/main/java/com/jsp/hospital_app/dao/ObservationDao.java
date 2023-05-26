package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Observation;

public interface ObservationDao 
{
	public Observation saveObservation (int eid, Observation  observation);

	public  Observation getObservation(int oid);

	public boolean deleteObservation(int oid);

	public Observation updateObservation(int oid,Observation observation);
	
	public List<Observation> getAllObservation();
	
	public List<Observation> getObservationByDoctername(String name);

}
