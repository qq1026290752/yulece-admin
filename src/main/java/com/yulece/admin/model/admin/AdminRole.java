package com.yulece.admin.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 管理用户角色实体类
 * @author wangyichao@28ph.cn
 * @Title: AdminRole
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/3-23:07
 **/
@Data
@Entity
public class AdminRole {

    @Id
    private Integer roleId;
    private Integer roleName;
    private Integer roleType;
    private Integer roleStatus;
    private Integer roleRemark;
    private String operator;//操作用户
    private String operateIp;//操作Ip
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}
