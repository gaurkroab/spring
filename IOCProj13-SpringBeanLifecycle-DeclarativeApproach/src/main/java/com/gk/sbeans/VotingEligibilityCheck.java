package com.gk.sbeans;

import java.util.Date;

public class VotingEligibilityCheck {
	// spring bean properties
	private String name;
	private int age;
	private Date verifiedOn;
	 
	public VotingEligibilityCheck() {
		System.out.println("VotingEligibilityCheck.0-param constructor");
	}

	public void setName(String name) {
		System.out.println("VotingEligibilityCheck.setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("VotingEligibilityCheck.setAge()");
		this.age = age;
	}
	public void setVerifiedOn(Date verifiedOn) {
		System.out.println("VotingEligibilityCheck.setVerifiedOn()");
		this.verifiedOn = verifiedOn;
	}
	
	public String checkVotingEligibility() {
		System.out.println("VotingEligibilityCheck.checkVotingEligibility() (Business method)");
		if(age<18) {
			return "Mr/Mrs/Miss.  "+name+"u r not eligible for voting on date::"+verifiedOn;
		}else {
			return "Mr/Mrs/Miss.  "+name+"u r  eligible for voting on date::"+verifiedOn;
		}
	}
	public void myInit() {
		System.out.println("VotingEligibilityCheck.myInit()");
		// initialize the left over properties
		verifiedOn = new Date();
		// check wheather important properties are cfg with correct values or not
		if(name==null || name.trim().length()==0 || age<=0) {
			throw new IllegalArgumentException("invalid values are injected for spring bean properties(name,age)");
		}
	}
	public void myDestroy() {
		System.out.println("VotingEligibilityCheck.myDestroy()");
		// nullify the spring bean properties
		name=null;
		age=0;
	}
	
	
}
