package com.yulece.admin.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *  redis 分布式锁
 * @author wangyichao@28ph.cn
 * @Title: RedisLock
 * @Package com.yulece.admin.common.utils
 * @Description:
 * @Date 创建时间2018/5/29-21:41
 **/
@Component
@Slf4j
public class RedisLock {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean lock(String key,String value){
        if(stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        //拿到当前被上锁的value 比如说key为商品ID value是上锁的超时世间
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //当前时间是否大于上次设定超时时间
        if (!StringUtils.isBlank(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis() ){
            //拿到当前value 并且设置为当前线程value
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
            //currentValue == oldValue证明拿到的是同一把锁
            if(!StringUtils.isBlank(oldValue) && oldValue.equals(currentValue)){
                //当前线程上锁成功
                return true;
            }
        }
        return false;
    }

    public void unLock(String key,String value){
        try{
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (StringUtils.isNotBlank(currentValue) && currentValue.equals(value)){
                stringRedisTemplate.delete(key);
            }
        }catch (Exception e){
            log.error("[分布式锁]:解锁异常 " );
        }
    }

}
