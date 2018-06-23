package com.yulece.dto.category;

import com.yulece.model.category.CourseCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryDto
 * @Package com.yulece.dto.category
 * @Description:
 * @Date 创建时间2018/6/23-11:45
 **/
public class CourseCategoryDto {

    private String  categoryName;
    private Integer categoryType;

    List<CourseCategoryDto> courseCategoryDtos = new ArrayList<>();


    public CourseCategoryDto(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public CourseCategoryDto() {
    }

    public static CourseCategoryDto adapter(List<CourseCategory> courseCategories, int categoryType){
        CourseCategoryDto dto = new CourseCategoryDto("全部一级目录",0);
        for (CourseCategory courseCategory : courseCategories) {
            if(courseCategory.getCategoryType() == categoryType){
                dto = new CourseCategoryDto(courseCategory.getCategoryName(),categoryType);
                break;
            }
        }



        List<CourseCategoryDto> courseCategoryDtos = courseCategories.stream()
                .filter(e -> e.getCategoryType()!=categoryType)
                .map(e -> new CourseCategoryDto(e.getCategoryName(), e.getCategoryType()))
                .collect(Collectors.toList());
        dto.setCourseCategoryDtos(courseCategoryDtos);
        return dto;
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

    public List<CourseCategoryDto> getCourseCategoryDtos() {
        return courseCategoryDtos;
    }

    public void setCourseCategoryDtos(List<CourseCategoryDto> courseCategoryDtos) {
        this.courseCategoryDtos = courseCategoryDtos;
    }
}
