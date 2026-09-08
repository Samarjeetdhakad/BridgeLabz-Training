package com.fundoonotes.notes.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

	private static final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

	@Around("execution(* com.fundoonotes.notes.service.impl..*(..))")
	public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();

		Object result = joinPoint.proceed();

		long endTime = System.currentTimeMillis();

		long executionTime = endTime - startTime;

		log.info("{} executed in {} ms", joinPoint.getSignature().toShortString(), executionTime);

		return result;
	}
}
