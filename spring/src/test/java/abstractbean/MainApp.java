package abstractbean;

import com.gavin.abstractbean.UserInfoBean;
import com.gavin.hello.beanfactoy.UserBean;
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
    public void testAbstractBean(){
        ApplicationContext context = getApplicationContext();
        UserInfoBean bean1 = (UserInfoBean)context.getBean("userInfoBean1");
        System.out.println(bean1);
        UserInfoBean bean2 = (UserInfoBean)context.getBean("userInfoBean2");
        System.out.println(bean2);
    }
}
