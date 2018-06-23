package com.yulece.repository.admin;

import com.yulece.model.admin.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserRepository
 * @Package com.yulece.repository.admin
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
    @Query(value = "select count(user_id) from admin_user where mail = ?1 AND user_id != ?2",nativeQuery = true)
    Integer countAdminUserByMailAndUserId(@Param("mail") String mail, @Param("id") Integer id);
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
    @Query(value = "select count(user_id) from admin_user where telephone = ?1 AND user_id != ?2",nativeQuery = true)
    Integer countAdminUserByTelephoneAndUserId(@Param("telePhone") String telePhone, @Param("id") Integer id);
    /**
     * 查询手机号是否相同
     * @param telePhone
     * @return
     */
    Integer countAdminUserByTelephone(String telePhone);
    /**
     * 查询用户名是否相同
     * @param userName
     * @param id
     * @return
     */
    @Query(value = "select count(user_id) from admin_user where user_name = ?1 AND user_id != ?2",nativeQuery = true)
    Integer countAdminUserByUserNameAndUserId(@Param("user_name") String userName, @Param("id") Integer id);
    /**
     * 查询用户名是否相同
     * @param userName
     * @return
     */
    Integer countAdminUserByUserName(String userName);

    /**
     * 分页查询用户数据
     * @param deptId
     * @param pageable
     * @return
     */
    @Query(value = "select u.* from  admin_user u  where user_dept = ?1",
            countQuery = "select count(1) from  admin_user u  where user_dept = ?1",
            nativeQuery = true)
    Page<AdminUser> page(Integer deptId, Pageable pageable);

    @Modifying@Transactional
    @Query(value = "delete from admin_user where mail =?1",nativeQuery = true)
    Integer deleteByMail(String mail);

    @Modifying@Transactional
    @Query(value = "update admin_user set status=?1 where mail = ?2",nativeQuery = true)
    int updateStatusWhereMail(Integer status, String mail);
}