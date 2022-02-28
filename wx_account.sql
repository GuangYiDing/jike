/*
 Navicat Premium Data Transfer

 Source Server         : super
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : jike

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 11/05/2021 22:42:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wx_account
-- ----------------------------
DROP TABLE IF EXISTS `wx_account`;
CREATE TABLE `wx_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `last_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
