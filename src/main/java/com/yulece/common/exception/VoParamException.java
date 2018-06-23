package com.yulece.common.exception;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: VoParamException
 * @Package com.yulece.common.exception
 * @Description:
 * @Date 创建时间2018/5/6-11:28
 **/
public class VoParamException extends RuntimeException {

    public VoParamException() {
        super();
    }

    public VoParamException(String message) {
        super(message);
    }

    public VoParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoParamException(Throwable cause) {
        super(cause);
    }

    protected VoParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
