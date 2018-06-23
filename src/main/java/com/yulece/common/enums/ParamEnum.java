package com.yulece.common.enums;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: ParamEnum
 * @Package com.yulece.common.enums
 * @Description:
 * @Date 创建时间2018/5/6-21:24
 **/
public enum ParamEnum {
    DEPT_NAME_EXIST(0,"部门名称在同一级目录下不能重复.")
    ;

    private int code;
    private String message;

    ParamEnum(Integer code, String message){
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
