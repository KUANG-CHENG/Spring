package com.spring.service;

import com.spring.dao.BookDao;
import com.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // 注入Dao
    @Autowired
    private BookDao bookDao;

    // 添加方法
    public void addBook(Book book){
        bookDao.add(book);
    }

    // 修改的方法
    public void updateBook(Book book){
        bookDao.update(book);
    }

    // 删除的方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }

    // 查询1-返回某个值  （查询表中记录数）
    public int findCount(){
        return bookDao.selectCount();
    }

    // 查询2-返回对象    (查询图书详情 )
    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }

    // 查询3-返回集合  （查询图书列表分页）
    public List<Book> findAll(){
        return bookDao.findAllBook();
    }

    // 批量添加--数组形式
    // batchArgs--批量指令
    public void batchAdd(List<Object[]> batchArgs){
        bookDao.batchAddBook(batchArgs);
    }

    // 批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdateBook(batchArgs);

    }
    // 批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDeleteBook(batchArgs);
    }


}
