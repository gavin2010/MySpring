package com.gavin.ioc.a5_autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

public class Person {
    public Book getBook1() {
        return book1;
    }

    public void setBook1(Book book) {
        this.book1 = book;
    }

   @Autowired
    //@Qualifier("book") //按照指定名称匹配
    private Book book1;

  // @Resource(name="book")  //只能按照名称匹配
//   @Resource  //优先名称匹配，匹配失败就按照类型匹配
//   private Book book1;

    @Override
    public String toString() {
        return "Hello, "+ book1.toString();
    }

}
