package com.gavin.ioc.hello.bean;

import org.springframework.context.ApplicationContext;
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

}
