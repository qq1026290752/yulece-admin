package com.yulece.admin.mapper.dept;

import com.yulece.admin.model.admin.AdminDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptMapper
 * @Package com.yulece.admin.mapper.dept
 * @Description:
 * @Date 创建时间2018/5/8-20:41
 **/
public interface DeptMapper  {

    AdminDept getOne(@Param("id") Integer id);

    List<AdminDept> getDeptChildListByLevel(@Param("value") String level);

    void batchUpdateLavel(@Param("adminDepts") List<AdminDept> adminDepts);

    Integer countByNameAndParentId(@Param("name") String name,
                               @Param("parentId") Integer parentId,
                               @Param("deptId")Integer deptId);
}
