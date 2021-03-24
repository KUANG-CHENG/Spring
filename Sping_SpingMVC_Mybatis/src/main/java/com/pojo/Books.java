package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 导入lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookID;        // 图书id号
    private String bookName;   // 图书名
    private int bookCounts;    // 图书的数量
    private String details;    // 图书的详细介绍
}