package ioc.a6_beanpostprocessor;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试时需要开启MyBeanPostProcessor类的Component注解
 */
public class MainApp {
    @Test
    public void beanPostProcessorTest(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

    }
}

