package com.yulece.admin.service.admin.impl;

import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.enums.ParamEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.common.utils.LevelUtil;
import com.yulece.admin.model.admin.AdminDept;
import com.yulece.admin.repository.admin.DeptRepository;
import com.yulece.admin.service.admin.DeptService;
import com.yulece.admin.vo.admin.DeptParam;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptService
 * @Package com.yulece.admin.service.admin
 * @Description:
 * @Date 创建时间2018/5/6-21:10
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public void save(DeptParam deptParam){
        BeanValidator.check(deptParam);
        if(checkDeptExist(deptParam.getDeptParentId(),deptParam.getDeptName(),deptParam.getDeptId())){
            throw new YuleceException(ParamEnum.DEPT_NAME_EXIST);
        }
        AdminDept adminDept = new AdminDept();
        //开始属性拷贝
        try {
            BeanUtils.copyProperties(deptParam,adminDept);
        } catch (Exception e) {
            throw new YuleceException(ExceptionEnum.COPY_BEAN_ERROR);
        }

        adminDept.setDeptLevel(LevelUtil.calculateLevel(getLavel(adminDept.getDeptParentId()),adminDept.getDeptParentId()));
        adminDept.setOperator("admin");//TODO
        adminDept.setOperateIp("127.0.0.1");//todo
        deptRepository.save(adminDept);
    }

    private boolean checkDeptExist(Integer deptParentId,String deptName,Integer deptId){
        //TODO:
        return true;
    }

    private String getLavel(Integer deptId){
        AdminDept adminDept = deptRepository.getOne(deptId);
        if(adminDept == null){
            return null;
        }
        return adminDept.getDeptLevel();
    }
}
