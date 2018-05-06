package com.yulece.admin.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 等级计算工具类
 * @author wangyichao@28ph.cn
 * @Title: LevelUtil
 * @Package com.yulece.admin.common.utils
 * @Description:
 * @Date 创建时间2018/5/6-21:31
 **/
public class LevelUtil {

    private static final String SEPARATOR = ".";

    private static final String ROOT = "0";

    public static String calculateLevel(String parentLevel,Integer parentId){
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else {
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }


}
