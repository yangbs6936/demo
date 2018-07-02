package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面
 *
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.example.demo.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doAfter(JoinPoint jp) {
        System.out.println("log Ending method: "
                + jp.getTarget().getClass().getName() + "."
                + jp.getSignature().getName());
    }
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long time = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        time = System.currentTimeMillis() - time;
        System.out.println("process time: " + time + " ms");
        return retVal;
    }
    public void doBefore(JoinPoint jp) {
        System.out.println("log Begining method: "
                + jp.getTarget().getClass().getName() + "."
                + jp.getSignature().getName());
    }
    public void doThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("method " + jp.getTarget().getClass().getName()
                + "." + jp.getSignature().getName() + " throw exception");
        System.out.println(ex.getMessage());
    }
    private void sendEx(String ex) {
        //TODO 发送短信或邮件提醒
    }
}