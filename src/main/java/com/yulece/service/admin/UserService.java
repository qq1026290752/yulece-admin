package com.yulece.service.admin;

import com.yulece.model.admin.AdminUser;
import com.yulece.vo.admin.UserParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserService
 * @Package com.yulece.service.admin
 * @Description:
 * @Date 创建时间2018/5/12-11:27
 **/
public interface UserService {

    void save(UserParam userParam);

    void update(UserParam userParam);

    Page<AdminUser> page(Integer deptId, Pageable pageable);

    /**
     * 激活用户
     * @param key
     */
    void enable(String key);
}
