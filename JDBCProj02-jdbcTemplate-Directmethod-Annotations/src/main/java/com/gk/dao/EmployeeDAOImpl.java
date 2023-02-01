package com.gk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_NAME_BY_EMPNO = "SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_EMPNO = "SELECT  * FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_DESGS = "SELECT  EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB ";
	private static final String DELETE_EMPS_WHITH_NO_DEPTNO="DELETE FROM EMP WHERE DEPTNO IS NULL";
	private static final String UPDATE_EMP_SALARY_BY_DESGS="UPDATE EMP SET SAL=SAL+? WHERE JOB IN(?,?)";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(EMPNO_SEQ.NEXTVAL,?,?,?)";
	@Autowired
	private JdbcTemplate jt;
	
	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public int getEmpsCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}
	
	@Override
	public String getEmpNameByEmpNo(int eno) {
		String name = jt.queryForObject(GET_EMP_NAME_BY_EMPNO,String.class,eno);
		return name;
	}

	@Override
	public Map<String, Object> getEmpDetailsByEmpNo(int eno) {
		Map<String,Object> map = jt.queryForMap(GET_EMP_DETAILS_BY_EMPNO,eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> empList = jt.queryForList(GET_EMP_DETAILS_BY_DESGS, desg1,desg2,desg3);
		return empList;
	}
	
	@Override
	public int deleteEmpsNotHavingDeptNo() {
		int count = jt.update(DELETE_EMPS_WHITH_NO_DEPTNO);
		return count;
	}
	
	@Override
	public int addBonusToEmployeeByDesgs(String desg1, String desg2, float bonus) {
		int count = jt.update(UPDATE_EMP_SALARY_BY_DESGS, bonus,desg1,desg2);
		return count;
	}
	
	@Override
	public int insertEmployee(String ename, String desg, float salary) {
		 int count = jt.update(INSERT_EMPLOYEE,ename,desg,salary);
		return count;
	}
}
