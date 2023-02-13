package com.example.hibernate.aspects;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.hibernate.entity.book;

@Aspect
@Component
public class PerfectMethodTimeAspect {

	private final static Logger LOGGER=LoggerFactory.getLogger(PerfectMethodTimeAspect.class); 
	@Around("execution(* com.example.hibernate.*.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp)
	{
		String MethodName=pjp.getSignature().getName();
		Object classname=pjp.getTarget().getClass().toString();
		long startTime=System.currentTimeMillis();
		Object obj=null;
		try {
			obj=pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endtime =System.currentTimeMillis();
		long time=endtime-startTime;
		LOGGER.info("Taken time to excute method"+MethodName+"of the class"+classname+"is"+time);
		return obj;
	}
	@AfterReturning(pointcut = "execution (* com.example.hibernate..*(..))",
			returning = "obj")
	public ResponseEntity<Optional<book>> afterReturning( ResponseEntity<Optional<book>> obj) {
		ResponseEntity<Optional<book>> optional=null;
		LOGGER.info("Before Returning");
		if(obj instanceof ResponseEntity ) {
			LOGGER.info("obj is book type");
		 optional = (ResponseEntity<Optional<book>>)obj;
			LOGGER.info("After processing : "+optional);
		}
		LOGGER.info("After retruning");
		return optional;
	}
	
	
	
	
	/*@AfterReturning(pointcut="execution(* com.example.hibernate..*(..))",returning = "obj")
	public void afterreturning(Object obj)
	{
		LOGGER.info("Object in");
		if(true)
		{
		LOGGER.info("if in");	
		}
		LOGGER.info("after returning");
	}*/
	/*
	@AfterThrowing(pointcut = "execution (* com.slokam.SpringbootHibernate2...*(..))",
	throwing = "exp" )
	public void afterThrowing(Exception exp) {
		
	}*/
	
}
