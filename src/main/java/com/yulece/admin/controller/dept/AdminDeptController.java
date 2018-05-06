package com.yulece.admin.controller.dept;

import com.yulece.admin.common.utils.ResultVo;
import com.yulece.admin.service.dept.DeptService;
import com.yulece.admin.vo.admin.DeptParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 部门控制层
 * @author wangyichao@28ph.cn
 * @Title: AdminDeptController
 * @Package com.yulece.admin.controller.dept
 * @Description:
 * @Date 创建时间2018/5/6-21:04
 **/
@RestController
@RequestMapping("/admin/dept")
public class AdminDeptController {

    public final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private DeptService deptService;


    @PostMapping()
    public ResultVo saveDept(DeptParam deptParam) throws InvocationTargetException, IllegalAccessException {
        deptService.save(deptParam);
        return ResultVo.createSuccessResult();
    }
}
