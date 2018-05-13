package com.yulece.admin.service.admin.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.hash.Hashing;
import com.yulece.admin.common.enums.ExceptionEnum;
import com.yulece.admin.common.enums.UserStatusEnum;
import com.yulece.admin.common.exception.YuleceException;
import com.yulece.admin.common.utils.*;
import com.yulece.admin.model.admin.AdminUser;
import com.yulece.admin.repository.admin.UserRepository;
import com.yulece.admin.service.admin.UserService;
import com.yulece.admin.service.common.MailService;
import com.yulece.admin.vo.admin.UserParam;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private MailService mailService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Value("${domain.address}")
    private String address;

    private final Cache<String,String> registerCache = CacheBuilder.newBuilder().
            maximumSize(100).expireAfterAccess(1,TimeUnit.MINUTES).
            removalListener(new RemovalListener<String, String>() {
        @Override
        public void onRemoval(RemovalNotification<String, String> notification) {
            LOGGER.info("邮箱{}超过5f分钟未被激活,删除此用户邮箱",notification.getValue());
            userRepository.deleteByMail(notification.getValue());
        }
    }).build();

    @Override
    public void save(UserParam userParam) {
        BeanValidator.check(userParam);
        if(checkEmailExist(userParam.getMail(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        if(checkTelePhoneExist(userParam.getTelephone(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_TELEPHONE_ERROR);
        }
        if(checkUserNameExist(userParam.getUserName(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_USERNAME_ERROR);
        }
        AdminUser newAdminUser = new AdminUser();
        //生成用户密码
        String password = PasswordUtil.randomPassword();
        BeanUtils.copyProperties(userParam,newAdminUser);
        newAdminUser.setStatus(UserStatusEnum.NONACTIVATED_STATUS.getCode());
        newAdminUser.setPassWord(HashUtils.entryPassWord(password));
        newAdminUser.setOperator("admin");//TODO
        newAdminUser.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));//todo
        registerNotify(newAdminUser.getMail(),password);
        userRepository.save(newAdminUser);

    }

    @Override
    public void update(UserParam userParam) {
        BeanValidator.check(userParam);
        if(checkEmailExist(userParam.getMail(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_MAIL_ERROR);
        }
        if(checkTelePhoneExist(userParam.getTelephone(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_TELEPHONE_ERROR);
        }
        if(checkUserNameExist(userParam.getUserName(),userParam.getUserId())){
            throw new YuleceException(ExceptionEnum.USER_USERNAME_ERROR);
        }
        Preconditions.checkNotNull(userParam.getUserId(),"您的用户ID出入不能为空");
        AdminUser beforeUser = userRepository.getOne(userParam.getUserId());
        Preconditions.checkNotNull(beforeUser,"查询不到此用户");
        AdminUser newAdminUser = new AdminUser();
        //生成用户密码
        //TODO 用户密码加密 引入spring security 进行管理
        BeanUtils.copyProperties(userParam,newAdminUser);
        //用户不允许在更新全部时候更新密码
        newAdminUser.setPassWord(beforeUser.getPassWord());
        newAdminUser.setOperator("admin");
        newAdminUser.setOperateIp(IpUtil.getRemoteIp(RequestHoder.getHttpServletRequest()));
        newAdminUser.setStatus(beforeUser.getStatus());
        userRepository.save(newAdminUser);


    }

    /**
     * 发送邮件激活用户
     *
     * @param mail
     */
    @Async
    public void registerNotify(String mail,String password) {
        /**
         * 1.缓存KEY与MAIL的关系
         * 2.借助spring mail 发送邮件
         * 3.借助异步框架异步操作
         */
        String randomKey = RandomStringUtils.randomAlphabetic(10);
        registerCache.put(randomKey,mail);
        //激活URL
        String activateUrl = address + "/accounts/validateMail/admin?key="+randomKey;
        String context = "尊敬的用户: \n\t您登陆本平台的密码是:" + password +".\n\t" +
                "\t\t\t\t请点击如下网址激活: "+activateUrl;
        mailService.sendMail("娱乐侧后台管理账户验证",context,mail);


    }

    @Override
    public Page<AdminUser> page(Integer deptId, Pageable pageable) {
        return userRepository.page(deptId,pageable);
    }

    @Override
    public void enable(String key) {
       //邮箱地址
        String mail = registerCache.getIfPresent(key);
        if(StringUtils.isBlank(mail)){
            throw new YuleceException(ExceptionEnum.MAIL_ACTIVATE_ERROR);
        }
        userRepository.updateStatusWhereMail(UserStatusEnum.NORMAL_STATUS.getCode(),mail);

    }

    public boolean checkEmailExist(String email,Integer userId){
        if(userId == null){
            Integer result = userRepository.countAdminUserByMail(email);
            return result >0;
        }
        return userRepository.countAdminUserByMailAndUserId(email,userId) > 0;
    }


    public boolean checkTelePhoneExist(String telePhone,Integer userId){
        if(userId == null){
            Integer result = userRepository.countAdminUserByTelephone(telePhone);
            return result > 0;
        }
        return userRepository.countAdminUserByTelephoneAndUserId(telePhone, userId)>0;
    }
    public boolean checkUserNameExist(String telePhone,Integer userId){
        if(userId == null){
            Integer result = userRepository.countAdminUserByUserName(telePhone);
            return result > 0;
        }
        return userRepository.countAdminUserByUserNameAndUserId(telePhone, userId)>0;
    }



}
