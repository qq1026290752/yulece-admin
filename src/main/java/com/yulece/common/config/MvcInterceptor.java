package com.yulece.common.config;

import com.yulece.common.utils.HttpInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: MvcInterceptor
 * @Package com.yulece.common.config
 * @Description:
 * @Date 创建时间2018/5/6-16:45
 **/
@Configuration
public  class MvcInterceptor implements WebMvcConfigurer {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
        LOGGER.info("开始配置拦截器");
    }
}
