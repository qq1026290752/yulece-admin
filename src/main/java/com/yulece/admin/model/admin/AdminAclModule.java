package com.yulece.admin.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminAclModule
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/6-17:14
 **/
@Data
@Entity
public class AdminAclModule {

    @Id
    private Integer moduleId;
    private String moduleName;
    private Integer moduleParentId;
    private String moduleLevel ;
    private Integer status;
    private Integer moduleSeq;
    private String moduleRemark;
    private String operator;
    private String operateIp;
    private Date createTime;
    private Date updateTime;
}
