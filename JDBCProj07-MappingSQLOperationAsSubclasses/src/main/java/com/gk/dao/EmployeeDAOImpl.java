package com.gk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_NAME_BY_NO="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private DataSource ds;
	EmployeeSelector1 selector1;
	
	@Autowired
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("EmployeeDAOImpl :: 0 param constructor");
		this.ds=ds;
		selector1=new EmployeeSelector1(ds, GET_EMP_NAME_BY_NO);
	}
	@Override
	public String getEmpNameByNo(int no) {
		System.out.println("EmployeeDAOImpl.getEmpNameByNo()");
		String name=selector1.findObject(no);
		return name;
	}
	
	// ==========inner classes as sub classes of MappingSQLQuery or SqlUpadate class=======
	
	private static class EmployeeSelector1 extends MappingSqlQuery<String>{
		public EmployeeSelector1(DataSource ds,String query) {
			super(ds,query);
			System.out.println("EmployeeDAOImpl.EmployeeSelector1.2 :: 2-param constructor");
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
		
		@Override
		protected String mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("EmployeeDAOImpl.EmployeeSelector1.mapRow()");
			String name=rs.getString(1);
			return name;
		}
	}

}
