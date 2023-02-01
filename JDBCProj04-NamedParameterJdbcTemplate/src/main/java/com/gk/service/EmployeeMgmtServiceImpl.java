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
	public String fetchEmpByNameById(int id) {
		// use dao
		return dao.getEmpNameByNo(id);
	}
	
	@Override
	public List<Employee> fetchEmpsByDesgs(String desg1, String desg2, String desg3) {
		List<Employee> list = dao.getEmpDetailsByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	@Override
	public String registerEmployee(Employee emp) {
		int count = dao.insertEmployee(emp);
		return count==0?"Employee not registered" : "Employee registered";
	}

}
