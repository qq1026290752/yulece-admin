package com.yulece.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * http 请求拦截器
 * @author wangyichao@28ph.cn
 * @Title: HttpInterceptor
 * @Package com.yulece.common.utils
 * @Description:
 * @Date 创建时间2018/5/6-16:20
 **/
@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入方法 打印异常
        //获取到UEL
        String url = request.getRequestURL().toString();
        //获取到参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        LOGGER.info("request start:url：{} -> parameter:{}",url,objectMapper.writeValueAsString(parameterMap));
        //添加request
        RequestHoder.add(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      //进入方法 打印异常
        //获取到UEL
        String url = request.getRequestURL().toString();
        //获取到参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        LOGGER.info("request end:url：{} -> parameter:{}",url,objectMapper.writeValueAsString(parameterMap));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //进入方法 打印异常
        //获取到UEL
        String url = request.getRequestURL().toString();
        //获取到参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        LOGGER.info("request afterCompletion:url：{} -> parameter:{}",url,objectMapper.writeValueAsString(parameterMap));

        removeThThreadLocal();
    }

    /**
     * 删除ThThreadLocal中的所有原生
     */
    private void removeThThreadLocal(){
        RequestHoder.remove();
    }
}
