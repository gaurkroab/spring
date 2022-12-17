package com.gk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.sbeans.VotingElgibilityCheck;

public class SpringBeanLifecycleTest {

	public static void main(String[] args) {
		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		System.out.println("____________________________");
		// get spring bean class object 
		VotingElgibilityCheck vec = ctx.getBean("vec",VotingElgibilityCheck.class);
		try {
		// invoke the b.method
			String result = vec.checkVotingElgibility();
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("_______________________________");
		// close the container
		ctx.close();
	}

}
