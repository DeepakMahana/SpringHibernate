package com.deepak.springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the Spring Configuration File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// Retrieve bean from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach aplhaCoach = context.getBean("myCoach", Coach.class);
		
		// Check if they are same
		boolean result = (theCoach == aplhaCoach);
		
		// Print the Result
		System.out.println("\n Pointing to the same object : " + result);
		System.out.println("\n The memory location for theCoach : " + theCoach);
		System.out.println("\n The memory location for alphaCoach : " + aplhaCoach);
		
		// Close the context
		context.close();
	}

}
