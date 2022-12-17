package com.gk.sbeans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("vec")
public class VotingElgibilityCheck implements InitializingBean,DisposableBean {
	// spring bean properties
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private int age;
	private Date verifiedOn;
	
	public VotingElgibilityCheck() {
		System.out.println("VotingElgibilityCheck.0-parm constructor");
	}
	
	// b.method
	public String checkVotingElgibility() {
		System.out.println("VotingElgibilityCheck.checkVotingElgibility() (Business method)");
		if(age<18) {
			return "Mr/Mrs/miss." + name + " u r not eligible for voting on date::"+verifiedOn;
		}else {
			return "Mr/Mrs/miss." + name + " u r  eligible for voting on date::"+verifiedOn;
		}
	}
	
	@Override
	public void destroy()  throws Exception {
		System.out.println("VotingElgibilityCheck.destroy()");
		// nullify the spring bean properties
		name=null;
		age=0;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("VotingElgibilityCheck.afterPropertiesSet()");
		// initialize the left over properties 
		verifiedOn = new Date();
		// check wheather important properties are cfg with correct values or not
		if(name==null || name.trim().length()==0 || age<=0) {
			throw new IllegalArgumentException("invalid values are injected for spring bean properties(name,age)");
		}
	}
}
