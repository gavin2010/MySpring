package com.gavin.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String userName = "gavin";
    private Integer age = 23;
    private String sex = "男";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
