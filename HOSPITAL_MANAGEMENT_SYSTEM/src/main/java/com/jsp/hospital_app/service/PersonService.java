package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.PersonDaoImp;
import com.jsp.hospital_app.dto.Person;

public class PersonService
{
	public void savePerson(int eid,Person Person)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		Person Person1=daoImp.savePerson(eid,Person);
		if(Person1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}
	
	public Person getPerson(int pid)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		Person Person=daoImp.getPerson(pid);
		if(Person !=null)
		{
			return Person;
		}
		return null;
	}
	
	public void deletePerson(int pid)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		boolean result=daoImp.deletePerson(pid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Person updatePerson(int pid,Person Person)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		Person Person1=daoImp.updatePerson(pid,Person);
		if(Person1!= null)
		{
			return Person1;
		}
		return null;
	}
	
	public List <Person> getAllPerson()
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		List<Person> Person=daoImp.getAllPerson();
		
		if(Person!= null)
		{
			return Person;
		}
		return null;
	}
	
	public List <Person> getAllPersonByGender(String gender)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		List<Person> person=daoImp.getAllPersonByGender(gender);
		
		if(person!= null)
		{
			return person;
		}
		return null;
	}
	
	public List <Person> getAllPersonByAge(int age)
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		List<Person> person=daoImp.getAllPersonByAge(age);
		
		if(person!= null)
		{
			return person;
		}
		return null;
	}
	
	public List <Person> getAllPersonByPhone(long phone) 
	{
		PersonDaoImp daoImp= new PersonDaoImp();
		List<Person> person=daoImp.getAllPersonByPhone(phone);
		
		if(person!= null)
		{
			return person;
		}
		return null;
	}
}
