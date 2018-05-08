package com.yulece.admin.vo.admin;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptParam
 * @Package com.yulece.admin.vo.admin
 * @Description:
 * @Date 创建时间2018/5/6-20:50
 **/
public class DeptParam {

    private Integer deptId;

    @NotBlank(message = "部门名称不可以为空")
    @Length(message = "部门名称不能小于2,不能大于18",max = 18,min = 2)
    private String deptName;

    @NotNull(message = "部门展示顺序不能为空")
    private Integer deptSeq;

    @Length(max = 50,message = "备注长度需要控制在50个字之内")
    private String deptRemark;
    private Integer deptParentId = 0;

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
}
