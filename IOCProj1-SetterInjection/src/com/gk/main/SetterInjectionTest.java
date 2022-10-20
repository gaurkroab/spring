package com.gk.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gk.sbeans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main() (start)");
		// create the IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/gk/cfgs/applicationContext.xml");
		// get Target spring bean class obj
		Object obj =  ctx.getBean("wmg");
		// typecasting
		WishMessageGenerator generator = (WishMessageGenerator)obj;
		// invoke the business method
		String result = generator.showWishMessage("Gaurav");
		// display the result 
		System.out.println(result);
		// close the IOC container 
		 ctx.close();

	}

}
