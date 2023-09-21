package com.test.testdemo.config;

import com.test.testdemo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 *
 * @author tq
 * @date 2023-09-20
 */
@Configuration
public class DemoWebConfig implements WebMvcConfigurer {

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/test/**")
                //放行路径，可以添加多个
                .excludePathPatterns("/test/login");
    }
}
