package com.yulece.admin.repository.admin;

import com.yulece.admin.model.admin.AdminAclModule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AclModelRepository
 * @Package com.yulece.admin.repository.admin
 * @Description:
 * @Date 创建时间2018/5/15-21:40
 **/
public interface AclModelRepository extends JpaRepository<AdminAclModule,Integer> {
}
