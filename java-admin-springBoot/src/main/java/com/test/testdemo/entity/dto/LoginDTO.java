package com.test.testdemo.entity.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * 前端请求参数
 *
 * @author tq
 * @date 2023-09-20
 */
@Data
public class LoginDTO implements Serializable {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
