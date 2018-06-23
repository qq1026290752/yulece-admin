package com.yulece.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: MailServiceImpl
 * @Package com.yulece.service.common
 * @Description:
 * @Date 创建时间2018/5/13-16:30
 **/
@Service
public class MailServiceImpl implements MailService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendMail(String title, String Content, String address) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setSubject(title);
        mailMessage.setTo(address);
        mailMessage.setText(Content);
        sender.send(mailMessage);
        LOGGER.info("[用户注册]:邮件发送成功,发送邮箱为{}:",address);
    }
}
