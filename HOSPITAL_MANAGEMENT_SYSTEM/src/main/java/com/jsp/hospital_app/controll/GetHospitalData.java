package com.jsp.hospital_app.controll;

import com.jsp.hospital_app.dto.Hospital;
import com.jsp.hospital_app.service.HospitalService;

public class GetHospitalData {

	public static void main(String[] args)
	{
		HospitalService service= new HospitalService();
		Hospital hospital=service.getHospital(1);
		System.out.println("--------------------------------------------");
		System.out.println("Hospital Name:"+hospital.getName());
		System.out.println("Hospital Website:"+hospital.getWebsite());
	}

}
