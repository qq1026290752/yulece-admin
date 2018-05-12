package com.yulece.admin.common.enums;
/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * @title: ExceptionEnum.java
 * @Package: com.yulece.admin.common.enums 
 * @author: wangyichao@yulece.com   
 * @date: 创建时间2018年5月1日 - 下午4:54:52 
 * @version: 1.0
 */
public enum ExceptionEnum {
    COPY_BEAN_ERROR(0,"实体拷贝异常"),
    /*用户相关异常*/
    USER_MAIL_ERROR(31,"用户email异常"),
    USER_TELEPHONE_ERROR(32,"用户手机号异常"),
    /*部门相关异常*/
    DEPT_NOT_NULL(51,"当前查询部门为空")
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
