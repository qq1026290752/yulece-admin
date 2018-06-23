package com.yulece.vo.admin;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 权限点信息参数
 * @author wangyichao@28ph.cn
 * @Title: AclParam
 * @Package com.yulece.vo.admin
 * @Description:
 * @Date 创建时间2018/5/16-20:33
 **/
public class AclParam {

    private Integer aclId;
    @NotBlank(message = "权限点信息不能为空")
    @Length(message = "权限点名称长度应在2-20之间",max = 20,min = 2)
    private String aclName;
    @NotNull(message = "请选择对应你的权限模块")
    private Integer aclModuleId;

    @Length(message = "权限点地址长度应在2-200之间",max = 200,min = 2)
    private String aclUrl;
    private Integer status;
    @NotNull(message = "必须制定权限点的类型")
    @Max(value = 2,message = "权限点的类型不正确")
    @Min(value = 0,message = "权限点的类型不正确")
    private Integer type;
    @NotNull(message = "权限点在该模块中的排序不能为空")
    private Integer aclSeq;

    @Length(message = "权限点备注长度应在2-64之间",max = 64,min = 2)
    private String aclRemark;

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
}
