package com.gavin.ioc.a1_hello.bean;

public class InitDestroyBean {
    public InitDestroyBean(){
        System.out.println("InitDestroyBean 执行了构造方法……");
    }
    private void init(){
        System.out.println("InitDestroyBean 执行了初始化方法……");
    }
    public void destroy(){
        System.out.println("执行了销毁方法……");
    }
}
