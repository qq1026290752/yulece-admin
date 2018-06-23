package com.yulece.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminRoleUser
 * @Package com.yulece.model.admin
 * @Description:
 * @Date 创建时间2018/5/6-19:51
 **/
@Entity
@Data
public class AdminRoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleUserId;
    private Integer roleId;
    private Integer userId;
}
