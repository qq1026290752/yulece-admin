package com.yulece.common.enums;
/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * @title: ResultEnum.java
 * @Package: com.yulece.common.enums
 * @author: wangyichao@yulece.com   
 * @date: 创建时间2018年5月1日 - 下午4:52:22 
 * @version: 1.0
 */
public enum ResultEnum {
	SUCCESS(0,"success"),
    ERROR(1,"error")
    ;

    private int code;
    private String message;

    ResultEnum(Integer code, String message){
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
