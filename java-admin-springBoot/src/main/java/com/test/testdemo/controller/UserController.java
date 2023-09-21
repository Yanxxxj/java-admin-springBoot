package com.test.testdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.testdemo.entity.User;
import com.test.testdemo.service.IUserService;

/**
 * Controller
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
    public List<User> list(User user) {
        List<User> list = userService.selectUserList(user);
        return list;
    }

    /**
     * 新增
     */
     /*
    @Log(title = "", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return toAjax(userService.insertUser(user));
    }

    *//**
     * 修改
     *//*
    @Log(title = "", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    *//**
     * 删除
     *//*
    @Log(title = "", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userService.deleteUserByIds(ids));
    }*/
}
