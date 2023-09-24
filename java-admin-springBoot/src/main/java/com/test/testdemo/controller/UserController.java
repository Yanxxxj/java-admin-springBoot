package com.test.testdemo.controller;

import java.util.List;
import java.util.Map;

import com.test.testdemo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.testdemo.entity.User;
import com.test.testdemo.service.IUserService;

/**
 * Controller 用户管理
 *
 * @author tq
 * @date 2023-09-20
 */
@RestController
@RequestMapping("/test/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 查询列表
     */
    @GetMapping("/list")
    public ResultUtils list(@RequestParam(value = "pageNum", required = false) Integer pageNum,
                            @RequestParam(value = "pageSize", required = false) Integer pageSize, User user) {
        Map<String, Object> list = userService.selectUserList(pageNum, pageSize, user);
        return new ResultUtils(20000, "查询成功", list);
    }

    /**
     * 新增
     */
    @PostMapping
    public ResultUtils add(@RequestBody User user) {
        return new ResultUtils(20000, "新增成功", userService.insertUser(user));
    }

    /**
     * 获取用户详细信息
     */
    @GetMapping(value = "/{id}")
    public ResultUtils getInfo(@PathVariable("id") Long id) {
        return new ResultUtils(20000, "获取信息成功", userService.selectUserById(id));
    }

    /**
     * 修改
     */
    @PutMapping
    public ResultUtils edit(@RequestBody User user) {
        return new ResultUtils(20000, "修改成功", userService.updateUser(user));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public ResultUtils remove(@PathVariable Long[] ids) {
        return new ResultUtils(20000, "删除成功", userService.deleteUserByIds(ids));
    }

    /**
     * 查询用户地区分布
     */
    @GetMapping("/region")
    public ResultUtils region() {
        return new ResultUtils(20000, "查询成功", userService.selectUserByRegion());
    }
}
