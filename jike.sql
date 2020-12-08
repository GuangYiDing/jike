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

 Date: 08/12/2020 15:17:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论主键',
  `trend_id` int(11) NOT NULL COMMENT '动态id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `content` varchar(128) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL COMMENT '发布时间',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父节点',
  `likes_count` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `images` varchar(128) DEFAULT NULL COMMENT '评论图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='动态评论表 ';

-- ----------------------------
-- Records of comments
-- ----------------------------
BEGIN;
INSERT INTO `comments` VALUES (1, 2, 12, '测测', '2020-11-28 13:41:31', 0, 33, NULL);
INSERT INTO `comments` VALUES (2, 1, 12, '测测测测', '2020-11-28 14:03:51', 0, 1, NULL);
INSERT INTO `comments` VALUES (3, 9, 12, '', '2020-12-01 16:35:23', 0, 3, '/alu/不出所料.png');
INSERT INTO `comments` VALUES (4, 9, 12, '', '2020-12-01 16:35:34', 0, 3, '/alu/不出所料.png');
INSERT INTO `comments` VALUES (5, 9, 12, '', '2020-12-01 16:50:57', 0, 3, '/alu/亲亲.png,/alu/吐舌.png');
INSERT INTO `comments` VALUES (6, 8, 13, '', '2020-12-01 17:59:03', 0, 2, '/alu/不出所料.png');
INSERT INTO `comments` VALUES (7, 8, 13, '', '2020-12-01 18:02:34', 0, 2, '/alu/吐舌.png');
INSERT INTO `comments` VALUES (8, 8, 13, '', '2020-12-01 18:38:10', 0, 2, '/alu/击掌.png');
INSERT INTO `comments` VALUES (9, 7, 12, '', '2020-12-01 22:02:56', 0, 3, '/alu/不说话.png');
INSERT INTO `comments` VALUES (10, 6, 12, '46A我靠窗边坐下', '2020-12-01 22:03:47', 0, 1, '/alu/中刀.png');
INSERT INTO `comments` VALUES (11, 8, 12, '', '2020-12-01 22:12:51', 0, 3, '/ac/1003.png');
INSERT INTO `comments` VALUES (12, 8, 12, '给我reload', '2020-12-01 22:13:23', 0, 3, '/ac/09.png');
INSERT INTO `comments` VALUES (13, 5, 12, '提高生产力', '2020-12-01 22:14:48', 0, 2, '/ac/20.png');
INSERT INTO `comments` VALUES (14, 9, 12, '', '2020-12-02 10:46:04', 0, 3, '/ac/08.png');
INSERT INTO `comments` VALUES (15, 9, 12, '测试子评论', '2020-12-02 15:31:48', 14, 0, '/ac/22.png');
INSERT INTO `comments` VALUES (16, 9, 12, '👨‍🦳🦈🌬🌶', '2020-12-02 22:05:34', 14, 0, '/ac/28.png');
INSERT INTO `comments` VALUES (17, 9, 12, '你说的是真的嘛', '2020-12-02 22:12:32', 14, 0, '/ac/1004.png');
INSERT INTO `comments` VALUES (18, 9, 12, '寝室要以和为贵,不要搞窝里斗!', '2020-12-02 22:18:23', 0, 3, '/ac/1022.png');
INSERT INTO `comments` VALUES (19, 9, 12, '我大意了阿!没有闪!', '2020-12-02 22:22:07', 18, 0, '/ac/2041.png');
INSERT INTO `comments` VALUES (20, 5, 12, '来!骗!来!偷袭!', '2020-12-02 22:35:03', 0, 2, '/ac/09.png');
INSERT INTO `comments` VALUES (21, 5, 12, '这好吗?这不好!', '2020-12-02 22:35:22', 20, 0, NULL);
INSERT INTO `comments` VALUES (22, 10, 15, '源濑氏佐田', '2020-12-03 14:14:22', 0, 3, NULL);
INSERT INTO `comments` VALUES (23, 10, 15, '有两个年轻人,一个七十多斤一个八十多斤', '2020-12-03 14:15:00', 22, 0, NULL);
INSERT INTO `comments` VALUES (24, 10, 15, '来!骗!来!偷袭!', '2020-12-03 14:15:22', 22, 0, '/ac/09.png');
INSERT INTO `comments` VALUES (25, 10, 15, '我六十多的老同志,这好嘛?这不好!', '2020-12-03 14:16:30', 0, 3, '/ac/49.png');
INSERT INTO `comments` VALUES (26, 3, 15, '', '2020-12-05 15:36:03', 0, 2, '/ac/1001.png');
INSERT INTO `comments` VALUES (27, 3, 13, '', '2020-12-05 15:37:02', 26, 0, '/ac/06.png');
INSERT INTO `comments` VALUES (28, 3, 15, '', '2020-12-05 15:46:26', 0, 1, '/images/rwNya查莉雅web.gif');
INSERT INTO `comments` VALUES (30, 5, 13, '', '2020-12-05 15:52:35', 0, 0, '/images/Hyd7Ljike_49572588132877_pic.jpeg');
INSERT INTO `comments` VALUES (31, 12, 13, '', '2020-12-05 16:00:00', 0, 3, '/images/AACAAjike_49572588132877_pic.jpeg,/images/+YWifjike_49567283565108_pic.jpeg');
INSERT INTO `comments` VALUES (32, 12, 13, '', '2020-12-05 16:04:18', 0, 3, '/images/RemP5jike_50155887587066_pic.jpeg');
INSERT INTO `comments` VALUES (33, 12, 13, '', '2020-12-05 16:04:50', 0, 3, '/images/g/OYqjike_34476865794515_pic.gif');
INSERT INTO `comments` VALUES (34, 11, 13, '', '2020-12-05 16:15:23', 0, 1, '/images/FIQYSjike_22245758120401_pic.jpeg');
COMMIT;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注主键',
  `user_id` int(11) NOT NULL COMMENT '用户主键',
  `following_user_id` int(11) NOT NULL COMMENT '关注的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关注表 显示用户间的关注信息';

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '点赞主键',
  `trend_id` int(11) NOT NULL DEFAULT '0' COMMENT '动态id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `comment_id` int(11) NOT NULL DEFAULT '0' COMMENT '评论id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='动态点赞表 ';

