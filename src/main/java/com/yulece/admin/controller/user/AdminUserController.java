package com.yulece.admin.controller.user;

import com.yulece.admin.common.utils.ResultVo;
import com.yulece.admin.service.admin.UserService;
import com.yulece.admin.vo.admin.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 用户信息控制层
 * @author wangyichao@28ph.cn
 * @Title: AdminUserController
 * @Package com.yulece.admin.controller.user
 * @Description:
 * @Date 创建时间2018/5/12-10:45
 **/
@RequestMapping("/admin/user")
@RestController
public class AdminUserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResultVo save(UserParam param){
        userService.save(param);
        return ResultVo.createSuccessResult("数据添加成功!");
    }
    @PutMapping()
    public ResultVo update(UserParam param){
        userService.update(param);
        return ResultVo.createSuccessResult("数据修改成功!");
    }
}
