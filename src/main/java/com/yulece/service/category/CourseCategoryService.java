package com.yulece.service.category;

import com.yulece.dto.category.CourseCategoryDto;
import com.yulece.vo.category.CourseCategoryParam;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryService
 * @Package com.yulece.service.category
 * @Description: 课程类目服务层次
 * @Date 创建时间2018/6/23-11:48
 **/
public interface CourseCategoryService {

    /**
     * 1. 验证输入是否合法
     * 2. 验证 课程类目名称 && 课程类目类型
     * 3. 完成数据组装，保存到数据库
     */
    void save(CourseCategoryParam param);
    /**
     * 1. 验证输入是否合法
     * 2. 查询课程类目是否存在
     * 2. 验证 课程类目名称 && 课程类目类型
     * 3. 完成数据组装，保存到数据库
     */
    void update(CourseCategoryParam param);

    /**
     *  根据课程类目父类型查询子类型
     */
    CourseCategoryDto getCourseCategoryBycategoryTypeParent(int categoryTypeParent);
}
