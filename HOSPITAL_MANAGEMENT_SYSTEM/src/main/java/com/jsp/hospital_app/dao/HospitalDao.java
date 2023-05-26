package com.jsp.hospital_app.dao;

import com.jsp.hospital_app.dto.Hospital;

public interface HospitalDao 
{
	public Hospital saveHospital(Hospital hospital);
	
	public Hospital getHospitalById(int hid);
	
	public boolean deleteHospitalId(int hid);
	
	public Hospital updateHospitalById(int id,Hospital hospital);
}
