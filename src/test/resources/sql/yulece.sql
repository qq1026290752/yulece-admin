CREATE DATABASE `yulece_aike` CHARACTER SET 'utf8' COLLATE 'utf8_bin';
create TABLE `admin_user`(
    `user_id` int not null auto_increment,
    `user_name` VARCHAR(32) not null comment '登录账户',
    `pass_word` VARCHAR(64) not NULL comment '密码',
    `nike_name` VARCHAR(32) NOT NULL comment '用户名称',
    `telephone` VARCHAR(16)	NOT NULL COMMENT '用户手机号',
    `mail` VARCHAR(128) NOT NULL comment '用户邮箱',
    `header_url` VARCHAR(256) not NULL comment '用户头像',
    `status` INT NOT NULL DEFAULT '0' comment '用户状态 0为在职,1为离职 ',
    `user_remark` VARCHAR(64) NOT NULL comment '备注',
    `operator` VARCHAR(25) NOT NULL comment '操作者',
    `operate_ip` VARCHAR(25) NOT NULL comment '操作IP',
	`user_dept` int NOT NULL comment '用户所属部门',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `user_id` ),
     KEY `idx_login` (`user_name`),
     UNIQUE KEY `uqe_username` (`user_name`)
) comment '后台管理员表' ;
CREATE TABLE `admin_dept`(
    `dept_id` INT NOT NULL auto_increment comment '部门ID',
    `dept_name` VARCHAR(20) NOT NULL comment '部门名称',
    `dept_level` VARCHAR(20) NOT NULL comment '部门等级',
    `dept_seq` INT NOT NULL comment '部门在当前层级的排序',
    `dept_remark`　VARCHAR(64) NOT NULL comment '备注',
    `dept_parent_id` INT not NULL comment '父级目录',
    `operator` VARCHAR(25) NOT NULL comment '操作者',
    `operate_ip` VARCHAR(25) NOT NULL comment '操作IP' 
    `operate_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ( `dept_id` )
) comment '部门表';
CREATE TABLE `admin_acl_module` (
`module_id` INT NOT NULL auto_increment COMMENT '权限模块ID',
`module_name` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块名称',
`module_parent_id` INT NOT NULL COMMENT '父级目录',
`module_level` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块等级',
`status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`module_seq` INT NOT NULL COMMENT '该模块在当前层级的排序',
`module_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `module_id` ) 
) COMMENT '权限模块表'

CREATE TABLE `admin_acl` (
`acl_id` INT NOT NULL auto_increment COMMENT '权限模块ID',
`acl_name` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块名称',
`acl_module_id` INT NOT NULL COMMENT '权限模块id',
`acl_url` VARCHAR ( 64 ) NOT NULL COMMENT 'url',
`type` INT NOT NULL DEFAULT '-1' COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
`status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`acl_seq` INT NOT NULL COMMENT '权限在当前层级的排序',
`acl_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `acl_id` ) 
) COMMENT '权限表'
CREATE TABLE `admin_role` (
`role_id` INT NOT NULL auto_increment COMMENT '角色ID',
`role_name` VARCHAR ( 20 ) NOT NULL COMMENT '角色名称',
`role_type` INT NOT NULL DEFAULT '-1' COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
`role_status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`role_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_id` ),
UNIQUE KEY `uqe_rolename` (`role_name`)
) COMMENT '角色表'

CREATE TABLE `admin_role_user` (
`role_user_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`user_id` int not null comment '用户ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` )
) COMMENT '角色用户关联关系表'


CREATE TABLE `admin_role_acl` (
`role_acl_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`acl_id` int not null comment '权限ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` )
) COMMENT '角色权限关联关系表'


