package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.UserDaoImp;
import com.jsp.hospital_app.dto.User;

public class UserService 
{
	public void saveUser(User User)
	{
		UserDaoImp daoImp= new UserDaoImp();
		User User1=daoImp.saveUser(User);
		if(User1 !=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}

	public User getUser(int uid)
	{
		UserDaoImp daoImp= new UserDaoImp();
		User User1=daoImp.getUser(uid);
		if(User1 !=null)
		{
			return User1;
		}
		return null;
	}

	public void deleteUser(int uid)
	{
		UserDaoImp daoImp= new UserDaoImp();
		boolean result=daoImp.deleteUser(uid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		System.out.println("data not found");
	}

	public User updateUser(int uid,User User)
	{
		UserDaoImp daoImp= new UserDaoImp();
		User User1=daoImp.updateUser(uid, User);
		if(User1 != null)
		{
			return User1;
		}
		return null;
	}
	
	public List <User>   getAllUser()
	{
		UserDaoImp daoImp= new UserDaoImp();
		List<User> User=daoImp.getAllUser();
		
		if(User!= null)
		{
			return User;
		}
		return null;
	}
	
	public List <User>  getUserByRole(String role) 
	{
		UserDaoImp daoImp= new UserDaoImp();
		List<User> User=daoImp.getUserByRole(role);
		
		if(User!= null)
		{
			return User;
		}
		return null;
	}
}
