package com.gk.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {
	public int fetchEmpsCount();
	public String fetchEmpNameByEmpNo(int eno);
	public Map<String,Object> fetchEmpDetailsByEmpNo(int eno);
	public List<Map<String,Object>> fetchEmpDetailsByDesgs(String desg1,String desg2,String desg3);
	public String fireEmpsOfOnBench();
	public String depositeSalaryWithBonusByDesgs(float bonusAmount,String desg1,String desg2);
	public String registerEployee(String ename, String job,float sal);
}
