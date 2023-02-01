package com.gk.service;

import java.util.List;

import com.gk.model.Employee;

public interface IEmployeeMgmtService {
	public String fetchEmpByNameById(int id);
	public List<Employee> fetchEmpsByDesgs(String desg1,String desg2,String desg3);
	public String registerEmployee(Employee emp);
}
