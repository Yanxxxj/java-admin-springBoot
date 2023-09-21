package com.test.testdemo.controller;

import com.alibaba.fastjson2.JSONObject;
import com.test.testdemo.entity.dto.LoginDTO;
import com.test.testdemo.service.ILoginService;
import com.test.testdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户登录
 *
 * @author tq
 * @date 2023-09-20
 */
@RestController()
@RequestMapping("user")
public class LoginController {
    @Autowired
    ILoginService loginService;

    @PostMapping("login")
    public ResultUtils login(@RequestBody LoginDTO loginDTO) {
        System.out.println("正在登录");
        return loginService.login(loginDTO);
    }

    @GetMapping("info")
    public ResultUtils getInfo(@RequestParam String token) {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setCode(20000);

        JSONObject data = new JSONObject();
        data.put("roles", new String[]{"admin"});
        data.put("introduction", "I am a super administrator");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
        data.put("name", "Super Admin");
        resultUtils.setData(data);
        resultUtils.setMessage("登录成功");
        return resultUtils;
    }

    // @GetMapping("info")
    // public JSONObject getInfo(@RequestParam String token) {
    //     System.out.println(token);
    //     JSONObject jsonObject = new JSONObject();
    //     JSONObject jsonObject1 = new JSONObject();
    //     jsonObject.put("code", 20000);
    //     jsonObject1.put("roles", new String[]{"admin"});
    //     jsonObject1.put("introduction", "I am a super administrator");
    //     jsonObject1.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
    //     jsonObject1.put("name", "Super Admin");
    //     jsonObject.put("data", jsonObject1);
    //     return jsonObject;
    // }
}