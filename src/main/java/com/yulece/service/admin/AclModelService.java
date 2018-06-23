package com.yulece.service.admin;

import com.yulece.vo.admin.AclModelParam;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelService
 * @Package com.yulece.service.admin
 * @Description:
 * @Date 创建时间2018/5/15-21:39
 **/
public interface AclModelService {
    /**
     * 更新数据
     * @param param
     */
    void update(AclModelParam param);

    /**
     * 保存数据
     * @param param
     */
    void save(AclModelParam param);
}
