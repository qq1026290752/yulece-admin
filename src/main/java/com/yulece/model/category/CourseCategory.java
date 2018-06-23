package com.yulece.model.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategory
 * @Package com.yulece.model.category
 * @Description: 课程类目实体
 * @Date 创建时间2018/6/23-11:22
 **/
@Entity
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String  categoryName;
    private Integer categoryType;
    private Integer categoryTypeParent;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getCategoryTypeParent() {
        return categoryTypeParent;
    }

    public void setCategoryTypeParent(Integer categoryTypeParent) {
        this.categoryTypeParent = categoryTypeParent;
    }
}
