package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Person;

public interface PersonDao 
{
	public Person savePerson(int eid,Person person);

	public Person getPerson(int pid);

	public boolean deletePerson(int pid);

	public Person updatePerson(int oid,Person person);
	
	public List<Person> getAllPerson();
	
	public List<Person> getAllPersonByGender(String gender);
	
	public List<Person> getAllPersonByAge(int age);
	
	public List<Person> getAllPersonByPhone(long phone);
}
