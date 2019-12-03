package com.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Setup Pointcut declarations for Controller
	@Pointcut("execution(* com.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// Setup Pointcut declarations for Service
	@Pointcut("execution(* com.spring.service.*.*(..))")
	private void forServicePackage() {}
		
	// Setup Pointcut declarations for DAO
	@Pointcut("execution(* com.spring.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
		
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>in @Before : Calling Method : " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display args
		for(Object tempArg : args) {
			myLogger.info("===>> argument : " + tempArg);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @AferReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("===>> result: " + theResult);
	}
	

}
