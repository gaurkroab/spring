package com.gk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.IEmployeeDAO;
import com.gk.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;
	@Override
	public Employee fetchEmployeeById(int eno) {
		// use dao
		Employee emp = dao.getEmpDetailsById(eno);
		return emp;
	}
	
	@Override
	public List<Employee> fetchEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<Employee> list = dao.getEmpDetailsByDesgs(desg1, desg2, desg3);
		return list;
	}

}
