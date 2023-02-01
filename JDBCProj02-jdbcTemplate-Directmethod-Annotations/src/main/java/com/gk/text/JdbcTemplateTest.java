package com.gk.text;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.service.IEmployeeMgmtService;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get Spring Bean class obj (service class obj)
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		/*try {
			System.out.println("Employee count :: "+ service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("----------------------------------------");
		
		try {
			System.out.println("Employee name for given EmpNo ::  "+ service.fetchEmpNameByEmpNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		*/		
		System.out.println("----------------------------------------------");
		try {
			System.out.println("Employee Detail :: "+service.fetchEmpDetailsByEmpNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------------");
		try {
			//System.out.println("Employees Details by Desgs :: "+service.fetchEmpDetailsByDesgs("CLERK","MANAGER","ANALYST"));
			System.out.println("Employees Details by Desgs :: ");
			service.fetchEmpDetailsByDesgs("CLERK","MANAGER","ANALYST").forEach(map->System.out.println(map));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		 
		/*	System.out.println("-------------------------");
			try {
				System.out.println(service.depositeSalaryWithBonusByDesgs(10000, "CLERK", "SALESMAN"));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}*/
		
		/*System.out.println("-------------------------------");
		try {
			System.out.println(service.fireEmpsOfOnBench());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
		
	     System.out.println("--------------------------------");
	     try {
	    	 System.out.println(service.registerEployee("sachin", "CLERK", 50000));
	     }
	     catch(DataAccessException dae) {
	    	 dae.printStackTrace();
	     }
		// close container
		ctx.close();

	}

}
