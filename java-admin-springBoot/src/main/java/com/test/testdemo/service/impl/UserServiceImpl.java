package com.test.testdemo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.testdemo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.testdemo.mapper.UserMapper;
import com.test.testdemo.entity.User;
import com.test.testdemo.service.IUserService;


/**
 * Service业务层处理
 *
 * @author tq
 * @date 2023-09-20
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    @Override
    public Map<String, Object> selectUserList(Integer page, Integer size, User user) {
        PageHelper.startPage(page, size);
        List<User> usersList = userMapper.selectUserList(user);
        PageInfo pageInfo = new PageInfo(usersList);

        Map<String, Object> map = new HashMap<>();
        //查询的数据
        map.put("usersList", pageInfo.getList());
        //数据总条目数
        map.put("total", pageInfo.getTotal());

        return map;
    }

    /**
     * 注册用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int insertUser(User user) {
        //调用MD5工具类进行加密
        user.setPassword(MD5Utils.inputPassToFormPass(user.getPassword()));
        // 判断系统中是否存在相同的用户名
        User userName = userMapper.selectUserListByUserName(user.getUserName());
        if (userName != null) {
            return -1;
        }
        return userMapper.insertUser(user);
    }

    /**
     * 查询用户详情
     *
     * @param id 用户主键
     * @return 用户信息
     */
    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    public int updateUser(User user) {
        user.setPassword(MD5Utils.inputPassToFormPass(user.getPassword()));
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除
     *
     * @param ids 需要删除的主键
     * @return 结果
     */
    @Override
    public int deleteUserByIds(Long[] ids) {
        return userMapper.deleteUserByIds(ids);
    }
}
