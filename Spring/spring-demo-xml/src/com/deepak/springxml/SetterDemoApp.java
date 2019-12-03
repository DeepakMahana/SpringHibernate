package com.deepak.springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// Load the Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from Spring Container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call Methods on the Bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// Call our methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// Close Context
		context.close();
	}

}
