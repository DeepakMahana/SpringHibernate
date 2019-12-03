package com.deepak.springxml;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// Add New fields for emailAddress and team
	private String emailAddress;
	private String team;

	// Create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// Our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// Getter and Setter Methods
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method for setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method for setTeam");
		this.team = team;
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

}
