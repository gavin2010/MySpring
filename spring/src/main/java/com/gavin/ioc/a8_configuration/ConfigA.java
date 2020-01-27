package com.gavin.ioc.a8_configuration;

import com.gavin.ioc.a1_hello.bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigA {

    @Bean
    @Scope("prototype")
    public HelloWorld configAgetHelloWorld(){
        return new HelloWorld();
    }
}