-- ----------------------------
-- Records of likes
-- ----------------------------
BEGIN;
INSERT INTO `likes` VALUES (1, 1, 12, 0);
INSERT INTO `likes` VALUES (2, 1, 11, 0);
INSERT INTO `likes` VALUES (3, 2, 10, 0);
INSERT INTO `likes` VALUES (4, 1, 14, 0);
INSERT INTO `likes` VALUES (5, 2, 12, 0);
INSERT INTO `likes` VALUES (6, 11, 12, 0);
INSERT INTO `likes` VALUES (7, 10, 12, 0);
INSERT INTO `likes` VALUES (8, 9, 12, 0);
INSERT INTO `likes` VALUES (9, 0, 12, 18);
INSERT INTO `likes` VALUES (10, 0, 12, 14);
INSERT INTO `likes` VALUES (11, 0, 12, 4);
INSERT INTO `likes` VALUES (12, 0, 12, 3);
INSERT INTO `likes` VALUES (13, 0, 12, 5);
INSERT INTO `likes` VALUES (14, 3, 12, 0);
INSERT INTO `likes` VALUES (15, 4, 12, 0);
INSERT INTO `likes` VALUES (16, 5, 12, 0);
INSERT INTO `likes` VALUES (17, 6, 12, 0);
INSERT INTO `likes` VALUES (18, 7, 12, 0);
INSERT INTO `likes` VALUES (19, 8, 12, 0);
INSERT INTO `likes` VALUES (20, 11, 15, 0);
INSERT INTO `likes` VALUES (21, 10, 15, 0);
INSERT INTO `likes` VALUES (22, 9, 15, 0);
INSERT INTO `likes` VALUES (23, 8, 15, 0);
INSERT INTO `likes` VALUES (24, 6, 15, 0);
INSERT INTO `likes` VALUES (25, 5, 15, 0);
INSERT INTO `likes` VALUES (26, 4, 15, 0);
INSERT INTO `likes` VALUES (27, 3, 15, 0);
INSERT INTO `likes` VALUES (28, 2, 15, 0);
INSERT INTO `likes` VALUES (29, 1, 15, 0);
INSERT INTO `likes` VALUES (30, 7, 15, 0);
INSERT INTO `likes` VALUES (31, 11, 13, 0);
INSERT INTO `likes` VALUES (32, 10, 13, 0);
INSERT INTO `likes` VALUES (33, 9, 13, 0);
INSERT INTO `likes` VALUES (34, 8, 13, 0);
INSERT INTO `likes` VALUES (35, 7, 13, 0);
INSERT INTO `likes` VALUES (36, 6, 13, 0);
INSERT INTO `likes` VALUES (37, 5, 13, 0);
INSERT INTO `likes` VALUES (38, 4, 13, 0);
INSERT INTO `likes` VALUES (39, 3, 13, 0);
INSERT INTO `likes` VALUES (40, 2, 13, 0);
INSERT INTO `likes` VALUES (41, 1, 13, 0);
INSERT INTO `likes` VALUES (42, 11, 17, 0);
INSERT INTO `likes` VALUES (43, 10, 17, 0);
INSERT INTO `likes` VALUES (44, 9, 17, 0);
INSERT INTO `likes` VALUES (45, 8, 17, 0);
INSERT INTO `likes` VALUES (46, 7, 17, 0);
INSERT INTO `likes` VALUES (47, 1, 17, 0);
INSERT INTO `likes` VALUES (48, 2, 17, 0);
INSERT INTO `likes` VALUES (49, 3, 17, 0);
INSERT INTO `likes` VALUES (50, 4, 17, 0);
INSERT INTO `likes` VALUES (51, 5, 17, 0);
INSERT INTO `likes` VALUES (52, 6, 17, 0);
INSERT INTO `likes` VALUES (53, 11, 16, 0);
INSERT INTO `likes` VALUES (54, 10, 16, 0);
INSERT INTO `likes` VALUES (55, 9, 16, 0);
INSERT INTO `likes` VALUES (56, 1, 16, 0);
INSERT INTO `likes` VALUES (57, 5, 16, 0);
INSERT INTO `likes` VALUES (58, 4, 16, 0);
INSERT INTO `likes` VALUES (59, 3, 16, 0);
INSERT INTO `likes` VALUES (60, 2, 16, 0);
INSERT INTO `likes` VALUES (61, 6, 16, 0);
INSERT INTO `likes` VALUES (62, 8, 16, 0);
INSERT INTO `likes` VALUES (63, 7, 16, 0);
INSERT INTO `likes` VALUES (64, 11, 1, 0);
INSERT INTO `likes` VALUES (65, 0, 15, 18);
INSERT INTO `likes` VALUES (66, 0, 15, 14);
INSERT INTO `likes` VALUES (67, 0, 15, 5);
INSERT INTO `likes` VALUES (68, 0, 15, 4);
INSERT INTO `likes` VALUES (69, 0, 15, 3);
INSERT INTO `likes` VALUES (70, 0, 15, 12);
INSERT INTO `likes` VALUES (71, 0, 15, 11);
INSERT INTO `likes` VALUES (72, 0, 15, 8);
INSERT INTO `likes` VALUES (73, 0, 15, 7);
INSERT INTO `likes` VALUES (74, 0, 15, 6);
INSERT INTO `likes` VALUES (75, 0, 15, 20);
INSERT INTO `likes` VALUES (76, 0, 15, 13);
INSERT INTO `likes` VALUES (77, 0, 15, 25);
INSERT INTO `likes` VALUES (78, 0, 15, 22);
INSERT INTO `likes` VALUES (79, 0, 15, 1);
INSERT INTO `likes` VALUES (80, 11, 2, 0);
INSERT INTO `likes` VALUES (81, 10, 2, 0);
INSERT INTO `likes` VALUES (82, 8, 2, 0);
INSERT INTO `likes` VALUES (83, 0, 2, 12);
INSERT INTO `likes` VALUES (84, 0, 2, 11);
INSERT INTO `likes` VALUES (85, 6, 2, 0);
INSERT INTO `likes` VALUES (86, 5, 2, 0);
INSERT INTO `likes` VALUES (87, 9, 2, 0);
INSERT INTO `likes` VALUES (88, 0, 2, 25);
INSERT INTO `likes` VALUES (89, 0, 2, 22);
INSERT INTO `likes` VALUES (90, 0, 2, 20);
INSERT INTO `likes` VALUES (91, 0, 2, 13);
INSERT INTO `likes` VALUES (92, 0, 2, 9);
INSERT INTO `likes` VALUES (93, 7, 2, 0);
INSERT INTO `likes` VALUES (94, 3, 2, 0);
INSERT INTO `likes` VALUES (95, 2, 2, 0);
INSERT INTO `likes` VALUES (96, 1, 2, 0);
INSERT INTO `likes` VALUES (97, 0, 15, 10);
INSERT INTO `likes` VALUES (98, 0, 15, 9);
INSERT INTO `likes` VALUES (99, 0, 13, 1);
INSERT INTO `likes` VALUES (100, 0, 13, 2);
INSERT INTO `likes` VALUES (101, 0, 13, 25);
INSERT INTO `likes` VALUES (102, 0, 13, 22);
INSERT INTO `likes` VALUES (103, 0, 13, 18);
INSERT INTO `likes` VALUES (104, 0, 13, 14);
INSERT INTO `likes` VALUES (105, 0, 13, 5);
INSERT INTO `likes` VALUES (106, 0, 13, 4);
INSERT INTO `likes` VALUES (107, 0, 13, 3);
INSERT INTO `likes` VALUES (108, 0, 13, 9);
INSERT INTO `likes` VALUES (109, 0, 15, 26);
INSERT INTO `likes` VALUES (110, 0, 13, 26);
INSERT INTO `likes` VALUES (111, 12, 13, 0);
INSERT INTO `likes` VALUES (112, 0, 13, 31);
INSERT INTO `likes` VALUES (113, 12, 15, 0);
INSERT INTO `likes` VALUES (114, 0, 15, 33);
INSERT INTO `likes` VALUES (115, 0, 15, 32);
INSERT INTO `likes` VALUES (116, 0, 15, 31);
INSERT INTO `likes` VALUES (117, 0, 15, 34);
INSERT INTO `likes` VALUES (118, 0, 15, 28);
INSERT INTO `likes` VALUES (119, 0, 13, 33);
INSERT INTO `likes` VALUES (120, 0, 13, 32);
INSERT INTO `likes` VALUES (121, 0, 12, 8);
INSERT INTO `likes` VALUES (122, 0, 12, 7);
INSERT INTO `likes` VALUES (123, 0, 12, 6);
INSERT INTO `likes` VALUES (124, 0, 12, 12);
INSERT INTO `likes` VALUES (125, 0, 12, 11);
INSERT INTO `likes` VALUES (126, 12, 12, 0);
INSERT INTO `likes` VALUES (127, 0, 12, 32);
INSERT INTO `likes` VALUES (128, 0, 12, 33);
INSERT INTO `likes` VALUES (129, 0, 12, 31);
COMMIT;

