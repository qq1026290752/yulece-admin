package com.yulece.admin.common.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;

/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * @title: DuridConfig.java
 * @Package: com.yulece.admin.common.config
 * @author: wangyichao@yulece.com   
 * @date: 创建时间2018年5月1日 - 下午2:44:12 
 * @version: 1.0
 */
@EnableAutoConfiguration
public class DuridConfig {

	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.druid")
	public  DataSource duridDatasource() {
		DruidDataSource build = DruidDataSourceBuilder.create().build();
		build.setProxyFilters(Lists.newArrayList(statFilter()));
		return build;
	}
	
	/**
	 * 配置过滤器
	 * @return
	 */
	@Bean
	public Filter statFilter() {
		StatFilter filter = new StatFilter();
		filter.setSlowSqlMillis(5000);
		filter.setLogSlowSql(true);
		filter.setMergeSql(true);
		return filter;
	}
	
	
	/**
	 * 配置druid监控
	 * @return
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}


}
