package com.deepak.springannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean From Spring Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach aplhaCoach = context.getBean("tennisCoach", Coach.class);
		
		// Check if they are the same
		boolean result = (theCoach == aplhaCoach);
		
		// Print out the results
		System.out.println("\nPointing to the same object : " + result);
		
		System.out.println("\nMemory Location for the coach: " + theCoach);
		
		System.out.println("\nMemory Location for the alphaCoach : " + aplhaCoach + "\n");
		
		// Close the Context
		context.close();

	}

}
