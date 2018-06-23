package com.yulece.model.admin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 权限模块实体类
 * @author wangyichao@28ph.cn
 * @Title: AdminAcl
 * @Package com.yulece.model.admin
 * @Description:
 * @Date 创建时间2018/5/3-23:47
 **/
@Entity
public class AdminAcl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getAclId() {
        return aclId;
    }

    public void setAclId(Integer aclId) {
        this.aclId = aclId;
    }

    public String getAclName() {
        return aclName;
    }

    public void setAclName(String aclName) {
        this.aclName = aclName;
    }

    public Integer getAclModuleId() {
        return aclModuleId;
    }

    public void setAclModuleId(Integer aclModuleId) {
        this.aclModuleId = aclModuleId;
    }

    public String getAclUrl() {
        return aclUrl;
    }

    public void setAclUrl(String aclUrl) {
        this.aclUrl = aclUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAclSeq() {
        return aclSeq;
    }

    public void setAclSeq(Integer aclSeq) {
        this.aclSeq = aclSeq;
    }

    public String getAclRemark() {
        return aclRemark;
    }

    public void setAclRemark(String aclRemark) {
        this.aclRemark = aclRemark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }
}
