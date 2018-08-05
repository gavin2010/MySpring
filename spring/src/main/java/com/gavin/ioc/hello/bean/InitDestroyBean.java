package com.gavin.ioc.hello.bean;

public class InitDestroyBean {
    private void init(){
        System.out.println("执行了初始化方法……");
    }
    public void destroy(){
        System.out.println("执行了销毁方法……");
    }
}
