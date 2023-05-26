package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Address;

public interface AddressDao 
{
	public Address saveAddress(int bid,Address address);

	public Address getAddress(int aid);

	public boolean deleteAddress(int aid);

	public Address updateAddress(int aid,Address address);
	
	public List<Address> getAllAddress();
}
