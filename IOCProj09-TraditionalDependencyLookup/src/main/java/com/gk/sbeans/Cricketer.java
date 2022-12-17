package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("cktr")
public class Cricketer  {
	
	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor:");
	}
	
	// special method
	public String batting() {
		 // create additional IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/gk/cfgs/applicationContext.xml");
		// get Dependent spring bean class object (Dependency lookup)
		CricketBat bat = ctx.getBean("cBat",CricketBat.class);
		// uses the dependent object
		int runs = bat.scoreRuns();
		return "Cricketer is batiing"+bat.scoreRuns();
	}
	public String bowling() {
		return "Cricketer is bowling";
	}
	public String wicketKeeping() {
		return "Cricketer is keeping the wickets";
	}
	public String fielding() {
		return "Cricketer is fielding the ball";
	}
	
}
