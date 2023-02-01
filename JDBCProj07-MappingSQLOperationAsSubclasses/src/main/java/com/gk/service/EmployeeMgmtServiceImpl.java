package com.gk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.IEmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public String fetchEmpNameByNo(int no) {
		// use dao
		return dao.getEmpNameByNo(no);
	}

}
