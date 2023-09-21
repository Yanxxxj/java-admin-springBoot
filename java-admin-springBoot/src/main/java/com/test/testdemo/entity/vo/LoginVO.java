package com.test.testdemo.entity.vo;

import com.test.testdemo.entity.User;

import java.io.Serializable;


/**
 * 登录VO
 *
 * @author tq
 * @date 2023-09-20
 */
public class LoginVO implements Serializable {
    private Integer id;
    private String token;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
