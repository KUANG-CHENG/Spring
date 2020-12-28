package com.spring.dao;

import com.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    // 注入JDBCTemplete
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    @Override
    public void add(Book book) {
        // 数据库增加
        // 1.sql语句--在userdb数据库内的tb_books数据表上
        String sql="insert into tb_book values(?,?,?)";
        Object[] args={book.getId(),book.getBookname(),book.getBookauther()};
        // 2.调用方法实现
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);

    }

    // 更新方法
    @Override
    public void update(Book book) {
        String sql="update tb_book set bookname=?, bookauther=? where id=?";
        Object[] args={book.getId(),book.getBookname(),book.getBookauther()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    // 删减方法
    @Override
    public void delete(String id) {
        String sql="delete from tb_book where id=?";
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    // 查询方法1-返回某个值
    @Override
    public int selectCount() {
        String sql = "select count(*) from tb_book";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    // 查询方法2-返回对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from tb_book where id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    // 查询方法3-返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from tb_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into tb_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update tb_book set bookname=?, bookauther=? where id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    // 批量删除
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql="delete from tb_book where id=?";
        int[]  ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
