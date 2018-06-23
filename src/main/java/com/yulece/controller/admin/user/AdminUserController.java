package com.yulece.controller.admin.user;

import com.yulece.common.utils.ResultVo;
import com.yulece.model.admin.AdminUser;
import com.yulece.service.admin.UserService;
import com.yulece.vo.admin.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 用户信息控制层
 * @author wangyichao@28ph.cn
 * @Title: AdminUserController
 * @Package com.yulece.controller.admin.user
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


    @GetMapping("/page")
    public ResultVo pageList(@RequestParam("id")Integer deptId, Pageable request){
        Page<AdminUser> adminUserPage = userService.page(deptId, request);
        return ResultVo.createSuccessResult(adminUserPage);
    }
}
