package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.User;

public interface UserDao 
{
	public User saveUser (User user );

	public User getUser (int uid);

	public boolean deleteUser (int uid);

	public User updateUser (int uid,User user);
	
	public List<User> getAllUser();
	
	public List<User> getUserByRole(String role); 
}
