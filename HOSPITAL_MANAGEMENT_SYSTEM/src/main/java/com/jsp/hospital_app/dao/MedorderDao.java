package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Medorder;

public interface MedorderDao
{
	public Medorder saveMedorder(int eid, Medorder medorder);

	public Medorder getMedorder(int mid);

	public boolean deleteMedorder(int mid);

	public Medorder updateMedorder(int mid, Medorder medorder);
	
	public List<Medorder> getAllMedorder();
	
	public List<Medorder> getMedorderByDoctername(String name);

}
