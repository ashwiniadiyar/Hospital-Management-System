package com.jsp.hospital_app.service;

import java.util.List;

import com.jsp.hospital_app.dao.imp.BranchDaoImp;
import com.jsp.hospital_app.dto.Branch;

public class BranchService 
{
	public void saveBranch(Branch branch,int hid)
	{
		BranchDaoImp daoImp= new BranchDaoImp();
		Branch branch1=daoImp.saveBranch(hid,branch);
		if(branch1!=null)
		{
			System.out.println("data saved");
		}
		else
		{
			System.out.println("unfortunatley data not saved");
		}
	}

	public Branch getBranch(int bid)
	{
		BranchDaoImp daoImp= new BranchDaoImp();
		Branch branch1=daoImp.getBranch(bid);
		if(branch1 !=null)
		{
			return branch1;
		}
		return null;
	}

	public void deleteBranch(int bid)
	{
		BranchDaoImp daoImp= new BranchDaoImp();
		boolean result=daoImp.deleteBranch(bid);
		if(result==true)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}

	public Branch updateBranch(int bid,Branch branch)
	{
		BranchDaoImp daoImp= new BranchDaoImp();
		Branch branch1=daoImp.updateBranch(bid, branch);
		if(branch1 != null)
		{
			return branch1;
		}
		return null;
	}

	public List <Branch> getAllBranch()
	{
		BranchDaoImp daoImp= new BranchDaoImp();
		List<Branch> branch=daoImp.getAllBranch();

		if(branch != null)
		{
			return branch;
		}
		return null;
	}
}
