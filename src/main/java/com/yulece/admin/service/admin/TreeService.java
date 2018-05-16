package com.yulece.admin.service.admin;

import com.yulece.admin.dto.admin.AclModuleLevelDto;
import com.yulece.admin.dto.admin.DeptLevelDto;

import java.util.List;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 系统树定义
 * @author wangyichao@28ph.cn
 * @Title: TreeService
 * @Package com.yulece.admin.service.admin
 * @Description:
 * @Date 创建时间2018/5/7-21:01
 **/
public interface TreeService {

    List<DeptLevelDto> deptTree();

    List<AclModuleLevelDto> aclModuleTree();
}
