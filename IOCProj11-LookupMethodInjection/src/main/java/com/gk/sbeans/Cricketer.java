package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("cktr")
public abstract class Cricketer {
	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor:");
	}
	// @Lookup("cBat")
	@Lookup
	public abstract CricketBat getBat();
	
	// special method
	public String batting() {
		// get dependent class object (internally uses the IOC container dependency lookup code of proxy class) 
		CricketBat bat=getBat();
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
