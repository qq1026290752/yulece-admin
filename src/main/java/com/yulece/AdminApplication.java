package com.yulece;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * @title: AdminApplication.java
 * @Package: com.yulece.admin 
 * @author: wangyichao@yulece.com   
 * @date: 创建时间2018年5月1日 - 下午1:32:09 
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.yulece.mapper")
@EnableAsync
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
