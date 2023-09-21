package com.test.testdemo.service;

import com.test.testdemo.entity.dto.LoginDTO;
import com.test.testdemo.utils.ResultUtils;


/**
 * 登录接口
 *
 * @author tq
 * @date 2023-09-20
 */
public interface ILoginService {
    public ResultUtils login(LoginDTO loginDTO);
}
