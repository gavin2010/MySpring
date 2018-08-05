package com.gavin.ioc.autowire;

import javax.annotation.Resource;

public class Person {
    public Book getBook1() {
        return book1;
    }

    public void setBook1(Book book) {
        this.book1 = book;
    }

  /*  @Autowired
    private Book book1;*/

   @Resource(name = "book")
    private Book book1;

    @Override
    public String toString() {
        return "Hello, "+ book1.toString();
    }
}
