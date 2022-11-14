package com.gk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.sbeans.PersonInfo;

public class PropertiesFileTest {

	public static void main(String[] args) {
		// create IOC container
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		
		// get Spring bean class obj
		
		PersonInfo info = ctx.getBean("pinfo",PersonInfo.class);
		System.out.println(info);
		
		// close the container
		ctx.close();

	}

}
