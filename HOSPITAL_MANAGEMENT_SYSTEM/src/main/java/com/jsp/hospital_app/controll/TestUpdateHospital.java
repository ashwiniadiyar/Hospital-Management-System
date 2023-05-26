package com.jsp.hospital_app.controll;

import com.jsp.hospital_app.dto.Hospital;
import com.jsp.hospital_app.service.HospitalService;

public class TestUpdateHospital {

	public static void main(String[] args)
	{
		Hospital hospital=new Hospital();
		HospitalService service=new HospitalService();
		hospital.setName("Opollo1");
		hospital.setWebsite("www.opollo1.com");
		service.updateHospital(1, hospital);

	}

}
