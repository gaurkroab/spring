package com.gk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.sbeans.Cricketer;

public class LookupMethodInjectionTest {

	public static void main(String[] args) {
		// Create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		System.out.println("__________________");
		// get Proxy class object
		Cricketer proxy = ctx.getBean("cktr",Cricketer.class);
		System.out.println(proxy.getClass()+"----"+proxy.getClass().getSuperclass());
		// invoke the b.methods
		System.out.println(proxy.batting());
		System.out.println(proxy.bowling());
		System.out.println(proxy.fielding());
		System.out.println("____________________");
		System.out.println(proxy.batting());

	}

}
