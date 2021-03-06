package com.yulece.common.enums;
/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * @title: ExceptionEnum.java
 * @Package: com.yulece.common.enums
 * @author: wangyichao@yulece.com   
 * @date: 创建时间2018年5月1日 - 下午4:54:52 
 * @version: 1.0
 */
public enum ExceptionEnum {
    COPY_BEAN_ERROR(0,"实体拷贝异常"),
    MAIL_ACTIVATE_ERROR(1,"邮箱激活时间已过期,请重新激活"),
    /*用户相关异常*/
    USER_MAIL_ERROR(31,"用户email异常"),
    USER_TELEPHONE_ERROR(32,"用户手机号异常"),
    USER_USERNAME_ERROR(33,"用户名异常"),
    /*部门相关异常*/
    DEPT_NOT_NULL(51,"当前查询部门为空"),
    /*权限模块异常*/
    ACL_MODEL_NAME_EXIST_NULL(61,"权限模块名称不能重复"),
    ACL_NAME_EXIST_NULL(66,"权限点名称不能重复")
	;
	private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
