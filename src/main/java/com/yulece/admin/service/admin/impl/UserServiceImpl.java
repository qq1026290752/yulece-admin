package com.yulece.admin.service.admin.impl;

import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.common.utils.BeanValidator;
import com.yulece.admin.common.utils.PasswordUtil;
import com.yulece.admin.model.admin.AdminUser;
import com.yulece.admin.repository.admin.UserRepository;
import com.yulece.admin.service.admin.UserService;
import com.yulece.admin.vo.admin.UserParam;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: UserServiceImpl
 * @Package com.yulece.admin.service.admin.impl
 * @Description:
 * @Date 创建时间2018/5/12-11:27
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserParam userParam) {
        BeanValidator.check(userParam);
        if(checkEmailExist(userParam.getMail(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        if(checkTelePhoneExist(userParam.getTelephone(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        AdminUser newAdminUser = new AdminUser();
        //生成用户密码
        String password = PasswordUtil.randomPassword();
        BeanUtils.copyProperties(userParam,newAdminUser);
        newAdminUser.setPassWord(password);
        newAdminUser.setOperator("admin");//TODO
        newAdminUser.setOperateIp("127.0.0.1");//todo
        //todo sendEmail
        userRepository.save(newAdminUser);

    }

    @Override
    public void update(UserParam userParam) {
        BeanValidator.check(userParam);
        if(checkEmailExist(userParam.getMail(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        if(checkTelePhoneExist(userParam.getTelephone(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        Preconditions.checkNotNull(userParam.getUserId(),"您的用户ID出入不能为空");
        AdminUser beforeUser = userRepository.getOne(userParam.getUserId());
        Preconditions.checkNotNull(beforeUser,"查询不到此用户");
        AdminUser newAdminUser = new AdminUser();
        //生成用户密码
        //TODO 用户密码加密 引入spring security 进行管理
        BeanUtils.copyProperties(newAdminUser,userParam);
        //用户不允许在更新全部时候更新密码
        newAdminUser.setPassWord(beforeUser.getPassWord());
        newAdminUser.setOperator("admin");//TODO
        newAdminUser.setOperateIp("127.0.0.1");//todo
        //todo sendEmail
        userRepository.save(newAdminUser);


    }

    public boolean checkEmailExist(String email,Integer userId){
        if(userId == null){
            return userRepository.countAdminUserByMail(email) > 0;
        }
        return userRepository.countAdminUserByMailAndUserId(email,userId) > 0;
    }


    public boolean checkTelePhoneExist(String telePhone,Integer userId){
        if(userId == null){
            return userRepository.countAdminUserByTelephone(telePhone) > 0;
        }
        return userRepository.countAdminUserByTelephoneAndUserId(telePhone, userId)>0;
    }
}
