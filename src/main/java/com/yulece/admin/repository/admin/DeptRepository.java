package com.yulece.admin.repository.admin;

import com.yulece.admin.model.admin.AdminDept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptRepository
 * @Package com.yulece.admin.repository.admin
 * @Description:
 * @Date 创建时间2018/5/6-21:11
 **/
public interface DeptRepository extends JpaRepository<AdminDept,Integer> {
}