-- ----------------------------
-- Table structure for notify
-- ----------------------------
DROP TABLE IF EXISTS `notify`;
CREATE TABLE `notify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知主键',
  `to_user_id` int(11) NOT NULL COMMENT '消费者',
  `from_user_id` int(11) NOT NULL COMMENT '生产者',
  `create_time` datetime NOT NULL COMMENT '通知时间',
  `is_confirmed` varchar(1) NOT NULL COMMENT '是否消费',
  `message` varchar(32) NOT NULL COMMENT '消息内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='消息通知表 ';

-- ----------------------------
-- Table structure for PDMAN_DB_VERSION
-- ----------------------------
DROP TABLE IF EXISTS `PDMAN_DB_VERSION`;
CREATE TABLE `PDMAN_DB_VERSION` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of PDMAN_DB_VERSION
-- ----------------------------
BEGIN;
INSERT INTO `PDMAN_DB_VERSION` VALUES ('v0.0.0', '默认版本，新增的版本不能低于此版本', '2020-11-25 20:13:16');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.1', '数据库雏形', '2020-12-06 22:30:28');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.2', 'fixed the signature cant be  not null bug', '2020-12-06 22:30:32');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.3', '添加角色权限', '2020-12-06 22:30:36');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.4', '添加圈子名称字段', '2020-12-06 22:30:40');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.5', '修正 trend user_id 字段', '2020-12-06 22:30:45');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.6', '修正 zones zone_name 字段', '2020-12-06 22:30:49');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.7', '为动态表评论表 添加点赞数评论数字段', '2020-12-06 22:30:53');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.8', '修改头像默认值,添加评论图片字段', '2020-12-06 22:30:58');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.9', '为评论表添加父节点字段 删除评论表is_child 字段和is_hot 无用字段', '2020-12-06 22:31:04');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.10', '删除 点赞表 点赞类型字段', '2020-12-06 22:31:09');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.11', '增加 用户表关注数.被关注数字段', '2020-12-06 22:31:14');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.12', '修改图片等字段大小', '2020-12-06 22:32:22');
INSERT INTO `PDMAN_DB_VERSION` VALUES ('0.0.13', '修改默认背景图', '2020-12-06 22:41:14');
COMMIT;

-- ----------------------------
-- Table structure for trend
-- ----------------------------
DROP TABLE IF EXISTS `trend`;
CREATE TABLE `trend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `content` varchar(128) DEFAULT NULL COMMENT '动态内容',
  `images` varchar(128) DEFAULT NULL COMMENT '动态图片',
  `create_time` datetime NOT NULL COMMENT '发布时间',
  `zone_id` int(11) NOT NULL COMMENT '圈子id',
  `likes_count` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `comments_count` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='动态表 ';

