package com.yulece.admin.common.utils;

import com.yulece.admin.common.enums.ResultEnum;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @title: ResultVo.java
 * @Package: com.yulece.admin.common.utils
 * @author: wangyichao@yulece.com
 * @date: 创建时间2018年5月1日 - 下午4:48:02
 * @version: 1.0
 */
public class ResultVo<T> {
	private int code;
	private String message;
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private ResultVo(Integer code, String message, T data) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	private ResultVo(Integer code) {
		this.code = code;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createSuccessResult(String message, T data) {
		return new ResultVo(ResultEnum.SUCCESS.getCode(), message, data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createSuccessResult(Integer code) {
		return new ResultVo(code);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createErrorResult(String message, T data) {
		return new ResultVo(ResultEnum.ERROR.getCode(), message, data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createSuccessResult(T data) {
		return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createErrorResult(T data) {
		return new ResultVo(ResultEnum.ERROR.getCode(), ResultEnum.SUCCESS.getMessage(), data);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> ResultVo<T> createErrorResult(Integer code) {
		return new ResultVo(code);
	}
}
