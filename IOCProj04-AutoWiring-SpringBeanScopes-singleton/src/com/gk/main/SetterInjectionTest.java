package com.gk.main;

import java.time.LocalDateTime;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.gk.sbeans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main() (start)");
		// create the IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/gk/cfgs/applicationContext.xml");
		// case 1
		// get Target spring bean class obj
		/*LocalDateTime dt1 = ctx.getBean("ldt",LocalDateTime.class);
		LocalDateTime dt2 = ctx.getBean("ldt",LocalDateTime.class);
		System.out.println(dt1.hashCode()+"    "+dt2.hashCode());// gives the same hashcode
		System.out.println("(dt1==dt2?) "+(dt1==dt2)); // returns true
		*/
		// case 2 gives exception
		
		System.out.println("==================================");
		LocalDateTime dt1 = ctx.getBean("ldt",LocalDateTime.class);
		LocalDateTime dt2 = ctx.getBean("ldt",LocalDateTime.class);
		System.out.println(dt1.hashCode()+"    "+dt2.hashCode());
		System.out.println("(dt1==dt2?) "+(dt1==dt2));
		

		System.out.println("==================================");
		LocalDateTime dt3 = ctx.getBean("ldt1",LocalDateTime.class);
		LocalDateTime dt4 = ctx.getBean("ldt1",LocalDateTime.class);
		System.out.println(dt3.hashCode()+"    "+dt4.hashCode());
		System.out.println("(dt3==dt4?) "+(dt3==dt4));
		
		
		// close the IOC container 
		 ctx.close();

	}

}
