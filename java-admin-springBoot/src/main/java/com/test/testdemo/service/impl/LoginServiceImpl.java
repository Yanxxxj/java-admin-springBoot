package com.test.testdemo.service.impl;

import com.test.testdemo.entity.User;
import com.test.testdemo.entity.dto.LoginDTO;
import com.test.testdemo.entity.vo.LoginVO;
import com.test.testdemo.mapper.UserMapper;
import com.test.testdemo.service.ILoginService;
import com.test.testdemo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 用户登录
 *
 * @author tq
 * @date 2023-09-20
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultUtils login(LoginDTO loginDTO) {
        log.info("用户名是：{}",loginDTO.getUserName());
        if (StringUtils.isEmpty(loginDTO.getUserName())) {
            return new ResultUtils(400, "账号不能为空", "");
        }
        if (StringUtils.isEmpty(loginDTO.getPassWord())) {
            return new ResultUtils(400, "密码不能为空", "");
        }
        //通过登录名查询用户
        User user = userMapper.selectUserListByUserName(loginDTO.getUserName());

        if (user != null && user.getPassword().equals(loginDTO.getPassWord())) {
            LoginVO loginVO = new LoginVO();
            loginVO.setId(user.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(user);
            loginVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
            loginVO.setRoles(new String[]{"admin"});
            return new ResultUtils(20000, "登录成功", loginVO);
        }
        return new ResultUtils(401, "登录失败", "");
    }
}
