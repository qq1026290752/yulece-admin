package com.yulece.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yulece.common.enums.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @title: ResultVo.java
 * @Package: com.yulece.common.utils
 * @author: wangyichao@yulece.com
 * @date: 创建时间2018年5月1日 - 下午4:48:02
 * @version: 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL )
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

	public ResultVo(int code, T data) {
		this.code = code;
		this.data = data;
		this.message = ResultEnum.SUCCESS.getMessage();
	}

	private ResultVo(Integer code) {
		this.code = code;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createSuccessResult(String message, T data) {
		return new ResultVo(ResultEnum.SUCCESS.getCode(), message, data);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createSuccessResult() {
		return new ResultVo(ResultEnum.SUCCESS.getCode(),null);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createErrorResult(String message, T data) {
		return new ResultVo(ResultEnum.ERROR.getCode(), message, data);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createSuccessResult(T data) {
		return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
	}


	public static <T> ResultVo<T> createSuccessResult(String message) {
		return new ResultVo(ResultEnum.SUCCESS.getCode(), message, null);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createErrorResult(T data) {
		return new ResultVo(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage(), data);
	}

	public static <T> ResultVo<T> createErrorResult(String excptingMsg) {
		return new ResultVo(ResultEnum.ERROR.getCode(), excptingMsg, null);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T> ResultVo<T> createErrorResult(Integer code) {
		return new ResultVo(code);
	}




}