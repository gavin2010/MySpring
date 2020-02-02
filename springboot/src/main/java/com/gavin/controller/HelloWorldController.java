package com.gavin.controller;

import com.gavin.bean.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {
    //#用于获取properties等配置文件的值
    @Value("${jdbc.username}")
    private String userName;

    //#用于获取bean中属性的值
    @Value("#{student.userName}")
    private String sUserName;

    @Resource
    private Student student;

    //random.value,random.int,random.long,random.int(10),random.int[10,20]
    @Value("${random.int}")
    private int randomInt;

    @RequestMapping("/")
    public String sayHello(){
        return "Hello,World!";
    }

    @GetMapping("/getValue")
    public String getValue(){
        return userName;
    }

    @GetMapping("/getValue1")
    public String getValue1(){
        return sUserName;
    }

    @GetMapping("/getBean")
    public String getBean(){
        return student.getUserName();
    }

    @GetMapping("/getRandomInt")
    public String getRandomInt(){
        return String.valueOf(randomInt);
    }
}
