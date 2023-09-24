package com.test.testdemo.mapper;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSONObject;
import com.test.testdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper接口
 *
 * @author tq
 * @date 2023-09-20
 */
@Mapper
public interface UserMapper {

    /**
     * 查询列表
     *
     * @param user
     * @return 集合
     */
    public List<User> selectUserList(User user);

    /**
     * 注册用户
     *
     * @param user 注册
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 查询用户详情
     *
     * @param id 用户主键
     * @return 用户信息
     */
    public User selectUserById(Long id);

    /**
     * 修改用户
     *
     * @param user 修改
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);


    /**
     * 通过登录名查询用户
     *
     * @param userName 用户名
     * @return 用户信息
     */
    User selectUserListByUserName(String userName);

    /**
     * 查询用户地区分布
     */
    List<User> selectUserByRegion();
}
