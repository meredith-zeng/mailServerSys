package com.scu.group8.mailServer.config;

import com.scu.group8.mailServer.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getInterceptor() {
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/user/*");
        registry.addInterceptor(getInterceptor()).excludePathPatterns(pathPatterns);
    }

}
