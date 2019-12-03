package com.deepak.springannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // prototype
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define default constructor
	public TennisCoach() {
		System.out.println("Inside Default Constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach : Inside DoMyStartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyDestroyStuff() {
		System.out.println("TennisCoach : Inside doMyDestroyStuff");
	}
	
	// Define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("Inside Fortune Setter");
//		this.fortuneService = fortuneService;
//	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	

}
