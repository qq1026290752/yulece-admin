
//--手写SQL
CREATE DATABASE `yulece_aike` CHARACTER 
SET 'utf8' COLLATE 'utf8_bin';
CREATE TABLE `admin_user` (
`user_id` INT NOT NULL auto_increment,
`user_name` VARCHAR ( 32 ) NOT NULL COMMENT '登录账户',
`pass_word` VARCHAR ( 64 ) NOT NULL COMMENT '密码',
`nike_name` VARCHAR ( 32 ) NOT NULL COMMENT '用户名称',
`telephone` VARCHAR ( 16 ) NOT NULL COMMENT '用户手机号',
`mail` VARCHAR ( 128 ) NOT NULL COMMENT '用户邮箱',
`header_url` VARCHAR ( 256 ) NOT NULL COMMENT '用户头像',
`status` INT NOT NULL DEFAULT '0' COMMENT '用户状态 0为在职,1为离职 ',
`user_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`user_dept` INT NOT NULL COMMENT '用户所属部门',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `user_id` ),
KEY `idx_login` ( `user_name` ),
UNIQUE KEY `uqe_username` ( `user_name` ) 
) COMMENT '后台管理员表';


CREATE TABLE `admin_dept` (
`dept_id` INT NOT NULL auto_increment COMMENT '部门ID',
`dept_name` VARCHAR ( 20 ) NOT NULL COMMENT '部门名称',
`dept_level` VARCHAR ( 20 ) NOT NULL COMMENT '部门等级',
`dept_seq` INT NOT NULL COMMENT '部门在当前层级的排序',
`dept_remark`　 VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`dept_parent_id` INT NOT NULL COMMENT '父级目录',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP' `operate_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `dept_id` ) 
) COMMENT '部门表';


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
) COMMENT '权限模块表' ;

CREATE TABLE `admin_acl` (
`acl_id` INT NOT NULL auto_increment COMMENT '权限ID',
`acl_name` VARCHAR ( 20 ) NOT NULL COMMENT '权限名称',
`acl_module_id` INT NOT NULL COMMENT '权限模块id',
`acl_url` VARCHAR ( 64 ) NOT NULL COMMENT 'url',
`type` INT NOT NULL DEFAULT '-1' COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
`status` INT NOT NULL DEFAULT '0' COMMENT '权限状态 1冻结 0 正常',
`acl_seq` INT NOT NULL COMMENT '权限在当前层级的排序',
`acl_remark` VARCHAR ( 64 ) NOT NULL COMMENT '备注',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `acl_id` ) 
) COMMENT '权限表' ;

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
UNIQUE KEY `uqe_rolename` ( `role_name` ) 
) COMMENT '角色表';

 CREATE TABLE `admin_role_user` (
`role_user_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`user_id` INT NOT NULL COMMENT '用户ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` ) 
) COMMENT '角色用户关联关系表';

CREATE TABLE `admin_role_acl` (
`role_acl_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`role_id` INT NOT NULL COMMENT '角色ID',
`acl_id` INT NOT NULL COMMENT '权限ID',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `role_user_id` ) 
) COMMENT '角色权限关联关系表';


CREATE TABLE `admin_log` (
`log_id` INT NOT NULL auto_increment COMMENT '唯一主键ID',
`type` INT NOT NULL COMMENT '操作类型',
`target_id` INT NOT NULL COMMENT '操作ID',
`old_value` VARCHAR ( 1000 ) NOT NULL COMMENT '操作之前的记录',
`new_value` VARCHAR ( 1000 ) COMMENT '新的操作记录',
`operator` VARCHAR ( 25 ) NOT NULL COMMENT '操作者',
`operate_ip` VARCHAR ( 25 ) NOT NULL COMMENT '操作IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `log_id` ) 
) COMMENT '权限记录日志表';

CREATE TABLE `consumer_user` (
`consumer_id` INT NOT NULL auto_increment,
`consumer_name` VARCHAR ( 32 ) NOT NULL COMMENT '消费者登录账户',
`consumer_word` VARCHAR ( 64 ) NOT NULL COMMENT '消费者密码',
`consumer_nike_name` VARCHAR ( 32 ) NOT NULL COMMENT '消费者用户名称',
`consumer_gender` INT NOT NULL COMMENT '用户性别',
`consumer_desc` VARCHAR ( 500 ) NOT NULL DEFAULT '这位同学很懒，木有签名的说～' COMMENT '用户签名',
`consumer_integral` INT NOT NULL DEFAULT '0' COMMENT '用户积分',
`consumer_fans` INT NOT NULL DEFAULT '0' COMMENT '用户粉丝',
`consumer_email` VARCHAR ( 64 ) COMMENT '用户邮箱',
`consumer_phone` VARCHAR ( 11 ) COMMENT '用户手机号',
`consumer_status` INT NOT NULL DEFAULT '0' COMMENT '消费者状态 0 未激活 1 已激活' `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `consumer_id` ),
KEY `idx_consumer_phone` ( `consumer_phone` ),
UNIQUE KEY `uqe_consumername` ( `consumer_name` ) 
) COMMENT '消费者-用户表';


