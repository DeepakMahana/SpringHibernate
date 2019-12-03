package com.deepak.springannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
	
	public static void main(String[] args) {
		
		// Read Spring Config from Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the Bean from Spring Container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Call our new swim coach methods ...
		// Has the props value injected
		System.out.println("Email : " + theCoach.getEmail());
		System.out.println("Team : " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
