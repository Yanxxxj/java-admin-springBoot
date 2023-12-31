package com.test.testdemo.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testdemo.utils.HttpContextUtils;
import com.test.testdemo.utils.RedisUtils;
import com.test.testdemo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录拦截器
 *
 * @author tq
 * @date 2023-09-20
 */
@Slf4j
//@Component
public class LoginInterceptor implements HandlerInterceptor {

//    @Autowired
//    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //从header中获取token
        String token = request.getHeader("X-Token");
        //如果token为空
        if (Strings.isBlank(token)) {
            setReturn(response, 400, "用户未登录，请先登录");
            return false;
        }
        // 检查token是否已经过期
//        RedisUtils redisUtils = new RedisUtils();
//        String cachedToken = redisUtils.getCacheObject("token");
//        log.info("缓存中的token是{}", cachedToken);
//        if (cachedToken != null && cachedToken.equals(token)) {
//            return true;
//        } else {
//            setReturn(response, 400, "用户信息已过期，请重新登录");
//            return false;
//        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    //返回json格式错误信息
    private static void setReturn(HttpServletResponse response, Integer code, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        ResultUtils result = new ResultUtils(code, msg, "");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        httpResponse.getWriter().print(json);
    }

}
