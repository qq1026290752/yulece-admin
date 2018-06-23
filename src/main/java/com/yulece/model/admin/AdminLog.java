package com.yulece.model.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 管理员操作日志表
 * @author wangyichao@28ph.cn
 * @Title: AdminLog
 * @Package com.yulece.model.admin
 * @Description:
 * @Date 创建时间2018/5/3-23:01
 **/
@Data
@Entity
public class AdminLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;
    private Integer type;//操作类型
    private Integer targetId;//操作表
    private String oldValue;//操作之前的记录
    private String newValue;//新的操作记录
    private String operator;//操作用户
    private String operateIp;//操作Ip
    private Date updateTime;//修改时间
    private Date createTime;//创建时间

}
