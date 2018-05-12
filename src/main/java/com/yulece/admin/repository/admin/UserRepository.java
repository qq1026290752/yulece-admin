package com.yulece.admin.repository.admin;

import com.yulece.admin.model.admin.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserRepository
 * @Package com.yulece.admin.repository.admin
 * @Description:
 * @Date 创建时间2018/5/6-15:48
 **/
public interface UserRepository extends JpaRepository<AdminUser,Integer> {

    /**
     * 查询用户邮箱是否相同
     * @param mail
     * @param id
     * @return
     */

    Integer countAdminUserByMailAndUserId(String mail, Integer id);
    /**
     * 查询用户邮箱是否相同
     * @param mail
     * @return
     */

    Integer countAdminUserByMail(String mail);

    /**
     * 查询手机号是否相同
     * @param telePhone
     * @param id
     * @return
     */
    Integer countAdminUserByTelephoneAndUserId(String telePhone, Integer id);
    /**
     * 查询手机号是否相同
     * @param telePhone
     * @return
     */
    Integer countAdminUserByTelephone(String telePhone);
}