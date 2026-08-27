package com.fundoo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

	private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

	@Around("execution(* com.fundoonotes.service..*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		long duration = System.currentTimeMillis() - start;

		logger.info("{} executed in {} ms", joinPoint.getSignature(), duration);

		return result;
	}
}
