/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 47.94.90.76:3306
 Source Schema         : yulece_aike

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 02/05/2018 17:29:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_acl
-- ----------------------------
DROP TABLE IF EXISTS `admin_acl`;
CREATE TABLE `admin_acl`  (
  `acl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限模块ID',
  `acl_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '权限模块名称',
  `acl_module_id` int(11) NOT NULL COMMENT '权限模块id',
  `acl_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'url',
  `type` int(11) NOT NULL DEFAULT -1 COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '权限模块状态 1冻结 0 正常',
  `acl_seq` int(11) NOT NULL COMMENT '权限在当前层级的排序',
  `acl_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`acl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_acl_module
-- ----------------------------
DROP TABLE IF EXISTS `admin_acl_module`;
CREATE TABLE `admin_acl_module`  (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限模块ID',
  `module_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '权限模块名称',
  `module_parent_id` int(11) NOT NULL COMMENT '父级目录',
  `module_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '权限模块等级',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '权限模块状态',
  `module_seq` int(11) NOT NULL COMMENT '该模块在当前层级的排序',
  `module_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '权限模块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_dept
-- ----------------------------
DROP TABLE IF EXISTS `admin_dept`;
CREATE TABLE `admin_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '部门名称',
  `dept_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '部门等级',
  `dept_seq` int(11) NOT NULL COMMENT '部门在当前层级的排序',
  `dept_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  `dept_parent_id` int(11) NOT NULL COMMENT '父级目录',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log`  (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键ID',
  `type` int(11) NOT NULL COMMENT '操作类型',
  `target_id` int(11) NOT NULL COMMENT '操作ID',
  `old_value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作之前的记录',
  `new_value` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '新的操作记录',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '权限记录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `role_type` int(11) NOT NULL DEFAULT -1 COMMENT '当前权限类型 1 菜单 2按钮 3 其他',
  `role_status` int(11) NOT NULL DEFAULT 0 COMMENT '权限模块状态 1冻结 0 正常',
  `role_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `uqe_rolename`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role_acl
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_acl`;
CREATE TABLE `admin_role_acl`  (
  `role_acl_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `acl_id` int(11) NOT NULL COMMENT '权限ID',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_acl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色权限关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_user`;
CREATE TABLE `admin_role_user`  (
  `role_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`role_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色用户关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录账户',
  `pass_word` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `nike_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `telephone` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户手机号',
  `mail` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `header_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户头像',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '用户状态 0为在职,1为离职 ',
  `user_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备注',
  `operator` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作者',
  `operate_ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作IP',
  `user_dept` int(11) NOT NULL COMMENT '用户所属部门',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uqe_username`(`user_name`) USING BTREE,
  INDEX `idx_login`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '后台管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consumer_option
-- ----------------------------
DROP TABLE IF EXISTS `consumer_option`;
CREATE TABLE `consumer_option`  (
  `option_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作ID',
  `consumer_id` int(11) NOT NULL COMMENT '用戶ID',
  `option_type` int(11) NOT NULL DEFAULT 0 COMMENT '操作类型 0 用户登录 1 用户修改密码 2 用户购买商品',
  `option_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户操作IP',
  `option_city` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'Cloud' COMMENT '登陸城市',
  `option_equipment` int(11) NOT NULL DEFAULT 0 COMMENT '操作设备 0.web 1.移动端',
  `option_status` int(11) NOT NULL DEFAULT 0 COMMENT '是否异常 0正常 1异常 2通知用户',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`option_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '消费者操作表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consumer_user
-- ----------------------------
DROP TABLE IF EXISTS `consumer_user`;
CREATE TABLE `consumer_user`  (
  `consumer_id` int(11) NOT NULL AUTO_INCREMENT,
  `consumer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '消费者登录账户',
  `consumer_word` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '消费者密码',
  `consumer_nike_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '消费者用户名称',
  `consumer_gender` int(11) NOT NULL COMMENT '用户性别',
  `consumer_type` int(11) NOT NULL DEFAULT 0 COMMENT '消费者类型 0是普通消费者 1是讲师',
  `consumer_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '这位同学很懒，木有签名的说～' COMMENT '用户签名',
  `consumer_integral` int(11) NOT NULL DEFAULT 0 COMMENT '用户积分',
  `consumer_fans` int(11) NOT NULL DEFAULT 0 COMMENT '用户粉丝',
  `consumer_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户邮箱',
  `consumer_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户手机号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`consumer_id`) USING BTREE,
  UNIQUE INDEX `uqe_consumername`(`consumer_name`) USING BTREE,
  INDEX `idx_consumer_phone`(`consumer_phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '消费者-用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_category
-- ----------------------------
DROP TABLE IF EXISTS `course_category`;
CREATE TABLE `course_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类目名称',
  `category_type` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `course_evaluate`;
CREATE TABLE `course_evaluate`  (
  `evaluate_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '评价ID',
  `course_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程ID',
  `consumer_id` int(11) NOT NULL COMMENT '消费者ID',
  `usage_score` decimal(8, 2) NOT NULL DEFAULT 10.00 COMMENT '内容充实',
  `understandability` decimal(8, 2) NOT NULL DEFAULT 10.00 COMMENT '通俗易懂',
  `clear_logic` decimal(8, 2) NOT NULL DEFAULT 10.00 COMMENT '逻辑清晰',
  `evaluate_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '评价详情',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`evaluate_id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_issue
-- ----------------------------
DROP TABLE IF EXISTS `course_issue`;
CREATE TABLE `course_issue`  (
  `issue_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '问题ID',
  `course_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程ID',
  `issue_status` int(11) NOT NULL DEFAULT 0 COMMENT '问题状态 0 新建问题 1 问题关闭 2采纳问题',
  `consumer_id` int(11) NOT NULL COMMENT '问题提问者ID',
  `issue_title` varchar(124) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '问题标题',
  `issue_context` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '问题内容',
  `issue_show` int(11) NOT NULL DEFAULT 0 COMMENT '是否顶置 0不要顶置 1顶置问题',
  `issue_keep` int(11) NOT NULL DEFAULT 0 COMMENT '关注人数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`issue_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程提问表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_recommend
-- ----------------------------
DROP TABLE IF EXISTS `course_recommend`;
CREATE TABLE `course_recommend`  (
  `recommend_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '评价ID',
  `course_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程ID',
  `recommend_sequence` int(11) NOT NULL COMMENT '推荐序号',
  `course_banner_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程banner URL',
  `recommend_status` int(11) NOT NULL DEFAULT 0 COMMENT '推荐状态 0未推荐 1正在推荐 2推荐结束',
  `option_user` int(11) NOT NULL COMMENT '操作管理员',
  `recommend_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开始推荐时间',
  `recommend_day` int(11) NOT NULL DEFAULT 0 COMMENT '推荐了多少小时',
  `click_number` int(11) NOT NULL DEFAULT 0 COMMENT '推荐的过程中点击用户',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`recommend_id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程推荐表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_section
-- ----------------------------
DROP TABLE IF EXISTS `course_section`;
CREATE TABLE `course_section`  (
  `section_id` int(11) NOT NULL COMMENT '课程章节ID',
  `course_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程ID',
  `section_level` int(11) NOT NULL COMMENT '目录所在当前课程的位置',
  `section_desc` int(11) NOT NULL COMMENT '本章节简介',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`section_id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程章节表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_table
-- ----------------------------
DROP TABLE IF EXISTS `course_table`;
CREATE TABLE `course_table`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名称',
  `course_title` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程副标题',
  `course_difficulty` int(11) NOT NULL DEFAULT 0 COMMENT '课程难度',
  `course_time` bigint(20) NOT NULL COMMENT '学习所用时间',
  `learn_number` int(11) NOT NULL DEFAULT 0 COMMENT '学习人数',
  `collect_number` int(11) NOT NULL DEFAULT 0 COMMENT '收藏次数',
  `course_desc` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程简介',
  `course_price` decimal(8, 2) NOT NULL COMMENT '课程价格',
  `course_status` int(11) NOT NULL DEFAULT 0 COMMENT '课程状态 0 上架 1下架',
  `update_status` int(11) NOT NULL COMMENT '更新状态',
  `course_banner_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程banner URL',
  `environment_parameter` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '需要的电脑环境配置/JSON格式',
  `course_require` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '学习要求',
  `consumer_id` int(11) NOT NULL COMMENT '消费者ID',
  `category_id` int(11) NOT NULL COMMENT '类目ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`course_id`) USING BTREE,
  UNIQUE INDEX `uqe_coursename`(`course_name`) USING BTREE,
  INDEX `idx_category`(`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `order_detail_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单明细ID',
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单ID',
  `course_id` int(11) NOT NULL COMMENT '课程ID',
  `course_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名称,冗余换效率',
  `course_price` decimal(8, 2) NOT NULL COMMENT '课程价格',
  `course_banner_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程banner URL',
  `order_discounts` decimal(8, 2) NULL DEFAULT NULL COMMENT '优惠价格',
  `discount_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '优惠券ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_detail_id`) USING BTREE,
  INDEX `idx_order_master_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_discount
-- ----------------------------
DROP TABLE IF EXISTS `order_discount`;
CREATE TABLE `order_discount`  (
  `discount_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '优惠卷ID',
  `discount_apply` int(11) NOT NULL DEFAULT 0 COMMENT '试用范围 0全部课程 1专项优惠',
  `course_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '-1' COMMENT '课程ID -1为全部课程',
  `discount_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后可使用日期',
  `discount_price` decimal(8, 2) NOT NULL COMMENT '可以优惠金额',
  `discount_status` int(11) NOT NULL DEFAULT 0 COMMENT '0 未使用 1 已使用 2已过期 3占用(订单未付款)',
  `order_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单ID',
  `consumer_id` int(11) NOT NULL COMMENT '所属消费者',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`discount_id`) USING BTREE,
  INDEX `idx_order_master_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单优惠卷信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单ID',
  `consumer_id` int(11) NOT NULL COMMENT '消费者ID',
  `order_price` decimal(8, 2) NOT NULL COMMENT '订单总价',
  `order_discounts` decimal(8, 2) NULL DEFAULT NULL COMMENT '优惠价格',
  `discount_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '优惠券ID',
  `order_status` int(11) NOT NULL DEFAULT 0 COMMENT '0 新建 1支付完成 2订单过期',
  `order_pay` int(11) NOT NULL DEFAULT 0 COMMENT '0未支付 1已支付',
  `order_pay_type` int(11) NOT NULL COMMENT '支付类型 0支付宝 1微信 3银联',
  `pay_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '支付时间',
  `pay_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '支付IP',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`order_id`) USING BTREE,
  UNIQUE INDEX `uqe_consumerid`(`consumer_id`) USING BTREE,
  INDEX `idx_order_master_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单主表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
