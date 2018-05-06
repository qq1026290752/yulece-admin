package com.yulece.admin.controller;

import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.common.utils.ResultVo;
import com.yulece.admin.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: HelloController
 * @Package com.yulece.admin.controller
 * @Description:
 * @Date 创建时间2018/5/2-22:02
 **/
@RequestMapping
@RestController
public class HelloController {


    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @GetMapping("/h")
    public String hello(){
        int a=  100/0;
        return "hello";
    }
    @GetMapping("/validate")
    public ResultVo validate(TestVo testVo){
        BeanValidator.check(testVo);
        return ResultVo.createSuccessResult("validate");
    }
}
