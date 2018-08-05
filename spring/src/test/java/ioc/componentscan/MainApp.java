package ioc.componentscan;

import com.gavin.ioc.componentscan.action.PersonAction;
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
    public void testServiceDao(){
        ApplicationContext context = getApplicationContext();

        //@Repository放在类前,默认bean id就是类名(首字母小写)
        /*IPersonDao personDao = (IPersonDao)context.getBean("personDaoImpl");
        personDao.show();*/

        PersonAction personAction = (PersonAction)context.getBean("personAction");
        personAction.show();
        personAction.destroy();
    }
}
