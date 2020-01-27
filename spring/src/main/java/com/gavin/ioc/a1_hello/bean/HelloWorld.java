package com.gavin.ioc.a1_hello.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    public void sayhello(){
        System.out.println("Hello World!");
    }

    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        context.registerShutdownHook();
        context.start();
    }

    public void init(){
        //System.out.println("HelloWorld init 方法");
    }

    public void cleanup(){
       // System.out.println("HelloWorld clean 方法");
    }
}
