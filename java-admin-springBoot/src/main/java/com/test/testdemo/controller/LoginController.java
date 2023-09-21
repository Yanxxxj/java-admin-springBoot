package com.test.testdemo.controller;

import com.test.testdemo.entity.dto.LoginDTO;
import com.test.testdemo.service.ILoginService;
import com.test.testdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户登录
 *
 * @author tq
 * @date 2023-09-20
 */
@RestController()
public class LoginController {
    @Autowired
    ILoginService loginService;

    @PostMapping(value = "/test/login")
    public ResultUtils login(@RequestBody LoginDTO loginDTO) {
        System.out.println("正在登录");
        return loginService.login(loginDTO);
    }
}
