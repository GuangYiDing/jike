/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 42.192.152.215:3306
 Source Schema         : jike

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 12/05/2021 21:54:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '通知主键',
  `to_user_id` int NOT NULL COMMENT '消费者',
  `from_user_id` int NOT NULL COMMENT '生产者',
  `create_time` datetime NOT NULL COMMENT '通知时间',
  `is_confirmed` varchar(1) NOT NULL COMMENT '是否消费',
  `message` varchar(32) NOT NULL COMMENT '消息内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='消息通知表 ';

SET FOREIGN_KEY_CHECKS = 1;
