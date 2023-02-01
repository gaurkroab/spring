package com.gk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.IEmployeeDAO;
import com.gk.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Override
	public String registerEmployee(Employee emp) {
		// use DAO
		int count = empDAO.insert(emp);
		return count==0?"Employee is not registered" : " Employee is registered";
		
	}

}
