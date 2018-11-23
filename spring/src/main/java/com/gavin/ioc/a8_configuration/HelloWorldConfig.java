package com.gavin.ioc.a8_configuration;

import com.gavin.ioc.a1_hello.bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigA.class)
public class HelloWorldConfig {
    /**
     *
     *  等价于
     *  <beans>
     *      <bean id="myHelloWorld" class="com.gavin.ioc.a1_hello.bean.HelloWorld"/>
     *  </beans>
     *
     */

    @Bean(initMethod = "init",destroyMethod = "cleanup")
    public HelloWorld myHelloWorld(){
        return new HelloWorld();
    }
}
