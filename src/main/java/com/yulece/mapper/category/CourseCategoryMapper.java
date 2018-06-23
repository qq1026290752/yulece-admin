package com.yulece.mapper.category;

import org.apache.ibatis.annotations.Param;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryMapper
 * @Package com.yulece.mapper.category
 * @Description:
 * @Date 创建时间2018/6/23-11:40
 **/
public interface CourseCategoryMapper {
    /**
     * 查询该类目名称条数
     * @param categoryId
     * @param categoryName
     * @return
     */
    int countCategoryName(@Param("categoryId") Integer categoryId,
                                         @Param("categoryName") String categoryName);

    /**
     * 查询课程类目类型是否占用
     * @param categoryId
     * @param categoryType
     * @return
     */
    int countCategoryType(@Param("categoryId") Integer categoryId,
                                         @Param("categoryType") Integer categoryType);
}
