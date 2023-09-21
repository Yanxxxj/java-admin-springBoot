package com.test.testdemo.entity.dto;


/**
 * 前端请求参数
 *
 * @author tq
 * @date 2023-09-20
 */
public class LoginDTO {
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
