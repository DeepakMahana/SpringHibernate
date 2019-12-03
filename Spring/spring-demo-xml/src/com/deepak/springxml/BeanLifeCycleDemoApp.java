package com.deepak.springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// Load the Spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// Retrieve bean from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// Close the context
		context.close();
	}

}
