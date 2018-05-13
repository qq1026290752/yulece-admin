package com.yulece.admin.common.utils;

import com.yulece.admin.model.admin.AdminUser;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: RequestHoder
 * @Package com.yulece.admin.common.utils
 * @Description:
 * @Date 创建时间2018/5/13-10:20
 **/
public class RequestHoder {
    //用户进程
    private static ThreadLocal<AdminUser> adminUserThreadLocal = new ThreadLocal<>();

    private static ThreadLocal<HttpServletRequest> httpServletRequestThreadLocal = new ThreadLocal<>();

    public static void add(AdminUser adminUser){
        adminUserThreadLocal.set(adminUser);
    }
    public static void add(HttpServletRequest request){
        httpServletRequestThreadLocal.set(request);
    }

    /**
     * 获取当前用户
     * @return
     */
    public static AdminUser getUser(){
        return adminUserThreadLocal.get();
    }

    /**
     * 获取当前请求
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
       return httpServletRequestThreadLocal.get();
    }

    /**
     * 移除当前线程
     */
    public static void remove(){
        adminUserThreadLocal.remove();
        httpServletRequestThreadLocal.remove();
    }

}