CREATE TABLE `admin_log` (
`log_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`type` INT NOT NULL COMMENT '操作类型',
`target_id` int not null comment '操作ID',
`old_value` VARCHAR(1000) not null comment '操作之前的记录',
`new_value` varchar(1000) comment '新的操作记录',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `log_id` ) 
) COMMENT '权限记录日志表'
CREATE TABLE `consumer_user`(
    `consumer_id` int not null auto_increment,
    `consumer_name` VARCHAR(32) not null comment '消费者登录账户',
    `consumer_word` VARCHAR(64) not NULL comment '消费者密码',
    `consumer_nike_name` VARCHAR(32) NOT NULL comment '消费者用户名称',
    `consumer_gender` INT not NULL comment '用户性别',
    `consumer_desc` VARCHAR(500) NOT NULL DEFAULT '这位同学很懒，木有签名的说～' comment '用户签名',
    `consumer_integral` INT NOT NULL default '0' comment '用户积分',
    `consumer_fans` INT NOT NULL DEFAULT '0' comment '用户粉丝',
    `consumer_email` VARCHAR(64) comment '用户邮箱',
    `consumer_phone` VARCHAR(11) comment '用户手机号',
    `consumer_status` INT NOT NULL DEFAULT '0' comment '消费者状态 0 未激活 1 已激活'
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `consumer_id` ),
     KEY `idx_consumer_phone` (`consumer_phone`),
     UNIQUE KEY `uqe_consumername` (`consumer_name`)
) COMMENT '消费者-用户表';

CREATE TABLE `course_table`(
    `course_id` int not null auto_increment,
    `course_name` VARCHAR(24) not NULL comment '课程名称',
    `course_title` VARCHAR(32) not null comment '课程副标题',
    `course_difficulty` INT NOT null DEFAULT '0' comment '课程难度',
    `course_time` BIGINT NOT NULL comment '学习所用时间',
    `learn_number` INT not NULL DEFAULT '0' comment '学习人数', 
    `collect_number` INT not NULL DEFAULT '0' comment '收藏次数',
    `course_desc` TEXT NOT NULL comment '课程简介',
    `course_price` decimal(8,2) NOT NULL comment '课程价格',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `environment_parameter` VARCHAR (1000) NOT NULL comment '需要的电脑环境配置/JSON格式',
    `course_require` VARCHAR(300) NOT NULL comment '学习要求',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `category_id` INT not NULL comment '类目ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `course_id` ),
     KEY `idx_category` (`category_id`),
     UNIQUE KEY `uqe_coursename` (`course_name`)
) comment '课程表';

CREATE TABLE `course_category` (
    `category_id` INT NOT NULL auto_increment,
    `category_name` VARCHAR ( 64 ) NOT NULL COMMENT '类目名称',
    `category_type` INT NOT NULL,
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ( `category_id` ),
UNIQUE KEY `uqe_category_type` ( `category_type` ) 
) COMMENT '类目表';

create TABLE `order_master` (
    `order_id` VARCHAR(128) NOT NULL comment '订单ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `order_price` decimal(8,2) NOT NULL comment '订单总价',
    `order_discounts` decimal(8,2) comment '优惠价格',
    `discount_id` VARCHAR(64) comment '优惠券ID',
    `order_status` INT NOT NULL DEFAULT '0' comment '0 新建 1支付完成 2订单过期',
    `order_pay` INT not NULL DEFAULT '0' comment '0未支付 1已支付',
    `order_pay_type` INT NOT NULL COMMENT '支付类型 0支付宝 1微信 3银联',
    `pay_time` TIMESTAMP comment '支付时间',
    `pay_ip` VARCHAR(20) comment '支付IP',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `order_id` ),
     KEY `idx_order_master_id` (`order_id`),
     UNIQUE KEY `uqe_consumerid` (`consumer_id`)
) comment '订单主表';

CREATE TABLE `order_detail` (
    `order_detail_id` VARCHAR(64) NOT NULL COMMENT '订单明细ID',
    `order_id`  VARCHAR(64) NOT NULL COMMENT '订单ID',
    `course_id` INT NOT NULL COMMENT '课程ID',
    `course_name` VARCHAR(24) not NULL comment '课程名称,冗余换效率',
    `course_price` decimal(8,2) NOT NULL comment '课程价格',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `order_discounts` decimal(8,2) comment '优惠价格',
    `discount_id` VARCHAR(64) comment '优惠券ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `order_detail_id` ),
     KEY `idx_order_master_id` (`order_id`)
) comment '订单明细表';

CREATE TABLE `order_discount`(
    `discount_id` VARCHAR(32) NOT NULL comment '优惠卷ID',
    `discount_apply` INT NOT NULL DEFAULT '0 ' comment '试用范围 0全部课程 1专项优惠',
    `course_id` VARCHAR(64) NOT NULL DEFAULT '-1' comment '课程ID -1为全部课程',
    `discount_time` TIMESTAMP NOT NULL  comment '最后可使用日期',
    `discount_price` DECIMAL(8,2) NOT NULL comment '可以优惠金额',
    `discount_status` INT NOT NULL DEFAULT '0' comment '0 未使用 1 已使用 2已过期 3占用(订单未付款)',
    `order_id` VARCHAR(128) NOT NULL comment '订单ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `discount_id` ),
     KEY `idx_order_master_id` (`order_id`)
) COMMENT '订单优惠卷信息';

CREATE TABLE `course_evaluate`(
    `evaluate_id` VARCHAR(32) not null comment '评价ID',
    `course_id` VARCHAR(64) NOT NULL comment '课程ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `usage_score` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '内容充实',
    `understandability` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '通俗易懂',
    `clear_logic` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '逻辑清晰',
    `evaluate_desc` VARCHAR(1000) not null comment '评价详情',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `evaluate_id` ),
     KEY `idx_course_id` (`course_id`)
) comment '课程评价表';

create TABLE `course_recommend`(
    `recommend_id` VARCHAR(32) not null comment '评价ID',
    `course_id` VARCHAR(64) NOT NULL comment '课程ID',
    `recommend_sequence` INT NOT NULL  comment '推荐序号',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `recommend_status` INT NOT NULL DEFAULT '0' comment '推荐状态 0未推荐 1正在推荐 2推荐结束',
    `option_user` INT NOT NULL comment '操作管理员',
    `recommend_time` TIMESTAMP NOT NULL comment '开始推荐时间',
    `recommend_day` INT NOT NULL DEFAULT '0' comment '推荐了多少小时',
    `click_number` INT NOT NULL DEFAULT '0' comment '推荐的过程中点击用户',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `recommend_id` ),
     KEY `idx_course_id` (`course_id`)
) comment '课程推荐表';CREATE DATABASE `yulece_aike` CHARACTER SET 'utf8' COLLATE 'utf8_bin';
create TABLE `admin_user`(
    `user_id` int not null auto_increment,
    `user_name` VARCHAR(32) not null comment '登录账户',
    `pass_word` VARCHAR(64) not NULL comment '密码',
    `nike_name` VARCHAR(32) NOT NULL comment '用户名称',
    `telephone` VARCHAR(16)	NOT NULL COMMENT '用户手机号',
    `mail` VARCHAR(128) NOT NULL comment '用户邮箱',
    `header_url` VARCHAR(256) not NULL comment '用户头像',
    `status` INT NOT NULL DEFAULT '0' comment '用户状态 0为在职,1为离职 ',
    `user_remark` VARCHAR(64) NOT NULL comment '备注',
    `operator` VARCHAR(25) NOT NULL comment '操作者',
    `operate_ip` VARCHAR(25) NOT NULL comment '操作IP',
	`user_dept` int NOT NULL comment '用户所属部门',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `user_id` ),
     KEY `idx_login` (`user_name`),
     UNIQUE KEY `uqe_username` (`user_name`)
) comment '后台管理员表' ;
CREATE TABLE `admin_dept`(
    `dept_id` INT NOT NULL auto_increment comment '部门ID',
    `dept_name` VARCHAR(20) NOT NULL comment '部门名称',
    `dept_level` VARCHAR(20) NOT NULL comment '部门等级',
    `dept_seq` INT NOT NULL comment '部门在当前层级的排序',
    `dept_remark`　VARCHAR(64) NOT NULL comment '备注',
    `dept_parent_id` INT not NULL comment '父级目录',
    `operator` VARCHAR(25) NOT NULL comment '操作者',
    `operate_ip` VARCHAR(25) NOT NULL comment '操作IP' 
    `operate_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ( `dept_id` )
) comment '部门表';
CREATE TABLE `admin_acl_module` (
`module_id` INT NOT NULL auto_increment COMMENT '权限模块ID',
`module_name` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块名称',
`module_parent_id` INT NOT NULL COMMENT '父级目录',
`module_level` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块等级',
`status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`module_seq` INT NOT NULL COMMENT '该模块在当前层级的排序',
`module_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `module_id` ) 
) COMMENT '权限模块表'

