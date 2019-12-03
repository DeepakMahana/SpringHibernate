package com.deepak.springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	
	public static void main(String[] args) {
		
		// Load Spring Config File
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = ctx.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		ctx.close();
	}
}
