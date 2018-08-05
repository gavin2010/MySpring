package com.gavin.ioc.hello.writespring;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySpring {
    private List<Bean> beanList = null;
    private Map<String,Object> beanObject = null;

    public Object getBean(String id){
        return beanObject.get(id);

    }
    public MySpring(String fileName){
        if(null == beanList){
            beanList = new ArrayList<>();
        }
        if(null == beanObject){
            beanObject = new HashMap<>();
        }
        //读取xml中的Bean信息
        readXML(fileName);
        //实例化bean
        instanceBeans();
    }

    private void readXML(String fileName){
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        Document doc = null;
        SAXBuilder as = new SAXBuilder(false);
        Element root = null;
        try {
            doc = as.build(new FileInputStream(new File(xmlPath.toURI())));
            root = doc.getRootElement();

            //设置命名空间
            Namespace xhtml = Namespace.getNamespace("xhtml", "http://www.springframework.org/schema/beans");
            List<Element> list = root.getChildren("bean",xhtml);
            for(Element element : list){
                String id = element.getAttributeValue("id");
                String className = element.getAttributeValue("class");
                Bean bean = new Bean();
                bean.setId(id);
                bean.setClassName(className);
                beanList.add(bean);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void instanceBeans(){
        try {
            for(Bean bean : beanList){
                if(null != bean.getId() && null != bean.getClassName() && bean.getClassName().trim().length()>0){
                    beanObject.put(bean.getId(),Class.forName(bean.getClassName()).newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
