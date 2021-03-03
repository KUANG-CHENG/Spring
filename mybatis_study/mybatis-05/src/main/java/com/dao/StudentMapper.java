package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 多对一
    // 方式一
    public List<Student> getStudent1();
    // 方式二
    public List<Student> getStudent2();
}
