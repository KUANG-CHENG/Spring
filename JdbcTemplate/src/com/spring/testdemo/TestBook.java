package com.spring.testdemo;

import com.spring.entity.Book;
import com.spring.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        // 添加数据
//        Book book = new Book();
//        book.setUserid("66");
//        book.setUsername("hh");
//        book.setUserpwd("343242");
//        bookService.addBook(book);

//        // 修改数据
//        Book book = new Book();
//        book.setId("10");
//        book.setBookname("kc");
//        book.setBookname("30");
//        bookService.updateBook(book);
//
//        // 删除数据
//        bookService.deleteBook("8");

//        // 查询1
//        int count = bookService.findCount();
//        System.out.println(count);
//
//        // 查询2
//        Book book = bookService.findOne("66");
//        System.out.println(book);
//
//        // 查询3
//        List<Book> all = bookService.findAll();
//        System.out.println(all);

        // 批量添加
//        List<Object[]> batchArgs = new ArrayList<>(); // 数组形式
//        Object[] o1 = {"3","java","c++"};
//        Object[] o2 = {"4","nba","ncaa"};
//        Object[] o3 = {"5","ball","mysql"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);

        // 批量修改
//        List<Object[]> batchArgs = new ArrayList<>(); // 数组形式
//        Object[] o1 = {"java","111","3"};
//        Object[] o2 = {"nba","222","4"};
//        Object[] o3 = {"ball","333 ","5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        // 批量删除
        List<Object[]> batchArgs = new ArrayList<>(); // 数组形式
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        Object[] o3 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);

    }
}
