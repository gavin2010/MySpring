package ioc.a7_required;

import com.gavin.ioc.a7_required.Student;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        Student student = (Student)context.getBean("student");
        System.out.println("成功获取Student Bean!");
    }
}
