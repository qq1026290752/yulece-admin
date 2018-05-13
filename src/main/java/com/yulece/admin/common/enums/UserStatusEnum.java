package com.yulece.admin.common.enums;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 用户状态枚举
 * @author wangyichao@28ph.cn
 * @Title: UserStatusEnum
 * @Package com.yulece.admin.common.enums
 * @Description:
 * @Date 创建时间2018/5/12-17:07
 **/
public enum  UserStatusEnum {
    NONACTIVATED_STATUS(0,"用户未激活"),
    NORMAL_STATUS(1,"正常登录"),
    LOCK_STATUS(2,"被锁定状态");

    private int code;
    private String message;

    UserStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
