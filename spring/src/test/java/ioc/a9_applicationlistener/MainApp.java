package ioc.a9_applicationlistener;

import com.gavin.ioc.a9_applicationlistener.MyHello;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        context.start();
      //  context.refresh();  //启动后，就没有刷新语句输出
        MyHello myHello = (MyHello)context.getBean("myHello");
        myHello.getMessage();
        context.stop();
        context.close();
    }
}
