package com.gk.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.gk.model.Employee;
import com.gk.service.IEmployeeMgmtService;

public class CallbackInterfaceTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get service class object
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		// invoke the method
		try {
			Employee emp = service.fetchEmployeeById(7499);
			System.out.println(emp);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("Record not found or Problem in retrieving the record");
		}
		try {
		List<Employee> listemp = service.fetchEmployeeByDesgs("CLERK", "MANAGER", "SALESMAN");
		listemp.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		// close the container
		ctx.close();

	}// main

}// class
