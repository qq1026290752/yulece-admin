package com.yulece.admin.service.admin.impl;

import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.enums.ParamEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.common.utils.LevelUtil;
import com.yulece.admin.dto.admin.DeptLevelDto;
import com.yulece.admin.mapper.dept.DeptMapper;
import com.yulece.admin.model.admin.AdminDept;
import com.yulece.admin.repository.admin.DeptRepository;
import com.yulece.admin.service.admin.DeptService;
import com.yulece.admin.vo.admin.DeptParam;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void save(DeptParam deptParam){
        BeanValidator.check(deptParam);
        if(checkDeptExist(deptParam.getDeptParentId(),deptParam.getDeptName(),deptParam.getDeptId())){
            throw new YuleceException(ParamEnum.DEPT_NAME_EXIST);
        }
        AdminDept adminDept = new AdminDept();
            //开始属性拷贝
            try {
                BeanUtils.copyProperties(adminDept,deptParam);
            } catch (Exception e) {
            throw new YuleceException(ExceptionEnum.COPY_BEAN_ERROR);
        }

        adminDept.setDeptLevel(LevelUtil.calculateLevel(getLavel(adminDept.getDeptParentId()),adminDept.getDeptParentId()));
        adminDept.setOperator("admin");//TODO
        adminDept.setOperateIp("127.0.0.1");//todo
        deptRepository.save(adminDept);
    }

    @Override
    public void update(DeptParam deptParam) {
        BeanValidator.check(deptParam);
        if(checkDeptExist(deptParam.getDeptParentId(),deptParam.getDeptName(),deptParam.getDeptId())){
            throw new YuleceException(ParamEnum.DEPT_NAME_EXIST);
        }
        AdminDept beforeDept = deptMapper.getOne(deptParam.getDeptId());
        Preconditions.checkNotNull(beforeDept,"该更新部门不存在");
        AdminDept adminDept = new AdminDept();
        //开始属性拷贝
        try {
            BeanUtils.copyProperties(adminDept,deptParam);
        } catch (Exception e) {
            throw new YuleceException(ExceptionEnum.COPY_BEAN_ERROR);
        }
        adminDept.setDeptLevel(LevelUtil.calculateLevel(getLavel(adminDept.getDeptParentId()),adminDept.getDeptParentId()));
        adminDept.setOperator("admin");//TODO
        adminDept.setOperateIp("127.0.0.1");//todo
        updateWithChild(beforeDept,adminDept);
    }

    @Override
    public DeptLevelDto getId(Integer id) {
        AdminDept adminDept = deptMapper.getOne(id);
        if(adminDept == null){
            throw new YuleceException(ExceptionEnum.DEPT_NOT_NULL);
        }
        return DeptLevelDto.adapt(adminDept);
    }

    @Transactional
    public void updateWithChild(AdminDept before,AdminDept after){
        String newLevelPrefix = after.getDeptLevel();
        String oldLevelPrefix = before.getDeptLevel();
        if(!StringUtils.equals(newLevelPrefix,oldLevelPrefix)){
            List<AdminDept> adminDepts = deptMapper.getDeptChildListByLevel(before.getDeptLevel());
            //判断集合是否为空
            if(!CollectionUtils.isEmpty(adminDepts)){
                  for(AdminDept dept:adminDepts){
                      //取出当前的等级
                      String level = dept.getDeptLevel();
                      //判断当前lavel 是否存在于old
                      if(level.indexOf(oldLevelPrefix)==0){
                          //更新当前lavel
                          level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                          dept.setDeptLevel(level);
                      }
                  }
                  deptMapper.batchUpdateLevel(adminDepts);
            }
        }
        //更新部门
        deptRepository.save(after);
    }

    private boolean checkDeptExist(Integer deptParentId,String deptName,Integer deptId){

        return deptMapper.countByNameAndParentId(deptName,deptParentId,deptId) > 0;
    }

    private String getLavel(Integer deptId){
        AdminDept adminDept = deptMapper.getOne(deptId);
        if(adminDept == null){
            return null;
        }
        return adminDept.getDeptLevel();
    }
}