CREATE TABLE `admin_acl` (
`acl_id` INT NOT NULL auto_increment COMMENT '权限模块ID',
`acl_name` VARCHAR ( 20 ) NOT NULL COMMENT '权限模块名称',
`acl_module_id` INT NOT NULL COMMENT '权限模块id',
`acl_url` VARCHAR ( 64 ) NOT NULL COMMENT 'url',
`type` INT NOT NULL DEFAULT '-1' COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
`status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`acl_seq` INT NOT NULL COMMENT '权限在当前层级的排序',
`acl_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `acl_id` ) 
) COMMENT '权限表'
CREATE TABLE `admin_role` (
`role_id` INT NOT NULL auto_increment COMMENT '角色ID',
`role_name` VARCHAR ( 20 ) NOT NULL COMMENT '角色名称',
`role_type` INT NOT NULL DEFAULT '-1' COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
`role_status` INT NOT NULL DEFAULT '0' COMMENT '权限模块状态 1冻结 0 正常',
`role_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_id` ),
UNIQUE KEY `uqe_rolename` (`role_name`)
) COMMENT '角色表'

CREATE TABLE `admin_role_user` (
`role_user_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`user_id` int not null comment '用户ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` )
) COMMENT '角色用户关联关系表'


CREATE TABLE `admin_role_acl` (
`role_acl_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`acl_id` int not null comment '权限ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` )
) COMMENT '角色权限关联关系表'
CREATE TABLE `admin_log` (
`log_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`type` INT NOT NULL COMMENT '操作类型',
`target_id` int not null comment '操作ID',
`old_value` VARCHAR(1000) not null comment '操作之前的记录',
`new_value` varchar(1000) comment '新的操作记录',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `log_id` ) 
) COMMENT '权限记录日志表'

CREATE TABLE `consumer_user`(
    `consumer_id` int not null auto_increment,
    `consumer_name` VARCHAR(32) not null comment '消费者登录账户',
    `consumer_word` VARCHAR(64) not NULL comment '消费者密码',
    `consumer_nike_name` VARCHAR(32) NOT NULL comment '消费者用户名称',
    `consumer_gender` INT not NULL comment '用户性别',
    `consumer_desc` VARCHAR(500) NOT NULL DEFAULT '这位同学很懒，木有签名的说～' comment '用户签名',
    `consumer_integral` INT NOT NULL default '0' comment '用户积分',
    `consumer_fans` INT NOT NULL DEFAULT '0' comment '用户粉丝',
    `consumer_email` VARCHAR(64) comment '用户邮箱',
    `consumer_phone` VARCHAR(11) comment '用户手机号',
    `consumer_type` INT NOT NULL default '0'comment '消费者类型 0 是普通消费者 1 是讲师',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `consumer_id` ),
     KEY `idx_consumer_phone` (`consumer_phone`),
     UNIQUE KEY `uqe_consumername` (`consumer_name`)
) COMMENT '消费者-用户表';

CREATE TABLE `consumer_option` (
`option_id` VARCHAR ( 64 ) NOT NULL COMMENT '操作ID',
`consumer_id` INT NOT NULL COMMENT '用戶ID',
`option_type` INT NOT NULL DEFAULT '0' COMMENT '操作类型 0 用户登录 1 用户修改密码 2 用户购买商品',
`option_ip` VARCHAR ( 20 ) NOT NULL COMMENT '用户操作IP',
`option_city` VARCHAR ( 20 ) NOT NULL DEFAULT 'Cloud' COMMENT '登陸城市',
`option_equipment` INT NOT NULL DEFAULT '0' COMMENT '操作设备 0.web 1.移动端',
`option_status` INT NOT NULL DEFAULT '0' COMMENT '是否异常 0正常 1异常 2通知用户',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `option_id` ) 
) COMMENT '消费者操作表';


CREATE TABLE `course_table`(
    `course_id` int not null auto_increment,
    `course_name` VARCHAR(24) not NULL comment '课程名称',
    `course_title` VARCHAR(32) not null comment '课程副标题',
    `course_difficulty` INT NOT null DEFAULT '0' comment '课程难度',
    `course_time` BIGINT NOT NULL comment '学习所用时间',
    `learn_number` INT not NULL DEFAULT '0' comment '学习人数', 
    `collect_number` INT not NULL DEFAULT '0' comment '收藏次数',
    `course_desc` TEXT NOT NULL comment '课程简介',
    `course_status` INT NOT NULL DEFAULT '0' comment '课程状态 0上架 1下架',
    `update_status` INT NOT NULL DEFAULT '0' comment '更新状态 0 更新中 1更新完毕'
    `course_price` decimal(8,2) NOT NULL comment '课程价格',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `environment_parameter` VARCHAR (1000) NOT NULL comment '需要的电脑环境配置/JSON格式',
    `course_require` VARCHAR(300) NOT NULL comment '学习要求',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `category_id` INT not NULL comment '类目ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `course_id` ),
     KEY `idx_category` (`category_id`),
     UNIQUE KEY `uqe_coursename` (`course_name`)
) comment '课程表';

CREATE TABLE `course_category` (
    `category_id` INT NOT NULL auto_increment,
    `category_name` VARCHAR ( 64 ) NOT NULL COMMENT '类目名称',
    `category_type` INT NOT NULL,
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY ( `category_id` ),
UNIQUE KEY `uqe_category_type` ( `category_type` ) 
) COMMENT '类目表';

create TABLE `order_master` (
    `order_id` VARCHAR(128) NOT NULL comment '订单ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `order_price` decimal(8,2) NOT NULL comment '订单总价',
    `order_discounts` decimal(8,2) comment '优惠价格',
    `discount_id` VARCHAR(64) comment '优惠券ID',
    `order_status` INT NOT NULL DEFAULT '0' comment '0 新建 1支付完成 2订单过期',
    `order_pay` INT not NULL DEFAULT '0' comment '0未支付 1已支付',
    `order_pay_type` INT NOT NULL COMMENT '支付类型 0支付宝 1微信 3银联',
    `pay_time` TIMESTAMP comment '支付时间',
    `pay_ip` VARCHAR(20) comment '支付IP',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `order_id` ),
     KEY `idx_order_master_id` (`order_id`),
     UNIQUE KEY `uqe_consumerid` (`consumer_id`)
) comment '订单主表';

CREATE TABLE `order_detail` (
    `order_detail_id` VARCHAR(64) NOT NULL COMMENT '订单明细ID',
    `order_id`  VARCHAR(64) NOT NULL COMMENT '订单ID',
    `course_id` INT NOT NULL COMMENT '课程ID',
    `course_name` VARCHAR(24) not NULL comment '课程名称,冗余换效率',
    `course_price` decimal(8,2) NOT NULL comment '课程价格',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `order_discounts` decimal(8,2) comment '优惠价格',
    `discount_id` VARCHAR(64) comment '优惠券ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `order_detail_id` ),
     KEY `idx_order_master_id` (`order_id`)
) comment '订单明细表';

CREATE TABLE `order_discount`(
    `discount_id` VARCHAR(32) NOT NULL comment '优惠卷ID',
    `discount_apply` INT NOT NULL DEFAULT '0 ' comment '试用范围 0全部课程 1专项优惠',
    `course_id` VARCHAR(64) NOT NULL DEFAULT '-1' comment '课程ID -1为全部课程',
    `discount_time` TIMESTAMP NOT NULL  comment '最后可使用日期',
    `discount_price` DECIMAL(8,2) NOT NULL comment '可以优惠金额',
    `discount_status` INT NOT NULL DEFAULT '0' comment '0 未使用 1 已使用 2已过期 3占用(订单未付款)',
    `order_id` VARCHAR(128) NOT NULL comment '订单ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `discount_id` ),
     KEY `idx_order_master_id` (`order_id`)
) COMMENT '订单优惠卷信息';

CREATE TABLE `course_evaluate`(
    `evaluate_id` VARCHAR(32) not null comment '评价ID',
    `course_id` VARCHAR(64) NOT NULL comment '课程ID',
    `consumer_id` INT NOT NULL comment '消费者ID',
    `usage_score` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '内容充实',
    `understandability` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '通俗易懂',
    `clear_logic` DECIMAL(8,2) NOT NULL DEFAULT '10.0' comment '逻辑清晰',
    `evaluate_desc` VARCHAR(1000) not null comment '评价详情',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `evaluate_id` ),
     KEY `idx_course_id` (`course_id`)
) comment '课程评价表';

create TABLE `course_recommend`(
    `recommend_id` VARCHAR(32) not null comment '推荐ID',
    `course_id` VARCHAR(64) NOT NULL comment '课程ID',
    `recommend_sequence` INT NOT NULL  comment '推荐序号',
    `course_banner_url` VARCHAR (256) comment '课程banner URL',
    `recommend_status` INT NOT NULL DEFAULT '0' comment '推荐状态 0未推荐 1正在推荐 2推荐结束',
    `option_user` INT NOT NULL comment '操作管理员',
    `recommend_time` TIMESTAMP NOT NULL comment '开始推荐时间',
    `recommend_day` INT NOT NULL DEFAULT '0' comment '推荐了多少小时',
    `click_number` INT NOT NULL DEFAULT '0' comment '推荐的过程中点击用户',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     PRIMARY KEY ( `recommend_id` ),
     KEY `idx_course_id` (`course_id`)
) comment '课程推荐表';
CREATE TABLE `course_section` (
`section_id` INT NOT NULL COMMENT '课程章节ID',
`course_id` VARCHAR ( 64 ) NOT NULL COMMENT '课程ID',
`section_level` INT NOT NULL COMMENT '目录所在当前课程的位置',
`section_desc` INT NOT NULL COMMENT '本章节简介',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `section_id` ),
KEY `idx_course_id` ( `course_id` ) 
) COMMENT '课程章节表';
