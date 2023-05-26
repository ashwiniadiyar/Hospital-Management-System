package com.jsp.hospital_app.controll;

import com.jsp.hospital_app.dto.Hospital;
import com.jsp.hospital_app.service.HospitalService;

public class TestSaveHospital 
{
	public static void main(String[] args)
	{
		Hospital hospital=new Hospital();
		HospitalService service=new HospitalService();
		hospital.setName("city central");
		hospital.setWebsite("www.citycentral.com");	
		service.saveHospital(hospital);
	}
}