CREATE TABLE `course_table` (
`course_id` INT NOT NULL auto_increment,
`course_name` VARCHAR ( 24 ) NOT NULL COMMENT '课程名称',
`course_title` VARCHAR ( 32 ) NOT NULL COMMENT '课程副标题',
`course_difficulty` INT NOT NULL DEFAULT '0' COMMENT '课程难度',
`course_time` BIGINT NOT NULL COMMENT '学习所用时间',
`learn_number` INT NOT NULL DEFAULT '0' COMMENT '学习人数',
`collect_number` INT NOT NULL DEFAULT '0' COMMENT '收藏次数',
`course_desc` TEXT NOT NULL COMMENT '课程简介',
`course_price` DECIMAL ( 8, 2 ) NOT NULL COMMENT '课程价格',
`course_banner_url` VARCHAR ( 256 ) COMMENT '课程banner URL',
`environment_parameter` VARCHAR ( 1000 ) NOT NULL COMMENT '需要的电脑环境配置/JSON格式',
`course_require` VARCHAR ( 300 ) NOT NULL COMMENT '学习要求',
`consumer_id` INT NOT NULL COMMENT '消费者ID',
`category_id` INT NOT NULL COMMENT '类目ID',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `course_id` ),
KEY `idx_category` ( `category_id` ),
UNIQUE KEY `uqe_coursename` ( `course_name` ) 
) COMMENT '课程表';


CREATE TABLE `course_category` (
`category_id` INT NOT NULL auto_increment,
`category_name` VARCHAR ( 64 ) NOT NULL COMMENT '类目名称',
`category_type` INT NOT NULL,
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `category_id` ),
UNIQUE KEY `uqe_category_type` ( `category_type` ) 
) COMMENT '类目表';

CREATE TABLE `order_master` (
`order_id` VARCHAR ( 128 ) NOT NULL COMMENT '订单ID',
`consumer_id` INT NOT NULL COMMENT '消费者ID',
`order_price` DECIMAL ( 8, 2 ) NOT NULL COMMENT '订单总价',
`order_discounts` DECIMAL ( 8, 2 ) COMMENT '优惠价格',
`discount_id` VARCHAR ( 64 ) COMMENT '优惠券ID',
`order_status` INT NOT NULL DEFAULT '0' COMMENT '0 新建 1支付完成 2订单过期',
`order_pay` INT NOT NULL DEFAULT '0' COMMENT '0未支付 1已支付',
`order_pay_type` INT NOT NULL COMMENT '支付类型 0支付宝 1微信 3银联',
`pay_time` TIMESTAMP COMMENT '支付时间',
`pay_ip` VARCHAR ( 20 ) COMMENT '支付IP',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `order_id` ),
KEY `idx_order_master_id` ( `order_id` ),
UNIQUE KEY `uqe_consumerid` ( `consumer_id` ) 
) COMMENT '订单主表';

CREATE TABLE `order_detail` (
`order_detail_id` VARCHAR ( 64 ) NOT NULL COMMENT '订单明细ID',
`order_id` VARCHAR ( 64 ) NOT NULL COMMENT '订单ID',
`course_id` INT NOT NULL COMMENT '课程ID',
`course_name` VARCHAR ( 24 ) NOT NULL COMMENT '课程名称,冗余换效率',
`course_price` DECIMAL ( 8, 2 ) NOT NULL COMMENT '课程价格',
`course_banner_url` VARCHAR ( 256 ) COMMENT '课程banner URL',
`order_discounts` DECIMAL ( 8, 2 ) COMMENT '优惠价格',
`discount_id` VARCHAR ( 64 ) COMMENT '优惠券ID',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `order_detail_id` ),
KEY `idx_order_master_id` ( `order_id` ) 
) COMMENT '订单明细表';

