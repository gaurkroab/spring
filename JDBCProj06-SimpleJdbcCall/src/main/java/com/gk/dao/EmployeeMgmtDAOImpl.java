package com.gk.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("empDAO")
public class EmployeeMgmtDAOImpl implements IEmployeeDAO {

	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authenticate(String user, String pass) {
		// specify PL/SQL procedure name
		sjc.setProcedureName("SPRING_AUTHENTICATION");
		Map<String,Object> inParams = Map.of("USERNAME",user,"PASSWORD",pass);
		Map<String,Object> outParams = sjc.execute(inParams);
		return (String) outParams.get("RESULT");
	}

}
