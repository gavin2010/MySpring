package aop;

import com.gavin.aop.annotation.IUserManager;
import com.gavin.aop.xmlconfig.ApoSayHello;
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


    @Test
    public void aopAnnotation(){
        IUserManager inspector = (IUserManager)getApplicationContext().getBean("userManager");
        inspector.addUser("jack","123");
    }


    @Test
    public void aopXmlConfig(){
        ApoSayHello inspector = (ApoSayHello)getApplicationContext().getBean("sayHello");
        inspector.sayHello();
    }
}
