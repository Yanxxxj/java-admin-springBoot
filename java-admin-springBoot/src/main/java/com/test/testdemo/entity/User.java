package com.test.testdemo.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 对象 user
 *
 * @author tq
 * @date 2023-09-20
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Long age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

}
