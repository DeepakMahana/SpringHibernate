package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
		
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on method");
	}
	
//	@Before("forDaoPackage()")
//	public void performApiAnanlytics() {
//		System.out.println("\n====>>> Performing API Analytics");
//	}
//	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnanlytics() {
		System.out.println("\n====>>> Performing API Analytics");
	}
}
