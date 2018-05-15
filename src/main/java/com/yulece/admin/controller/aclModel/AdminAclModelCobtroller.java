package com.yulece.admin.controller.aclModel;

import com.yulece.admin.common.utils.ResultVo;
import com.yulece.admin.service.admin.AclModelService;
import com.yulece.admin.vo.admin.AclModelParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminAclModelCobtroller
 * @Package com.yulece.admin.controller.aclModel
 * @Description:
 * @Date 创建时间2018/5/15-20:26
 **/
@RestController
@RequestMapping("/admin/aclmodel")
public class AdminAclModelCobtroller {

    public final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private AclModelService aclModelService;

    @PostMapping()
    public ResultVo save(AclModelParam param){
        aclModelService.save(param);
        return ResultVo.createSuccessResult("数据添加成功!");
    }



    @PutMapping()
    public ResultVo update(AclModelParam param){
        aclModelService.update(param);
        return ResultVo.createSuccessResult("数据修改成功!");
    }

}
