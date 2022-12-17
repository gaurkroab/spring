package com.gk.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.sbeans.VotingEligibilityCheck;

public class SpringBeanLifecycleTest {

	public static void main(String[] args) {
		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		System.out.println("__________________________");
		// get spring bean class object
		VotingEligibilityCheck vec = ctx.getBean("vec",VotingEligibilityCheck.class);
		
		try {
			// invoke the b.method
			String result = vec.checkVotingEligibility();
			System.out.println(result);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		System.out.println("______________________");
		// close the container
		ctx.close();

	}

}
