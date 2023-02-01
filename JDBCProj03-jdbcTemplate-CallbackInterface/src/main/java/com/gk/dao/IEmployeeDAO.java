package com.gk.dao;

import java.util.List;

import com.gk.model.Employee;

public interface IEmployeeDAO {
	public Employee getEmpDetailsById(int eno);
	public List<Employee> getEmpDetailsByDesgs(String desg1,String desg2,String desg3);
}
