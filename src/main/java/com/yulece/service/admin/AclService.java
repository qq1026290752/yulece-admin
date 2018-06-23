package com.yulece.service.admin;

import com.yulece.vo.admin.AclParam;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclService
 * @Package com.yulece.service.admin
 * @Description:
 * @Date 创建时间2018/5/16-21:13
 **/
public interface AclService {
    /**
     * 增加权限点
     * @param param
     */
    void save(AclParam param);

    /**
     * 更新权限点
     * @param param
     */
    void update(AclParam param);
}
