package ioc.a5_autowire;

import com.gavin.ioc.a5_autowire.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private ApplicationContext getApplicationContext(){
        /**
         *  2种获取应用上下文的方式
         */

        //相对路径
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        //FileSystemXmlApplicationContext 是定位的结对路径
        // ApplicationContext context = new FileSystemXmlApplicationContext("F:\\JavaStudy\\JavaSpace\\Spring\\spring\\src\\main\\resources\\app-context.xml");

        return context;
    }

    //普通xml配置属性
    @Test
    public void xmlPerpertiesTest(){
        Person person = (Person)getApplicationContext().getBean("person");
        System.out.println(person);
    }


    @Test
    public void autowireProperty(){
        Person person = (Person) getApplicationContext().getBean("person1");
        System.out.println(person);
    }

    @Test
    public void autowireAutoProperty(){
        Person person = (Person) getApplicationContext().getBean("person2");
        System.out.println(person);
    }
}
