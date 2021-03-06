package com.yulece.controller.admin.dept;

import com.yulece.common.utils.ResultVo;
import com.yulece.dto.admin.DeptLevelDto;
import com.yulece.service.admin.DeptService;
import com.yulece.service.admin.TreeService;
import com.yulece.vo.admin.DeptParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 部门控制层
 * @author wangyichao@28ph.cn
 * @Title: AdminDeptController
 * @Package com.yulece.controller.admin
 * @Description:
 * @Date 创建时间2018/5/6-21:04
 **/
@RestController
@RequestMapping("/admin/dept")
public class AdminDeptController {

    public final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private DeptService deptService;
    @Autowired
    private TreeService treeService;


    @PostMapping()
    public ResultVo saveDept(DeptParam deptParam){
        deptService.save(deptParam);
        return ResultVo.createSuccessResult("数据添加成功!");
    }

    @GetMapping("/tree")
    public ResultVo resultVo(){
        List<DeptLevelDto> deptLevelDtos = treeService.deptTree();
        return ResultVo.createSuccessResult(deptLevelDtos);
    }

    @PutMapping()
    public ResultVo update(DeptParam deptParam){
        deptService.update(deptParam);
        return ResultVo.createSuccessResult("数据修改成功!");
    }
    @GetMapping("/{deptId}")
    public ResultVo getId(@PathVariable("deptId")Integer id){
        DeptLevelDto deptLevelDto = deptService.getId(id);
        return ResultVo.createSuccessResult(deptLevelDto);
    }
}
