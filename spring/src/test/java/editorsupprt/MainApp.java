package editorsupprt;

import com.gavin.editorsupport.DateBean;
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
    public void testDateBaean(){
        ApplicationContext context = getApplicationContext();
        DateBean dateBean = (DateBean)context.getBean("dateBean");
        System.out.println(dateBean.getDate());
    }

    @Test
    public void testDateBaean1(){
        ApplicationContext context = getApplicationContext();
        DateBean dateBean = (DateBean)context.getBean("dateBean1");
        System.out.println(dateBean.getDate());
    }
}
