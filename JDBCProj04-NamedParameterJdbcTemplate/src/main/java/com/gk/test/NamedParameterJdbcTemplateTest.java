package com.gk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.model.Employee;
import com.gk.service.IEmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get service class obj
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		// invoke the method
		try {
			System.out.println("emp name :: " + service.fetchEmpByNameById(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------");
		
		try {
				service.fetchEmpsByDesgs("CLERK", "MANAGER", "SALESMAN").forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("------------------------------------------------");
		try {
			String msg = service.registerEmployee(new Employee(100,"gaurav","DEVELOPER",60000.0f));
			System.out.println(msg);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		// colse the container
		ctx.close();
	}
}
