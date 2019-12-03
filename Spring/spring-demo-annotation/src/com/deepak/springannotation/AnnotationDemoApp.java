package com.deepak.springannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	
	public static void main(String[] args) {
		
		// Read Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the Bean from Spring Container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
