package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.AddressDaoImp;
import com.jsp.hospital_app.dto.Address;

public class AddressService 
{
	public void saveAddress(Address address,int bid)
	{
		AddressDaoImp daoImp= new AddressDaoImp();
		Address address1=daoImp.saveAddress(bid,address);
		if(address1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}

	public Address getAddress(int aid)
	{
		AddressDaoImp daoImp= new AddressDaoImp();
		Address address=daoImp.getAddress(aid);
		if(address !=null)
		{
			return address;
		}
		return null;
	}

	public void deleteAddress(int aid)
	{
		AddressDaoImp daoImp= new AddressDaoImp();
		boolean result=daoImp.deleteAddress(aid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}

	public Address updateBranch(int aid,Address address)
	{
		AddressDaoImp daoImp= new AddressDaoImp();
		Address address1=daoImp.updateAddress(aid, address);
		if(address1!= null)
		{
			return address1;
		}
		return null;
	}

	public List <Address> getAllAddress()
	{
		AddressDaoImp daoImp= new AddressDaoImp();
		List<Address> address=daoImp.getAllAddress();

		if(address != null)
		{
			return address;
		}
		return null;
	}
}
