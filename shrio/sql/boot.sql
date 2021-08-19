/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : boot

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-08-19 15:18:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_loginuser`
-- ----------------------------
DROP TABLE IF EXISTS `t_loginuser`;
CREATE TABLE `t_loginuser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_loginuser
-- ----------------------------
INSERT INTO `t_loginuser` VALUES ('1', 'zhl', 'abcd');
INSERT INTO `t_loginuser` VALUES ('2', 'test', 'abcd');

-- ----------------------------
-- Table structure for `t_loginuser_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_loginuser_role`;
CREATE TABLE `t_loginuser_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_loginuser_role
-- ----------------------------
INSERT INTO `t_loginuser_role` VALUES ('1', '1', '1');
INSERT INTO `t_loginuser_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zhl', '18', 'abcd', 'ROLE_VIP1');
