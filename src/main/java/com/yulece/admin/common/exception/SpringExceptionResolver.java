package com.yulece.admin.common.exception;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yulece.admin.common.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: SpringExceptionResolver
 * @Package com.yulece.admin.common.exception
 * @Description: 全局异常捕捉类 本项目全部返回json
 * @Date 创建时间2018/5/2-21:12
 **/
@ControllerAdvice
public class SpringExceptionResolver{

    @Autowired
    private ObjectMapper objectMapper;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleGlobalException(HttpServletRequest request, Exception e, HttpServletResponse response) throws IOException {
        if(e instanceof YuleceException|| e instanceof VoParamException){
            response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
            response.getWriter().print( objectMapper.writeValueAsString(ResultVo.createErrorResult(e.getMessage())));
        }else{
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(objectMapper.writeValueAsString(ResultVo.createErrorResult("服务器内部异常请联系管理员")));
        }
    }
}
