package com.yulece.admin.model.admin;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminDept
 * @Package com.yulece.admin.model.admin
 * @Description:
 * @Date 创建时间2018/5/6-17:18
 **/
@Entity
@Builder
@Table(name = "admin_dept")
public class AdminDept {

    @Id
    private Integer deptId;
    private String deptName;
    private String deptLevel;
    private Integer deptSeq;
    private String deptRemark;
    private Integer deptParentId;
    private String operator;
    private String operateIp;

    public AdminDept(Integer deptId, String deptName, String deptLevel, Integer deptSeq, String deptRemark, Integer deptParentId, String operator, String operateIp) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLevel = deptLevel;
        this.deptSeq = deptSeq;
        this.deptRemark = deptRemark;
        this.deptParentId = deptParentId;
        this.operator = operator;
        this.operateIp = operateIp;
    }

    public AdminDept() {

    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public Integer getDeptSeq() {
        return deptSeq;
    }

    public void setDeptSeq(Integer deptSeq) {
        this.deptSeq = deptSeq;
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark;
    }

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
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
