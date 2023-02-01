package com.gk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gk.model.Employee;

@Repository("empDao")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMP_BY_EMPNO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB"; 
	@Autowired
	private JdbcTemplate jt;
	
	/*	@Override
		public Employee getEmpDetailsById(int eno) {
			Employee emp = jt.queryForObject(GET_EMP_BY_EMPNO, new EmployeeMapper(), eno);
			return emp;
		}
		
		// inner class (callback interface implementation)
		private class EmployeeMapper implements RowMapper<Employee>{
			@Override // call back method
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// copy the record of RS to Employee obj
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				return emp;
			} // method 
		}// class
	*/ 
	// or
	
	/*@Override
	public Employee getEmpDetailsById(int eno) {
		Employee emp=jt.queryForObject(GET_EMP_BY_EMPNO, // arg1
							new RowMapper<Employee>() { // arg2
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// copy the rocord of Rs to Employee obj
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				return emp;
				
			}// method
		}, // enonymous inner class
				eno); // arg3
		return emp;
	}*/
								// or
	
	@Override
	public Employee getEmpDetailsById(int eno) {
		Employee e = jt.queryForObject(GET_EMP_BY_EMPNO,
											(rs,rownum)-> {
												// copy the record of RS to Employee obj
												Employee emp =  new Employee();
												emp.setEmpno(rs.getInt(1));
												emp.setEname(rs.getString(2));
												emp.setJob(rs.getString(3));
												emp.setSal(rs.getFloat(4));
												emp.setDeptno(rs.getInt(5));
												return emp;
											}, 
											eno);
		return e;
	}
	
	@Override
	public List<Employee> getEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		List<Employee> empsList = jt.query(GET_EMPS_BY_DESGS,
															rs -> {
																// copy each records of RS to List of Model class
																List<Employee> listEmps = new ArrayList<Employee>();
																while(rs.next()) {
																	// copy each record of RS to one object Employee
																	Employee emp = new Employee();
																	emp.setEmpno(rs.getInt(1));
																	emp.setEname(rs.getString(2));
																	emp.setJob(rs.getString(3));
																	emp.setSal(rs.getFloat(4));
																	emp.setEmpno(rs.getInt(5));
																	// add each object of Model class ListCollection
																	listEmps.add(emp);
																}// while
																return listEmps;
															},
														    desg1,desg2,desg3);
		return empsList;
	}
}// outer class
