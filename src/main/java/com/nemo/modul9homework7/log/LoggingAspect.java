package com.nemo.modul9homework7.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing method: " + joinPoint.getSignature().getName());
    }

    @After("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Completed method: " + joinPoint.getSignature().getName());
    }
}

