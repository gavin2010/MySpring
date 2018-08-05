package com.gavin.aop.xmlconfig;

import org.aspectj.lang.ProceedingJoinPoint;

public class SerciceAspect {

    public void doBefore(){
        System.out.println("---执行xml配置的Before通知---");
    }

    public void doAfterReturning(){
        System.out.println("---执行xml配置的AfterReturning通知---");
    }

    public void doAfter(){
        System.out.println("---执行xml配置的After通知---");
    }

    public void doAfterThrowing(){
        System.out.println("---执行xml配置的AfterThrowing通知---");
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("---执行xml配置的Around前置通知---");
        pjp.proceed();
        System.out.println("---执行xml配置的Around后置通知---");
        return null;
    }
}
