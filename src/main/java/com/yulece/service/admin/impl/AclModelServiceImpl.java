package com.yulece.service.admin.impl;

import com.yulece.common.enums.ExceptionEnum;
import com.yulece.common.exception.YuleceException;
import com.yulece.common.utils.BeanValidator;
import com.yulece.common.utils.IpUtil;
import com.yulece.common.utils.LevelUtil;
import com.yulece.common.utils.RequestHoder;
import com.yulece.model.admin.AdminAclModule;
import com.yulece.repository.admin.AclModelRepository;
import com.yulece.service.admin.AclModelService;
import com.yulece.vo.admin.AclModelParam;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelServiceImplement
 * @Package com.yulece.service.admin.impl
 * @Description:
 * @Date 创建时间2018/5/15-21:39
 **/
@Service
public class AclModelServiceImpl implements AclModelService {

    @Autowired
    private AclModelRepository aclModelRepository;

    @Override
    public void update(AclModelParam param) {
        BeanValidator.check(param);
        if(checkModelNameExist(param.getModuleName(),param.getModuleParentId(),param.getModuleId())){
            throw new YuleceException(ExceptionEnum.ACL_MODEL_NAME_EXIST_NULL);
        }
        AdminAclModule adminAclModule = new AdminAclModule();
        BeanUtils.copyProperties(adminAclModule,param);
        adminAclModule.setModuleLevel(LevelUtil.calculateLevel(getLavel(adminAclModule.getModuleParentId()),adminAclModule.getModuleParentId()));
        adminAclModule.setOperator("admin");//TODO
        adminAclModule.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));
        aclModelRepository.save(adminAclModule);
    }


    private boolean checkModelNameExist(String modelName,Integer modelParentId,Integer id){
        if (id == null){
            return aclModelRepository.checkModelNameExist(modelName,modelParentId) > 0;
        }
        return aclModelRepository.checkModelNameExist(modelName,modelParentId, id) > 0;
    }

    @Override
    public void save(AclModelParam param) {
        if(checkModelNameExist(param.getModuleName(),param.getModuleParentId(),param.getModuleId())){
            throw new YuleceException(ExceptionEnum.ACL_MODEL_NAME_EXIST_NULL);
        }
        //查询权限模块是否存在
        AdminAclModule beforeModule = aclModelRepository.getOne(param.getModuleId());
        Preconditions.checkNotNull(beforeModule,"该更新权限模块不存在");
        AdminAclModule adminAclModule = new AdminAclModule();
        BeanUtils.copyProperties(adminAclModule,param);
        adminAclModule.setModuleLevel(LevelUtil.calculateLevel(getLavel(adminAclModule.getModuleParentId()),adminAclModule.getModuleParentId()));
        adminAclModule.setOperator("admin");//TODO
        adminAclModule.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));
        updateWithChild(beforeModule,adminAclModule);
    }

    private void updateWithChild(AdminAclModule beforeModule, AdminAclModule adminAclModule) {
        String newLevelPrefix = beforeModule.getModuleLevel();
        String oldLevelPrefix = adminAclModule.getModuleLevel();
        if(!StringUtils.equals(newLevelPrefix,oldLevelPrefix)){
            List<AdminAclModule> adminAclModules = aclModelRepository.getDeptChildListByLevel(beforeModule.getModuleLevel());
            //判断集合是否为空
            if(!CollectionUtils.isEmpty(adminAclModules)){
                for(AdminAclModule aclModule:adminAclModules){
                    //取出当前的等级
                    String level = aclModule.getModuleLevel();
                    //判断当前lavel 是否存在于old
                    if(level.indexOf(oldLevelPrefix)==0){
                        //更新当前lavel
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        aclModule.setModuleLevel(level);
                        aclModelRepository.save(aclModule);
                    }
                }
//                deptMapper.batchUpdateLevel(adminDepts);
            }
        }
        //更新部门
        aclModelRepository.save(adminAclModule);

    }

    private String getLavel(Integer aclModelId) {
        AdminAclModule adminAclModule = aclModelRepository.getOne(aclModelId);
        if(adminAclModule == null) {
            return null;
        }
        return adminAclModule.getModuleLevel();

    }

}
