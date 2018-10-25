package com.romain.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	// lets start with an @Before advice
	
	@Pointcut("execution(* com.romain.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.romain.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.romain.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNogetterSetter() {}
	
	@Before("forDaoPackageNogetterSetter()")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNogetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Performing API analytics");
	}
		
}
