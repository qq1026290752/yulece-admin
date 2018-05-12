package com.yulece.admin.vo.admin;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserParam
 * @Package com.yulece.admin.vo.admin
 * @Description:
 * @Date 创建时间2018/5/12-10:49
 **/
public class UserParam {

    private Integer userId;
    @NotBlank(message = "请输入用户名")
    @Length(min = 6 ,max =20 ,message ="用户名长度应在6-20为之间" )
    private String userName;
    @NotBlank(message = "用户昵称不能为空")
    private String nikeName;
    @NotBlank(message = "请输入联系方式")
    @Length(min = 11 ,max =13 ,message ="大陆常用的联系方式在11位" )
    private String telephone;
    @NotBlank(message = "请输入联系邮箱")
    @Length(min = 6 ,max =40 ,message ="邮箱长度应在6-40为之间" )
    private String mail;
    @NotNull(message = "请选择用户所在部门")
    private Integer userDept;//用户所属部门
    @NotBlank(message = "请上上传您喜爱的头像")
    private String headerUrl;
    @Min(value = 0,message = "用户状态不合法")
    @Max(value = 2,message = "用户状态不合法")
    @NotNull(message = "用户状态不能为空")
    private Integer status;
    @Length(min = 0 ,max =64 ,message ="用户备注长度应在6-40为之间" )
    private String userRemark="";//备注

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getUserDept() {
        return userDept;
    }

    public void setUserDept(Integer userDept) {
        this.userDept = userDept;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }
}
