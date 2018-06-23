package com.yulece.repository.admin;

import com.yulece.model.admin.AdminAclModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelRepository
 * @Package com.yulece.repository.admin
 * @Description:
 * @Date 创建时间2018/5/15-21:40
 **/
public interface AclModelRepository extends JpaRepository<AdminAclModule,Integer> {

    @Query(value = "SELECT COUNT(module_id) FROM admin_acl_module WHERE " +
            "module_name = ?1 AND module_parent_id!=?2 ",nativeQuery = true)
    Integer checkModelNameExist(String modelName, Integer modelParentId);


    @Query(value = "SELECT COUNT(module_id) FROM admin_acl_module WHERE " +
            "module_name = ?1 AND module_id=?3 AND module_parent_id!=?2 ",nativeQuery = true)
    Integer checkModelNameExist(String modelName, Integer modelParentId,Integer modelId);

    @Query(value = "select * from admin_dept where dept_level like concat(concat(?1),'.%')",nativeQuery = true)
    List<AdminAclModule> getDeptChildListByLevel(String moduleLevel);
}
