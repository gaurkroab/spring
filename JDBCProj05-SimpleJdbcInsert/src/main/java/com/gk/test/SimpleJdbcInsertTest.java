package com.gk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.model.Employee;
import com.gk.service.IEmployeeMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get service class obj 
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		// invoke the method
		try {
			Employee emp = new Employee(680,"Shrikant","CLERK",45555.0f);
			String msg = service.registerEmployee(emp);
			System.out.println(msg);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}

		// close the container
		ctx.close();
	}

}
