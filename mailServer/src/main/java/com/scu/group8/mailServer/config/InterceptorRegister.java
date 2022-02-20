package com.scu.group8.mailServer.config;

import com.scu.group8.mailServer.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器注册
 */
@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    /**
     * 把我们定义的拦截器类注册为Bean
     */
    @Bean
    public HandlerInterceptor getInterceptor() {
        return new UserInterceptor();
    }

    /**
     * 添加拦截器，并配置拦截地址
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设定拦截全部，只排除/login
        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/login");
        registry.addInterceptor(getInterceptor()).excludePathPatterns(pathPatterns);
    }

}
