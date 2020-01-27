package com.gavin.ioc.a5_autowire;

public class Book {
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "This is "+bookName +" book!";
    }
}
