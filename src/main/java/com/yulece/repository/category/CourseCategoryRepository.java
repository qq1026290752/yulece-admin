package com.yulece.repository.category;

import com.yulece.model.category.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryRepository
 * @Package com.yulece.repository.category
 * @Description: 课程类目 JPA 持久层
 * @Date 创建时间2018/6/23-11:46
 **/
public interface CourseCategoryRepository extends JpaRepository<CourseCategory,Integer> {

    @Query(value = "select * from course_category where category_type = ?1 " +
            "or category_type_parent = ?1" ,nativeQuery = true)
    List<CourseCategory> findAllByCategoryTypeOrCategoryTypeParent(int CategoryTypeParent);

}
