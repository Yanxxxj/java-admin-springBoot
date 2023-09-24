package com.test.testdemo.service;

import java.util.Map;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.test.testdemo.entity.User;

/**
 * Service接口
 *
 * @author tq
 * @date 2023-09-20
 */
public interface IUserService {
    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 集合
     */
    public Map<String, Object> selectUserList(Integer page, Integer size, User user);

    /**
     * 新增用户
     *
     * @param user 新增
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 查询用户详情
     *
     * @param id 用户信息主键
     * @return 用户
     */
    public User selectUserById(Long id);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键集合
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 查询用户地区分布
     */
    JSONArray selectUserByRegion();
}
