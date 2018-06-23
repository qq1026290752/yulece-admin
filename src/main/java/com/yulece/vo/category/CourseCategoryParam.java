package com.yulece.vo.category;

import com.yulece.model.category.CourseCategory;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 课程类目入参
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryParam
 * @Package com.yulece.system.vo.category
 * @Description:
 * @Date 创建时间2018/6/2-10:31
 **/
public class CourseCategoryParam {

    private Integer categoryId;
    @NotBlank(message = "课程类目不能为空")
    @Length(min = 4,max = 20,message = "课程类目长度需要在4-20之间")
    private String categoryName;
    @NotNull(message = "课程类目所在序列不能为空")
    private Integer categoryType;
    @NotNull(message = "课程类目需要选择指定父级目录")
    private Integer categoryTypeParent = 0 ;

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

    public static CourseCategory adapter(CourseCategoryParam param){
        CourseCategory courseCategory = new CourseCategory();
        BeanUtils.copyProperties(param,courseCategory);
        return courseCategory;
    }
}
