package com.yulece.controller.category;

import com.yulece.common.utils.ResultVo;
import com.yulece.dto.category.CourseCategoryDto;
import com.yulece.model.category.CourseCategory;
import com.yulece.service.category.CourseCategoryService;
import com.yulece.vo.category.CourseCategoryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: CourseCategoryController
 * @Package com.yulece.controller.category
 * @Description: 课程类目控制层
 * @Date 创建时间2018/6/23-11:41
 **/
@RestController
@RequestMapping("/admin/category")
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @PostMapping
    public ResultVo<String> save(CourseCategoryParam param){
        courseCategoryService.save(param);
        return ResultVo.createSuccessResult();
    }
    @PutMapping
    public ResultVo<String> update(CourseCategoryParam param){
        courseCategoryService.update(param);
        return ResultVo.createSuccessResult();
    }


    @GetMapping("/getCourseCategoryDtoByCategoryType/{categoryType}")
    public ResultVo<CourseCategoryDto> getCourseCategoryDtoByCategoryType(
                            @PathVariable(value = "categoryType",required = true)int categoryType){
        CourseCategoryDto categoryDto = courseCategoryService.getCourseCategoryBycategoryTypeParent(categoryType);
        return ResultVo.createSuccessResult(categoryDto);
    }
}
