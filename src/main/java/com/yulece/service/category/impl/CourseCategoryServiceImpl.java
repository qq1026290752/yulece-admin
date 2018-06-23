package com.yulece.service.category.impl;

import com.yulece.common.enums.ParamEnum;
import com.yulece.common.exception.YuleceException;
import com.yulece.common.utils.BeanValidator;
import com.yulece.dto.category.CourseCategoryDto;
import com.yulece.mapper.category.CourseCategoryMapper;
import com.yulece.model.category.CourseCategory;
import com.yulece.repository.category.CourseCategoryRepository;
import com.yulece.service.category.CourseCategoryService;
import com.yulece.vo.category.CourseCategoryParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryServiceImpl
 * @Package com.yulece.service.category.impl
 * @Description:
 * @Date 创建时间2018/6/23-11:49
 **/
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepository courseCategoryRepository;
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * 1. 验证输入是否合法
     * 2. 验证 课程类目名称 && 课程类目类型
     * 3. 完成数据组装，保存到数据库
     */
    @Override
    public void save(CourseCategoryParam param) {
        BeanValidator.check(param);
        if(checkCategoryNameExist(param.getCategoryId(),param.getCategoryName())){
            throw new YuleceException(ParamEnum.CATEGORY_NAME_EXIST);
        }
        if(checkCategoryTypeExist(param.getCategoryId(),param.getCategoryType())){
            throw new YuleceException(ParamEnum.CATEGORY_TYPE_EXIST);
        }
        CourseCategory courseCategory = CourseCategoryParam.adapter(param);
        courseCategoryRepository.save(courseCategory);
    }

    @Override
    public void update(CourseCategoryParam param) {
        BeanValidator.check(param);
        //根据课程类目id查询课程类目是否存在
        CourseCategory categoryOne = courseCategoryRepository.getOne(param.getCategoryId());
        Preconditions.checkNotNull(categoryOne,"课程类目不存在");
        if(checkCategoryNameExist(param.getCategoryId(),param.getCategoryName())){
            throw new YuleceException(ParamEnum.CATEGORY_NAME_EXIST);
        }
        if(checkCategoryTypeExist(param.getCategoryId(),param.getCategoryType())){
            throw new YuleceException(ParamEnum.CATEGORY_TYPE_EXIST);
        }
        CourseCategory courseCategory = CourseCategoryParam.adapter(param);
        courseCategoryRepository.save(courseCategory);

    }

    @Override
    public CourseCategoryDto getCourseCategoryBycategoryTypeParent(int categoryTypeParent) {
        //根据课程父类目查询课程父类目以及其子类目
        List<CourseCategory> courseCategories = courseCategoryRepository.
                findAllByCategoryTypeOrCategoryTypeParent(categoryTypeParent);

        return CourseCategoryDto.adapter(courseCategories,categoryTypeParent);
    }

    private boolean checkCategoryNameExist(Integer categoryId, String categoryName) {
        return courseCategoryMapper.countCategoryName(categoryId,categoryName) != 0 ;
    }
    private boolean checkCategoryTypeExist(Integer categoryId, Integer categoryType) {
        return courseCategoryMapper.countCategoryType(categoryId,categoryType) != 0 ;
    }

}
