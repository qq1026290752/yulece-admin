package com.yulece.vo.admin;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelParam
 * @Package com.yulece.vo.admin
 * @Description:
 * @Date 创建时间2018/5/15-20:28
 **/
public class AclModelParam {

    private Integer moduleId;
    @NotBlank(message = "权限模块名称不可以为空")
    @Length(message = "权限模块名称不能小于2,不能大于18",max = 18,min = 2)
    private String moduleName;
    @NotNull(message = "权限模块展示顺序不能为空")
    @Max(value = 1,message = "权限模块的状态选择不正确")
    @Min(value = 0,message = "权限模块的状态选择不正确")
    private Integer status;
    private Integer moduleParentId = 0 ;
    @NotNull(message = "此模块在父模块中的顺序不能为空")
    private Integer moduleSeq;
    @Length(message = "权限模块备注不能小于2,不能大于200",max = 190,min = 2)
    private String moduleRemark;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getModuleParentId() {
        return moduleParentId;
    }

    public void setModuleParentId(Integer moduleParentId) {
        this.moduleParentId = moduleParentId;
    }

    public Integer getModuleSeq() {
        return moduleSeq;
    }

    public void setModuleSeq(Integer moduleSeq) {
        this.moduleSeq = moduleSeq;
    }

    public String getModuleRemark() {
        return moduleRemark;
    }

    public void setModuleRemark(String moduleRemark) {
        this.moduleRemark = moduleRemark;
    }
}
