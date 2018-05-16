package com.yulece.admin.service.admin.impl;

import com.google.common.cache.CacheBuilder;
import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.common.utils.IpUtil;
import com.yulece.admin.common.utils.RequestHoder;
import com.yulece.admin.model.admin.AdminAcl;
import com.yulece.admin.repository.admin.AclRepository;
import com.yulece.admin.service.admin.AclService;
import com.yulece.admin.vo.admin.AclParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclServiceImpl
 * @Package com.yulece.admin.service.admin.impl
 * @Description:
 * @Date 创建时间2018/5/16-21:13
 **/
@Service
public class AclServiceImpl implements AclService {

    @Autowired
    private AclRepository aclRepository;

    @Override
    public void save(AclParam param) {
        BeanValidator.check(param);
        //判断有没有重复的
        if(checkAclNameExist(param.getAclName(),param.getAclModuleId())){
            throw new YuleceException(ExceptionEnum.ACL_NAME_EXIST_NULL);
        }
        //开始进行复制操作
        AdminAcl adminAcl = new AdminAcl();
        BeanUtils.copyProperties(adminAcl,param);
        adminAcl.setOperator("admin");//TODO
        adminAcl.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));
        aclRepository.save(adminAcl);
    }

    private boolean checkAclNameExist(String aclName,Integer aclModuleId){
        return  aclRepository.checkAclNameExist(aclName,aclModuleId) > 0 ;
    }

    @Override
    public void update(AclParam param) {
        BeanValidator.check(param);
        //判断有没有重复的
        //是否存在该权点
        AdminAcl oldAcl = aclRepository.getOne(param.getAclId());
        Preconditions.checkNotNull(oldAcl,"查无此该权限点");
        if(checkAclNameExist(param.getAclName(),param.getAclModuleId())){
            throw new YuleceException(ExceptionEnum.ACL_NAME_EXIST_NULL);
        }
        //开始进行复制操作
        AdminAcl adminAcl = new AdminAcl();
        BeanUtils.copyProperties(adminAcl,param);
        adminAcl.setOperator("admin");//TODO
        adminAcl.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));
        aclRepository.save(adminAcl);
    }
}
