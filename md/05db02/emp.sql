/*
Navicat MySQL Data Transfer

Source Server         : pz81
Source Server Version : 50568
Source Host           : 192.168.8.81:3306
Source Database       : day15

Target Server Type    : MYSQL
Target Server Version : 50568
File Encoding         : 65001

Date: 2023-07-24 10:01:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(50) NOT NULL,
  `joindate` date NOT NULL,
  `salary` double(7,2) DEFAULT NULL,
  `bonus` double(7,2) DEFAULT '8.88',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ename` (`ename`),
  KEY `ename_sal_ind` (`ename`,`salary`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'tiger', '2020-01-01', '3000.88', '5000.00');
INSERT INTO `emp` VALUES ('2', 'tiger3', '1999-02-02', '88.00', '88.00');
INSERT INTO `emp` VALUES ('3', 'tiger2', '2020-01-01', '3000.88', '5000.00');
INSERT INTO `emp` VALUES ('4', '', '2020-03-03', '20.00', '30.00');
INSERT INTO `emp` VALUES ('5', 'pig', '1997-07-01', '0.00', '0.00');
INSERT INTO `emp` VALUES ('6', 'pig2', '1997-07-01', '0.00', '8.88');
INSERT INTO `emp` VALUES ('7', 'pig3', '1997-07-01', null, '8.88');
