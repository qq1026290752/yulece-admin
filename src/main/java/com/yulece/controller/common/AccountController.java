package com.yulece.controller.common;

import com.yulece.common.utils.ResultVo;
import com.yulece.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AccountController
 * @Package com.yulece.controller.common
 * @Description:
 * @Date 创建时间2018/5/13-17:58
 **/
@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/validateMail/admin")
    public ResultVo validateMail(@RequestParam("key")String key){
        userService.enable(key);
        return ResultVo.createSuccessResult("用户激活成功!");
    }
}
