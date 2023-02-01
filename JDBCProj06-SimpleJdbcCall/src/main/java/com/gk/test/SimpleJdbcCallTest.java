package com.gk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.service.IEmployeeMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get service class obj
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		// invoke the method
		try {
			String result = service.login("aksah", "raipur");
			System.out.println(result);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		// close the container
		ctx.close();

	}

}
