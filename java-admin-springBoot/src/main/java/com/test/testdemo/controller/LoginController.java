package com.test.testdemo.controller;

import com.alibaba.fastjson2.JSONObject;
import com.test.testdemo.entity.dto.LoginDTO;
import com.test.testdemo.service.ILoginService;
import com.test.testdemo.utils.RedisUtils;
import com.test.testdemo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    ILoginService loginService;
    @Autowired
    RedisUtils redisUtils;

    /**
     * 用户登录
     * @param loginDTO 用户账号密码
     * @return
     */
    @PostMapping("login")
    public ResultUtils login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
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

    /**
     * 用户退出
     *
     * @return
     */
    @PostMapping("logout")
    public ResultUtils logout() {
        // 删除token
        String x_token = redisUtils.getCacheObject("token");
        log.info("删除用户token{}", x_token);
        redisUtils.deleteObject("token");
        return new ResultUtils(20000, "退出成功", "");
    }
}