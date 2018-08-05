package com.gavin.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("inspector")
@Aspect
public class Inspector {

    @Pointcut("execution(* com.gavin.aop.annotation.UserManagerImpl.*(..))")
    private void anyMethod(){ //定义切入点

    }

    @Before("anyMethod()") //括号内为切入点名称
    @Order(1)
    public void doBefore()
    {
           System.out.println("----------------执行Before通知-----------------");
    }

    @AfterReturning("anyMethod()")
    @Order(3000)
    public void doAfterReturning()
    {
        System.out.println("----------------执行AfterReturning通知-----------------");
    }

    @After("anyMethod()") //括号内为切入点名称
    @Order(1000)
    public void doAfter()
    {
        System.out.println("----------------执行After通知-----------------");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrowing()
    {
        System.out.println("----------------执行AfterThrowing通知-----------------");
    }

    @Around("anyMethod()")
    @Order(200)
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("----------------进入Around前置通知-----------------");
        Object result=pjp.proceed();  //该方法必须被执行
        System.out.println("----------------执行Around后置通知-----------------");
        return result;
    }

}
