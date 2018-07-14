package hellospring;

import com.gavin.hellospring.HelloSpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    @Test
    public void testXmlApp(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
        System.out.println(helloSpring.getMessage());
    }
    @Test
    public void testFileApp(){
        //FileSystemXmlApplicationContext 是定位的结对路径
        ApplicationContext context = new FileSystemXmlApplicationContext("F:\\JavaStudy\\JavaSpace\\Spring\\spring\\src\\main\\resources\\app-context.xml");
        HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
        System.out.println(helloSpring.getMessage());
    }

}
