package ioc.a10_customerevent;

import com.gavin.ioc.a10_customevent.CustomEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        CustomEventPublisher publisher = (CustomEventPublisher)context.getBean("customEventPublisher");
        publisher.publish();
        publisher.publish();
    }
}
