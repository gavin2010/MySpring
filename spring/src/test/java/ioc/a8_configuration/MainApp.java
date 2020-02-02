package ioc.a8_configuration;

import com.gavin.ioc.a8_configuration.HelloWorldConfig;
import com.gavin.ioc.a1_hello.bean.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    @Test
    public void configurationTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("myHelloWorld");
        helloWorld.sayhello();

        //若HelloWorldConfig中没有添加@import注解，则下面代码也会执行
        HelloWorld helloWorld1 = (HelloWorld)context.getBean("configAgetHelloWorld");
        helloWorld1.sayhello();

    }

    @Test
    public void annotationContext(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
    //    HelloWorld helloWorld =  context.getBean(HelloWorld.class);
        HelloWorld helloWorld = (HelloWorld)context.getBean("myHelloWorld");
        helloWorld.sayhello();
        //若HelloWorldConfig中没有添加@import注解，则下面代码执行会报错
        HelloWorld helloWorld1 = (HelloWorld)context.getBean("configAgetHelloWorld");
        helloWorld1.sayhello();
    }

    @Test
    public void annotationRegister(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HelloWorldConfig.class);
        context.refresh();//必须添加刷新操作
      //  HelloWorld helloWorld =  context.getBean(HelloWorld.class);
        HelloWorld helloWorld = (HelloWorld)context.getBean("myHelloWorld");
        helloWorld.sayhello();
    }

    @Test
    public void importTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
        HelloWorld helloWorld = (HelloWorld)context.getBean("configAgetHelloWorld");
        helloWorld.sayhello();
        context.registerShutdownHook();//不添加这句不会输出销毁方法
    }
}
