package com.yulece.admin.service.common;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: MailService
 * @Package com.yulece.admin.service.common
 * @Description:
 * @Date 创建时间2018/5/13-16:29
 **/
public interface MailService {

    void sendMail(String title,String Content,String address);
}
