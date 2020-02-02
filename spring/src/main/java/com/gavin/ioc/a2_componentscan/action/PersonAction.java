package com.gavin.ioc.a2_componentscan.action;

import com.gavin.ioc.a2_componentscan.service.IPersonService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Controller@Lazy(false)
public class PersonAction implements InitializingBean, DisposableBean {

    @Resource(name="personService")
    IPersonService personService;

    public void show(){
        personService.show();
    }

    public PersonAction(){
        System.out.println("PersonAction 构造函数……");
    }
    public void myInit(){
        System.out.println("PersonAction init-Method方法……");
    }

    public void myDestroy(){
        System.out.println("PersonAction detroy-Method方法……");
    }
    @PostConstruct
    public void init(){
        System.out.println("PersonAction @PostConstruct初始化……");
    }

    @PreDestroy
    public void predestroy(){
        System.out.println("PersonAction @PreDestroy销毁……");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PersonAction InitializingBean接口初始化……");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("PersonAction DisposableBean接口初始化……");
    }
}
