package com.yulece.admin.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 管理员用户表
 * @author wangyichao@28ph.cn
 * @Title: AdminUser
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/2-21:08
 **/
@Data
@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    private Integer id;
    private String userName;
    private String password;
    private String nikeName;
    private String telephone;
    private String mail;
    private String headerUrl;
    private Integer status;
    private String userRemark;//备注
    private String operator;//操作用户
    private String operateIp;//操作Ip
    private String userDept;//用户所属部门
    private Date updateTime;//修改时间
    private Date createTime;//创建时间






}
