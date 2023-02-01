package com.gk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.IEmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO empDAO;
	@Override
	public String login(String user, String pass) {
		// use DAO
		
		return empDAO.authenticate(user, pass);
	}

}
