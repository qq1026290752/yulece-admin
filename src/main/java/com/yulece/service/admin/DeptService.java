package com.yulece.service.admin;

import com.yulece.dto.admin.DeptLevelDto;
import com.yulece.vo.admin.DeptParam;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: DeptService
 * @Package com.yulece.service.admin
 * @Description:
 * @Date 创建时间2018/5/6-21:15
 **/
public interface DeptService {

    void save(DeptParam deptParam) ;

    /**
     * 更新部门
     * @param deptParam
     */
    void update(DeptParam deptParam);

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    DeptLevelDto getId(Integer id);
}
