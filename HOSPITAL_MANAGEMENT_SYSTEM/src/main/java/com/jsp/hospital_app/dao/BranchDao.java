package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Branch;

public interface BranchDao 
{
	public Branch saveBranch(int hid,Branch branch);
	
	public Branch getBranch(int bid);
	
	public boolean deleteBranch(int bid);
	
	public Branch updateBranch(int bid,Branch branch);
	
	public List<Branch> getAllBranch();
	
}
