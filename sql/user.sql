/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.31.113
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 22/09/2023 17:24:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(20) NOT NULL COMMENT '年龄',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xiaozhang', 'd3b1294a61a07da9b49b6e22b2cbd7f9', '男', 24, '123@163.com', '西安市');
INSERT INTO `user` VALUES (3, 'editer', 'd018506bc314a32b93eb214102399a63', '女', 25, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (5, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (6, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (7, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (8, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (9, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (10, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (11, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (12, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (13, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');
INSERT INTO `user` VALUES (14, 'admin', '3bae2bbeb0c3a6a991f21219f635d47b', '男', 24, '125@163.com', '碑林区');

SET FOREIGN_KEY_CHECKS = 1;
