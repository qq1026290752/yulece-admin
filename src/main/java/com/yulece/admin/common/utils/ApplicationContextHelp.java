package com.yulece.admin.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 获取上下文
 * @author wangyichao@28ph.cn
 * @Title: ApplicationContextHelp
 * @Package com.yulece.admin.common.utils
 * @Description:
 * @Date 创建时间2018/5/6-15:32
 **/
@Component("applicationContextHelp")
public class ApplicationContextHelp  implements ApplicationContextAware {

    private static ApplicationContext context ;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       context = applicationContext;
    }
    public static<T> T popBean(Class<T> tClass){
        if(context==null){
            return null;
        }
        return context.getBean(tClass);
    }

    public static<T> T getBean(String name,Class<T> clazz){
        if(context==null){
            return null;
        }
        return context.getBean(name,clazz);
    }
}
