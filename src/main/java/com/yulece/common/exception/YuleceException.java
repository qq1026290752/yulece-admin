package com.yulece.common.exception;

import com.yulece.common.enums.ExceptionEnum;
import com.yulece.common.enums.ParamEnum;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 异常处理信息类
 * @title: YuleceException.java
 * @Package: com.yulece.common.exception
 * @author: wangyichao@yulece.com
 * @date: 创建时间2018年5月1日 - 下午4:57:09
 * @version: 1.0
 */
public class YuleceException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 3393688888698161757L;
	private Integer code;

	public YuleceException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());
		this.code = exceptionEnum.getCode();
	}
	public YuleceException(ParamEnum paramEnum) {
		super(paramEnum.getMessage());
		this.code = paramEnum.getCode();
	}

	public YuleceException(Integer code, String message) {
		super(message);
		this.code = code;
	}

}
