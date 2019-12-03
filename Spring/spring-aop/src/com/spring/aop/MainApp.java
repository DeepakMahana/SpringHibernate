package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAcc = new Account();
		theAccountDAO.addAccount(myAcc, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}

}
