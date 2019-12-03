package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": Doing Stuff : Adding a membership account");
	}

	public void addSillyMember() {
		System.out.println(getClass() + ": Doing Stuff : Adding a membership account");
	}

	public void goToSleep() {
		System.out.println(getClass() + ": Doing Stuff : Adding a membership account");
	}
}
