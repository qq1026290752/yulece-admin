package com.yulece.admin.service.admin.impl;

import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.repository.admin.AclModelRepository;
import com.yulece.admin.service.admin.AclModelService;
import com.yulece.admin.vo.admin.AclModelParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelServiceImplement
 * @Package com.yulece.admin.service.admin.impl
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
    }

    @Override
    public void save(AclModelParam param) {
        BeanValidator.check(param);
    }
}
