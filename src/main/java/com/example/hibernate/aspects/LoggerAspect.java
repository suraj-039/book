package com.example.hibernate.aspects;

import javax.persistence.criteria.Join;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

private final static Logger LOGGER=LoggerFactory.getLogger(LoggerAspect.class);

@Before("execution(* com.example.hibernate.*.*.*(..))")
public void before(JoinPoint jp)
{
	
	String methodName=jp.getSignature().getName();
	String ClassName=jp.getTarget().getClass().toString();
	LOGGER.info("Start Method"+methodName+ "Of the class"+ClassName);
}

@After("execution(* com.example.hibernate.*.*.*(..))")
public void after(JoinPoint jp)
{
	String methodName=jp.getSignature().getName();
	String ClassName=jp.getTarget().getClass().toString();
	LOGGER.info("End Method");
}

}

