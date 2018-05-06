package com.yulece.admin.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 测试validate工具
 * @author wangyichao@28ph.cn
 * @Title: TestVo
 * @Package com.yulece.admin.vo
 * @Description:
 * @Date 创建时间2018/5/6-10:57
 **/
@Data
public class TestVo {


    @NotBlank
    private String message;

    @NotNull
    private Integer id;
}
