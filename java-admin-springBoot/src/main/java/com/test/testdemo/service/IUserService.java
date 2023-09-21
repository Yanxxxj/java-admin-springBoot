package com.test.testdemo.service;

import java.util.List;

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
    public List<User> selectUserList(User user);

    /**
     * 新增用户
     *
     * @param user 新增
     * @return 结果
     */
    public int insertUser(User user);

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
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteUserById(Long id);
}
