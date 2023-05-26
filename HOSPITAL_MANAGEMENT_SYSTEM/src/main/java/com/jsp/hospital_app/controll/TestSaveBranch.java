package com.jsp.hospital_app.controll;

import com.jsp.hospital_app.dto.Branch;
import com.jsp.hospital_app.service.BranchService;

public class TestSaveBranch {

	public static void main(String[] args) 
	{
		Branch branch=new Branch();
		BranchService service=new BranchService();
		branch.setName("bapuji branch1");
		branch.setPhone(87654322);
		branch.setEmail("advb@gmail.com");
		service.saveBranch(branch, 2);
	}

}
