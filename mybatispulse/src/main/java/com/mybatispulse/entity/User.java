package com.mybatispulse.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

// 实体类的创建
// @Data -- 自动生成 get, set, 有参无参构造
@Data
public class User {

    // 实现主键自增
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    // create_time
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    // update_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version  // 乐观锁版本号
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic  // 逻辑删除标志
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}