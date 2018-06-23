package com.yulece.repository.admin;

import com.yulece.model.admin.AdminAcl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclRepository
 * @Package com.yulece.repository.admin
 * @Description:
 * @Date 创建时间2018/5/16-21:19
 **/
public interface AclRepository extends JpaRepository<AdminAcl,Integer> {

    @Query(value = "select count(acl_id) from admin_acl where acl_name = ?1 and acl_module_id!=?2",nativeQuery = true)
    Integer checkAclNameExist(String aclName, Integer aclModuleId);
}
