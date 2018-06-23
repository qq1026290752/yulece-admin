package com.yulece.controller.admin.aclModel;

import com.yulece.common.utils.ResultVo;
import com.yulece.service.admin.AclService;
import com.yulece.vo.admin.AclParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminAclController
 * @Package com.yulece.controller.admin.aclModel
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
