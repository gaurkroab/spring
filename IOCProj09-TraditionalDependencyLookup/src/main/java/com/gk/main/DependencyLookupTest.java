package com.gk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.sbeans.Cricketer;

public class DependencyLookupTest {

	public static void main(String[] args) {
		// Create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		System.out.println("__________________");
		// get Proxy class object
		Cricketer cktr = ctx.getBean("cktr",Cricketer.class);
		// invoke the b.methods
		System.out.println(cktr.batting());
		System.out.println(cktr.bowling());
		System.out.println(cktr.fielding());
		System.out.println("____________________");
		System.out.println(cktr.batting());
		
		// close the container
		ctx.close();

	}

}
