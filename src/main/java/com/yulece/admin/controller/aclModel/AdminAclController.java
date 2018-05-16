package com.yulece.admin.controller.aclModel;

import com.yulece.admin.common.utils.ResultVo;
import com.yulece.admin.service.admin.AclService;
import com.yulece.admin.vo.admin.AclParam;
import com.yulece.admin.vo.admin.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.acl.Acl;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminAclController
 * @Package com.yulece.admin.controller.aclModel
 * @Description: 权限点的控制层
 * @Date 创建时间2018/5/16-21:12
 **/
@RestController
@RequestMapping("/admin/acl")
public class AdminAclController {

    @Autowired
    private AclService aclService;

    @PostMapping()
    public ResultVo save(AclParam param){
        aclService.save(param);
        return ResultVo.createSuccessResult("数据添加成功!");
    }
    @PutMapping()
    public ResultVo update(AclParam param){
        aclService.update(param);
        return ResultVo.createSuccessResult("数据修改成功!");
    }
}
