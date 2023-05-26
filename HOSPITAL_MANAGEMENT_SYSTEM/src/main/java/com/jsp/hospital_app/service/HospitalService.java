package com.jsp.hospital_app.service;

import com.jsp.hospital_app.dao.imp.HospitalDaoImp;
import com.jsp.hospital_app.dto.Hospital;

public class HospitalService 
{
	public void saveHospital(Hospital hospital)
	{
		HospitalDaoImp daoImp= new HospitalDaoImp();
		Hospital hospital1=daoImp.saveHospital(hospital);
		if(hospital1 !=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}

	public Hospital getHospital(int hid)
	{
		HospitalDaoImp daoImp= new HospitalDaoImp();
		Hospital hospital1=daoImp.getHospitalById(hid);
		if(hospital1 !=null)
		{
			return hospital1;
		}
		return null;
	}

	public void deleteHospital(int hid)
	{
		HospitalDaoImp daoImp= new HospitalDaoImp();
		boolean result=daoImp.deleteHospitalId(hid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}

	public Hospital updateHospital(int hid,Hospital hospital)
	{
		HospitalDaoImp daoImp= new HospitalDaoImp();
		Hospital hospital1=daoImp.updateHospitalById(hid, hospital);
		if(hospital1 != null)
		{
			return hospital1;
		}
		return null;
	}
}
