package com.nemo.modul9homework7.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceLoggingAspect {

    @Before("execution(* *(..)) && @within(org.springframework.stereotype.Service)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Service method: " + joinPoint.getSignature().getName() + " started");
    }

    @AfterReturning("execution(* *(..)) && @within(org.springframework.stereotype.Service)")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Service method: " + joinPoint.getSignature().getName() + " completed");
    }

    @AfterThrowing(pointcut = "execution(* *(..)) && @within(org.springframework.stereotype.Service)", throwing = "error")
    public void logException(JoinPoint joinPoint, Throwable error) {
        System.out.println("Exception in service method: " + joinPoint.getSignature().getName() + " error: " + error);
    }
}

