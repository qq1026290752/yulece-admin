package com.yulece.mapper.admin;

import com.yulece.model.admin.AdminDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptMapper
 * @Package com.yulece.mapper.dept
 * @Description:
 * @Date 创建时间2018/5/8-20:41
 **/
public interface DeptMapper  {

    AdminDept getOne(@Param("id") Integer id);

    List<AdminDept> getDeptChildListByLevel(@Param("value") String level);

    void batchUpdateLevel(@Param("adminDepts") List<AdminDept> adminDepts);

    Integer countByNameAndParentId(@Param("name") String name,
                               @Param("parentId") Integer parentId,
                               @Param("deptId")Integer deptId);
}
