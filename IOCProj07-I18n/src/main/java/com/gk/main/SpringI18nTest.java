package com.gk.main;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		System.out.println("main start");
		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// create Locale object
		System.out.println("ioc container created");
		Locale locale = new Locale(args[0],args[1]);
		System.out.println("locale obj created");
		// get message from th Locale specific or base properties file
		String msg1 = ctx.getMessage("welcome.msg", new Object[] {}, locale);
		System.out.println("msg1 ....");
		String msg2 = ctx.getMessage("goodbye.msg", new Object[] {}, locale);
		// display the mesage
		System.out.println(msg1 +"  " + msg2);
		// close the container
		ctx.close();
		System.out.println("main end");
	}

}
