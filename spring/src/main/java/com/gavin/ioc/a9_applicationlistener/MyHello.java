package com.gavin.ioc.a9_applicationlistener;

import org.springframework.stereotype.Component;

@Component
public class MyHello {
    private String message;

    public String getMessage() {
        System.out.println("MyHello message");
        return message;
    }

    public void setMessage(String message) {

    }
}
