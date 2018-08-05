package com.gavin.ioc.hello.beanfactoy;

public class BeanFactory {
    //使用静态工厂实例化bean
    public static UserBean userBeanService(){
        return new UserBean();
    }

    //通过实例工厂实例化bean
    public UserBean getUserBeanService(){
        return new UserBean();
    }
}
