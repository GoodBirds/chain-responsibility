/*
 Navicat MySQL Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : chain_responsibility

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 18/03/2020 16:34:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gateway_handler_config
-- ----------------------------
DROP TABLE IF EXISTS `gateway_handler_config`;
CREATE TABLE `gateway_handler_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `handler_name` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'handler名称',
  `handler_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'handler主键id',
  `prev_handler_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `next_handler_id` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下一个handler',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限表';

-- ----------------------------
-- Records of gateway_handler_config
-- ----------------------------
BEGIN;
INSERT INTO `gateway_handler_config` VALUES (1, 'Api接口限流', 'currentLimitHandler', NULL, 'blacklistHandler');
INSERT INTO `gateway_handler_config` VALUES (2, '黑名单拦截', 'blacklistHandler', 'currentLimitHandler', 'conversationHandler');
INSERT INTO `gateway_handler_config` VALUES (3, '会话验证', 'conversationHandler', 'blacklistHandler', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
