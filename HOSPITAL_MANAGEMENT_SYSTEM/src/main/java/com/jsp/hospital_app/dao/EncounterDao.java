package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Encounter;

public interface EncounterDao 
{
	public Encounter saveEncounter(int bid,Encounter encounter);

	public Encounter getEncounter(int eid);

	public boolean deleteEncounter(int eid);

	public Encounter updateEncounter(int eid,Encounter encounter);
	
	public List<Encounter> getAllencounter();
}
