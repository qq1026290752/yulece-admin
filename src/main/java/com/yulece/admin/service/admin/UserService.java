package com.yulece.admin.service.admin;

import com.yulece.admin.vo.admin.UserParam;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserService
 * @Package com.yulece.admin.service.admin
 * @Description:
 * @Date 创建时间2018/5/12-11:27
 **/
public interface UserService {

    void save(UserParam userParam);

    void update(UserParam userParam);
}
