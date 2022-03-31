/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : exceldemo

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 15/09/2020 12:18:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bir` timestamp(0) NULL DEFAULT NULL,
  `no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, '机器人0号', '2020-09-14 00:00:00', '522401199708139634', '贵州遵义');
INSERT INTO `t_user` VALUES (3, '机器人1号', '2020-09-15 00:00:00', '522401199708139635', '贵州毕节');
INSERT INTO `t_user` VALUES (4, '机器人2号', '2020-09-16 00:00:00', '522401199708139636', '北京');
INSERT INTO `t_user` VALUES (5, '机器人3号', '2020-09-17 00:00:00', '522401199708139637', '贵州贵阳');
INSERT INTO `t_user` VALUES (6, '机器人4号', '2020-09-18 00:00:00', '522401199708139638', '厦门');

SET FOREIGN_KEY_CHECKS = 1;
