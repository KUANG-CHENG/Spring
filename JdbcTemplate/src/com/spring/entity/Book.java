package com.spring.entity;

// 数据库实体类
public class Book {
    private String id;
    private String bookname;
    private String bookauther;

    public String getId() {
        return id;
    }

    public String getBookname() {
        return bookname;
    }

    public String getBookauther() {
        return bookauther;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookauther(String bookauther) {
        this.bookauther = bookauther;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookauther='" + bookauther + '\'' +
                '}';
    }
}
