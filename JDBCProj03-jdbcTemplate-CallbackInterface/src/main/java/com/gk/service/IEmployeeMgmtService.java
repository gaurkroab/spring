package com.gk.service;

import java.util.List;

import com.gk.model.Employee;

public interface IEmployeeMgmtService {
	public Employee fetchEmployeeById(int eno);
	public List<Employee> fetchEmployeeByDesgs(String desg1,String desg2,String desg3);
}
