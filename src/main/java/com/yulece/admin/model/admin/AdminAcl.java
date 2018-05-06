package com.yulece.admin.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 权限模块实体类
 * @author wangyichao@28ph.cn
 * @Title: AdminAcl
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/3-23:47
 **/
@Entity
@Data
public class AdminAcl {

    @Id
    private Integer aclId;//权限模块
    private String aclName;
    private Integer aclModuleId;
    private String aclUrl;
    private Integer type;
    private Integer status;
    private Integer aclSeq;
    private String aclRemark;
    private String operator;
    private String operateIp;
    private Date createTime;
    private Date updateTime;
}
