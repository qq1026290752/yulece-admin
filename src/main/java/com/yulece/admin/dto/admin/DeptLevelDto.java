package com.yulece.admin.dto.admin;

import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.model.admin.AdminDept;
import org.apache.commons.beanutils.BeanUtils;
import org.assertj.core.util.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptLevelDto
 * @Package com.yulece.admin.dto.admin
 * @Description:
 * @Date 创建时间2018/5/7-20:54
 **/
public class DeptLevelDto extends AdminDept {

    private List<DeptLevelDto> deptLevelDtos = Lists.newArrayList();

    public List<DeptLevelDto> getDeptLevelDtos() {
        return deptLevelDtos;
    }

    public void setDeptLevelDtos(List<DeptLevelDto> deptLevelDtos) {
        this.deptLevelDtos = deptLevelDtos;
    }

    public static DeptLevelDto adapt(AdminDept adminDept) throws YuleceException{
        DeptLevelDto deptLevelDto = new DeptLevelDto();
        try {
            BeanUtils.copyProperties(adminDept,deptLevelDto);
        } catch (Exception e) {
            throw new YuleceException(ExceptionEnum.COPY_BEAN_ERROR);
        }
        return deptLevelDto;
    }
}
