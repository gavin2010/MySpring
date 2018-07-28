package hello;

import com.gavin.hello.bean.HelloSpring;
import com.gavin.hello.bean.HelloWorld;
import com.gavin.hello.bean.InitDestroyBean;
import com.gavin.hello.beanfactoy.UserBean;
import com.gavin.hello.writespring.MySpring;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    public void testHelloWorld(){
        HelloWorld helloWorld = (HelloWorld)getApplicationContext().getBean("helloWorld");
        helloWorld.sayhello();
    }

    @Test
    public void testXmlApp(){
        HelloSpring helloSpring = (HelloSpring)getApplicationContext().getBean("helloSpring");
        System.out.println(helloSpring.getMessage());
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext context = getApplicationContext();
        UserBean bean1 = (UserBean)context.getBean("userBean1");
        UserBean bean2 = (UserBean)context.getBean("userBean2");
        UserBean bean3 = (UserBean)context.getBean("userBean3");
    }

    @Test
    public void testMyWriteSpring(){
        MySpring spring = new MySpring("app-context.xml");
        Object obj = spring.getBean("helloWorld");
        HelloWorld helloWorld = (HelloWorld)obj;
        helloWorld.sayhello();
    }

    @Test
    public void testLazyInit(){
        ApplicationContext context = getApplicationContext();
        System.out.println("获取上下文……");
        UserBean bean = (UserBean)context.getBean("userBean");
    }

    @Test  //默认是单实例
    public void testSingle(){
        ApplicationContext context = getApplicationContext();
        UserBean bean = (UserBean)context.getBean("userBean");
        UserBean bean1 = (UserBean)context.getBean("userBean");
        System.out.println(bean == bean1);
    }

    @Test
    public void testInitDestroy(){
        //初始化方法为私有的也可以执行
        ApplicationContext context = getApplicationContext();
        InitDestroyBean bean = (InitDestroyBean)context.getBean("initDestoryBean");

        //必须显示调用destroy方法，才会触发消费方法
        bean.destroy();
    }

}
