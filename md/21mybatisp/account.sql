/*
Navicat MySQL Data Transfer

Source Server         : pz81
Source Server Version : 50568
Source Host           : 192.168.8.81:3306
Source Database       : day16

Target Server Type    : MYSQL
Target Server Version : 50568
File Encoding         : 65001

Date: 2023-09-08 09:55:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `money` int(11) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'tiger', '888', '1');
INSERT INTO `account` VALUES ('2', 'pig', '3200', '0');
