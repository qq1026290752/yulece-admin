package com.yulece.admin.model.admin;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminRoleUser
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/6-19:51
 **/
@Entity
@Data
public class AdminRoleUser {

    private Integer roleUserId;
    private Integer roleId;
    private Integer userId;
}
