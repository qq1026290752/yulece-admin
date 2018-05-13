package com.yulece.admin.common.utils;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * md5加密器
 * @author wangyichao@28ph.cn
 * @Title: HashUtils
 * @Package com.yulece.admin.common.utils
 * @Description:
 * @Date 创建时间2018/5/13-11:01
 **/
public class HashUtils {

    private static final HashFunction FUNCTION = Hashing.md5();

    //盐
    private static final String SALT = "YULECE";


    public static String entryPassWord (String password){
        return FUNCTION.hashString(password + SALT,Charset.forName("UTF-8")).toString();
    }
}