-- ----------------------------
-- Records of trend
-- ----------------------------
BEGIN;
INSERT INTO `trend` VALUES (1, 13, '测试测试测试', '[/alu/吐舌.png]', '2020-11-28 12:49:50', 1, 7, 1);
INSERT INTO `trend` VALUES (2, 13, '难搞', '[/ac/30.png]', '2020-11-28 13:34:38', 2, 6, 1);
INSERT INTO `trend` VALUES (3, 12, '有点东西', '[/ac/28.png]', '2020-11-28 14:54:52', 3, 6, 3);
INSERT INTO `trend` VALUES (4, 13, '就离了谱了', '[/ac/02.png, /ac/05.png]', '2020-11-28 18:07:17', 8, 5, 0);
INSERT INTO `trend` VALUES (5, 13, '脑阔疼', '[/alu/无奈.png]', '2020-11-29 12:27:02', 13, 6, 4);
INSERT INTO `trend` VALUES (6, 13, '呜呼呼', '[/alu/阴暗.png]', '2020-11-29 21:14:42', 1, 6, 1);
INSERT INTO `trend` VALUES (7, 13, '呜呼呼呼', '[/alu/击掌.png]', '2020-11-29 21:20:12', 13, 6, 1);
INSERT INTO `trend` VALUES (8, 12, '??????', '[/alu/黑线.png]', '2020-12-01 11:55:30', 10, 6, 4);
INSERT INTO `trend` VALUES (9, 12, '', '[/alu/长草.png]', '2020-12-01 14:22:07', 3, 8, 9);
INSERT INTO `trend` VALUES (10, 12, '婷婷,发生肾么事辣', '[/ac/45.png]', '2020-12-02 22:44:07', 13, 6, 4);
INSERT INTO `trend` VALUES (11, 15, '武林要以和为贵 不要搞窝里斗', '[/ac/1013.png]', '2020-12-03 14:20:08', 13, 7, 1);
INSERT INTO `trend` VALUES (12, 15, '', '[/images/cwyehjike_49585983022109_pic.jpeg]', '2020-12-05 15:59:17', 4, 3, 3);
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键 用户主键,与users.user_id对应',
  `gender` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别 0为男1位女',
  `emotion` varchar(32) DEFAULT NULL COMMENT '情感',
  `birthday` varchar(32) DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表 ';

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (2, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (3, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (5, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (6, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (7, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (8, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (9, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (10, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (11, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (12, '男', '一言难尽', '2000/12/2');
INSERT INTO `user_info` VALUES (13, '男', '恋爱中', '2000/12/1');
INSERT INTO `user_info` VALUES (14, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (15, '男', '等TA出现', '2006/12/1');
INSERT INTO `user_info` VALUES (16, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (17, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键 用户唯一主键',
  `user_name` varchar(32) NOT NULL COMMENT '用户名 用户昵称',
  `avatar` varchar(128) NOT NULL DEFAULT '/images/cat.jpeg' COMMENT '头像',
  `signature` varchar(32) NOT NULL DEFAULT '生活哪有这么多乐趣' COMMENT '签名',
  `password` varchar(32) NOT NULL COMMENT '密码 用户密码',
  `role` varchar(32) NOT NULL DEFAULT 'user' COMMENT '角色',
  `permission` varchar(32) NOT NULL DEFAULT 'view' COMMENT '权限',
  `following` int(11) NOT NULL DEFAULT '0' COMMENT '关注数',
  `followed` int(11) NOT NULL DEFAULT '0' COMMENT '被关注数',
  `cover` varchar(128) NOT NULL DEFAULT '/images/gcS0gSnipaste_2020-11-18_23-13-01.png' COMMENT '背景图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表 用户表,主要存贮访问频次最高的信息';

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, '001', '/images/cat.jpeg', '生活哪有这么多乐趣', '2c5355057658fd8ac4ed4acbc2554f20', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (2, '002', '/images/cat.jpeg', '生活哪有这么多乐趣', '378a29496c88406f245ad31800cd2c5e', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (3, '003', '/images/cat.jpeg', '生活哪有这么多乐趣', '3e68a697b886b20cb553155469a0ba35', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (4, '004', '/images/cat.jpeg', '生活哪有这么多乐趣', 'f621cd9dfe90b7859c10e4b60e76d19d', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (5, '004', '/images/cat.jpeg', '生活哪有这么多乐趣', 'f621cd9dfe90b7859c10e4b60e76d19d', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (6, '004', '/images/cat.jpeg', '生活哪有这么多乐趣', 'f621cd9dfe90b7859c10e4b60e76d19d', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (7, '009', '/images/cat.jpeg', '生活哪有这么多乐趣', '131aee75f68e3b4a32d1f03dbf9fca73', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (8, '004', '/images/cat.jpeg', '生活哪有这么多乐趣', 'f621cd9dfe90b7859c10e4b60e76d19d', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (9, '009', '/images/cat.jpeg', '生活哪有这么多乐趣', '131aee75f68e3b4a32d1f03dbf9fca73', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (10, '11111', '/images/cat.jpeg', '生活哪有这么多乐趣', 'bf133e2df7037b851ba83a1fbc538b70', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (11, '1010', '/images/cat.jpeg', '生活哪有这么多乐趣', '23174001e3eca97a95d11cb69af0ffc4', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (12, '杀手灬路', '/images/04Sjqjike_31136443296317_pic.jpeg', '生活哪有这么多乐趣', '563b0be3328f1aadafd56bfa71f3e340', 'user', 'view', 0, 0, '/images/Gjw73QQ20190413-164949.png');
INSERT INTO `users` VALUES (13, 'Max丶海贼', '/images/QYGBcjike_177457836132654_pic.jpeg', '生活哪有这么多乐趣', '06ef581d73a87b152dd9738e7e4b060f', 'user', 'view', 0, 0, '/images/70COGjike_49585983022109_pic.jpeg');
INSERT INTO `users` VALUES (14, '逆风局局长', '/images/cat.jpeg', '生活哪有这么多乐趣', '0fb8d7f5eef3585d64248c304d3e2f8e', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (15, '马老师', '/images/NMz7qavatar.jpg', '生活哪有这么多乐趣', '58f3a76f004288743c8ec78b13a0f1a5', 'user', 'view', 0, 0, '/images/8pM24QQ20190413-164949.png');
INSERT INTO `users` VALUES (16, '0909', '/images/cat.jpeg', '生活哪有这么多乐趣', '2d729685eedf7b10002d566bcc437093', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
INSERT INTO `users` VALUES (17, '2020', '/images/cat.jpeg', '生活哪有这么多乐趣', 'b9224e75b4ba5d7dd74cfb130b4f535f', 'user', 'view', 0, 0, '/images/gcS0gSnipaste_2020-11-18_23-13-01.png');
COMMIT;

-- ----------------------------
-- Table structure for zone_users
-- ----------------------------
DROP TABLE IF EXISTS `zone_users`;
CREATE TABLE `zone_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '圈子用户主键',
  `zone_id` int(11) NOT NULL COMMENT '圈子主键',
  `user_id` int(11) NOT NULL COMMENT '用户主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关注圈子列表 ';

-- ----------------------------
-- Table structure for zones
-- ----------------------------
DROP TABLE IF EXISTS `zones`;
CREATE TABLE `zones` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '圈子主键 圈子表主键',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像 头像路径',
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述 圈子描述',
  `zone_name` varchar(32) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='圈子表 ';

-- ----------------------------
-- Records of zones
-- ----------------------------
BEGIN;
INSERT INTO `zones` VALUES (1, '/images/FpiLh8Z1J4q-K_PDcgNiuUOjiSBK.jpg', '嬉笑怒骂，人生百态，记录一件小事，把你的故事讲给即友听吧～', '记一件小事');
INSERT INTO `zones` VALUES (2, '/images/Fl2a7XDvdBtCZHGD2OOrP9cfji76.jpeg', '即刻大学生的大本营，除了看不完的论文上不完的课，大学还有精彩的青春和吐不完的槽，在这里分享你的大学生活的吧', '大学生的日常');
INSERT INTO `zones` VALUES (3, '/images/FvNw3wl0e_MdnKbZprqDaKuSe8Ft.jpeg', '人生三大疑问：早饭吃什么？午饭吃什么？晚饭吃什么？', '今天吃什么');
INSERT INTO `zones` VALUES (4, '/images/Fgogg1UiUqQePM3YUYjlbixuzHRh.jpg', '全民社交时代，表情包已经成为聊天必备神器。你最近在用什么表情包？来与大家分享吧！', '表情包斗图中心');
INSERT INTO `zones` VALUES (5, '/images/Fl-tlfUwdYA9OGSBy5tjYlkRhT5L.jpeg', '即刻二手交易平台，即刻只提供信息发布，交易一定要走闲鱼或者面交。', '二手交易');
INSERT INTO `zones` VALUES (6, '/images/FlTYYCVWjw51Wc6JtVY8quNz-fSA.jpeg', '热恋的甜总是忍不住想告诉全世界，欢迎你每日发糖，用狗粮喂饱单身狗。', '秀恩爱联盟');
INSERT INTO `zones` VALUES (7, '/images/FmROlg_WFaUNbnHD5bxhMOO2ot43.jpeg', '遇到什么情感上的问题了吗？有什么恋爱的小套路吗？分享一下，让即友们一起看看吧～', '恋爱问题互助会');
INSERT INTO `zones` VALUES (8, '/images/Fst6LvaWpDKcLLZOsDcacNUue-Ib.jpg', '你们周末都在干什么呀？', '即友的周末生活');
INSERT INTO `zones` VALUES (9, '/images/FptM7GNgTN33Mef3H3hhuo-3AkDR.jpeg', '你真有眼光，全网最会挖掘折扣的小机灵鬼们都在这里啦！快来看看怎么在这里玩耍吧～', '薅羊毛小分队');
INSERT INTO `zones` VALUES (10, '/images/FuuIRn9tsENYknVG1MDEORHroP91.jpeg', '洗澡的时候往往会脑洞大开，每个人在浴室里都是哲学家。', '浴室沉思');
INSERT INTO `zones` VALUES (11, '/images/Fn2KAMmaYt0Quy24D6MVGjnAUOqh.jpg', '欢迎来到这个种草力 max 的圈子，你可以在这里找到超级多好物安利，包括但不限于 家用电器/日常用品/美食美器/.... 新朋友建议看看以下规则噢', '有什么好东西值得买');
INSERT INTO `zones` VALUES (12, '/images/Fiw1QzPmPmVCJ15PpP5uQy74esqw.jpeg', '😁这里是即刻最大的搞笑内容圈子，欢迎发布你看到的、正在经历的好笑的事', '今天有什么好笑的');
INSERT INTO `zones` VALUES (13, '/images/cat.jpeg', '年轻人不讲武德耗子尾汁', '混元形意太极');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