CREATE TABLE `order_discount` (
`discount_id` VARCHAR ( 32 ) NOT NULL COMMENT '优惠卷ID',
`discount_apply` INT NOT NULL DEFAULT '0 ' COMMENT '试用范围 0全部课程 1专项优惠',
`course_id` VARCHAR ( 64 ) NOT NULL DEFAULT '-1' COMMENT '课程ID -1为全部课程',
`discount_time` TIMESTAMP NOT NULL COMMENT '最后可使用日期',
`discount_price` DECIMAL ( 8, 2 ) NOT NULL COMMENT '可以优惠金额',
`discount_status` INT NOT NULL DEFAULT '0' COMMENT '0 未使用 1 已使用 2已过期 3占用(订单未付款)',
`order_id` VARCHAR ( 128 ) NOT NULL COMMENT '订单ID',
`consumer_id` INT NOT NULL COMMENT '消费者ID',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `discount_id` ),
KEY `idx_order_master_id` ( `order_id` ) 
) COMMENT '订单优惠卷信息';

CREATE TABLE `course_evaluate` (
`evaluate_id` VARCHAR ( 32 ) NOT NULL COMMENT '评价ID',
`course_id` VARCHAR ( 64 ) NOT NULL COMMENT '课程ID',
`consumer_id` INT NOT NULL COMMENT '消费者ID',
`usage_score` DECIMAL ( 8, 2 ) NOT NULL DEFAULT '10.0' COMMENT '内容充实',
`understandability` DECIMAL ( 8, 2 ) NOT NULL DEFAULT '10.0' COMMENT '通俗易懂',
`clear_logic` DECIMAL ( 8, 2 ) NOT NULL DEFAULT '10.0' COMMENT '逻辑清晰',
`evaluate_desc` VARCHAR ( 1000 ) NOT NULL COMMENT '评价详情',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `evaluate_id` ),
KEY `idx_course_id` ( `course_id` ) 
) COMMENT '课程评价表';


CREATE TABLE `course_recommend` (
`recommend_id` VARCHAR ( 32 ) NOT NULL COMMENT '评价ID',
`course_id` VARCHAR ( 64 ) NOT NULL COMMENT '课程ID',
`recommend_sequence` INT NOT NULL COMMENT '推荐序号',
`course_banner_url` VARCHAR ( 256 ) COMMENT '课程banner URL',
`recommend_status` INT NOT NULL DEFAULT '0' COMMENT '推荐状态 0未推荐 1正在推荐 2推荐结束',
`option_user` INT NOT NULL COMMENT '操作管理员',
`recommend_time` TIMESTAMP NOT NULL COMMENT '开始推荐时间',
`recommend_day` INT NOT NULL DEFAULT '0' COMMENT '推荐了多少小时',
`click_number` INT NOT NULL DEFAULT '0' COMMENT '推荐的过程中点击用户',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `recommend_id` ),
KEY `idx_course_id` ( `course_id` ) 
) COMMENT '课程推荐表';

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


CREATE TABLE `course_issue` (
`issue_id` VARCHAR ( 32 ) NOT NULL COMMENT '问题ID',
`course_id` VARCHAR ( 64 ) NOT NULL COMMENT '课程ID',
`issue_status` INT NOT NULL DEFAULT '0' COMMENT '问题状态 0 新建问题 1 问题关闭 2采纳问题',
`consumer_id` INT NOT NULL COMMENT '问题提问者ID',
`issue_title` VARCHAR ( 124 ) NOT NULL COMMENT '问题标题',
`issue_context` VARCHAR ( 512 ) NOT NULL COMMENT '问题内容',
`issue_show` INT NOT NULL DEFAULT '0' COMMENT '是否顶置 0不要顶置 1顶置问题',
`issue_keep` INT NOT NULL DEFAULT '0' COMMENT '关注人数',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY ( `issue_id` ) 
) COMMENT '课程提问表'
