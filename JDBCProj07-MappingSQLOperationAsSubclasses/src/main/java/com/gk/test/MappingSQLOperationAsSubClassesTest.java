package com.gk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.service.IEmployeeMgmtService;

public class MappingSQLOperationAsSubClassesTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get service class obj
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		// invoke method
		try {
			System.out.println("Employe name of 7499 :: "+service.fetchEmpNameByNo(7499));
			System.out.println("Employe name of 7900 :: "+service.fetchEmpNameByNo(79));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		// close the container
		ctx.close();
	}

}
