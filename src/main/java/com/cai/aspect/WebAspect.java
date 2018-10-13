package com.cai.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class WebAspect {
    private static final String EXECUTION = "execution(* com.cai.controller..*.*(..))";
   // private static final String ANNOTATION = "@annotataion(com.cai.annotation.WebLogAnno)";

    @Pointcut(value = EXECUTION)
    public void point() {
    }


    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object target = joinPoint.getTarget();
        Object []args = joinPoint.getArgs();
        String signatureName = joinPoint.getSignature().getName();
        Object result = joinPoint.proceed();
        log.info("target = {} args = {} result = {}",target,args,result);
        return result;

    }

}
