package com.yulece.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminRoleAlc
 * @Package com.yulece.model.admin
 * @Description:
 * @Date 创建时间2018/5/6-19:48
 **/
@Entity
@Data
public class AdminRoleAlc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleAclId;
    private Integer roleId;
    private Integer aclId;
    private String operator;
    private String operateIp;
    private Date createTime;
    private Date updateTime;

}
