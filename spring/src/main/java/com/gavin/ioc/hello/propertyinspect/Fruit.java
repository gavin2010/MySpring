package com.gavin.ioc.hello.propertyinspect;

import javax.annotation.Resource;

public class Fruit {
    //@Resource默认是按照名称装配，找不到与名称匹配的bean时按类型装配

    @Resource(name="apple")
    Apple apple;

  /*  @Resource
    Apple apple;*/


    public Fruit(){

    }
    public Fruit(Apple apple, int n){
        this.apple = apple;
      //  System.out.println("传入个数为："+n);
    }
    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
}
