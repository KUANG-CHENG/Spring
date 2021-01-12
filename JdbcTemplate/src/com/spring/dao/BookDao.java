package com.spring.dao;

import com.spring.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void update(Book book);
    void delete(String id);
    int selectCount();
    Book findBookInfo(String id);
    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);
    void batchUpdateBook(List<Object[]> batchArgs);
    void batchDeleteBook(List<Object[]> batchArgs);
}
