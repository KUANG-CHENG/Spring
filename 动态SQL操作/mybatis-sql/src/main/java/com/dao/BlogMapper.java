package com.dao;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    // 插入数据
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIF(Map map);

    // 查询博客 Choose
    List<Blog> queryBlogChoose(Map map);

    // 查询 foreach -- 1、2、3
    List<Blog> queryBlogForeach(Map map);

    // 更新博客 Set
    int updateBlog(Map map);

}
