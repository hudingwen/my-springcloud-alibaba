/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : springcloud

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2023-03-02 10:52:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_book
-- ----------------------------
DROP TABLE IF EXISTS `db_book`;
CREATE TABLE `db_book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `desc` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of db_book
-- ----------------------------
INSERT INTO `db_book` VALUES ('1', 'JAVA入门', '了解并入门java的大门');
INSERT INTO `db_book` VALUES ('2', 'JAVA基础', '了解各类语法和特性');
INSERT INTO `db_book` VALUES ('3', 'JAVA高级', '了解编译原理');

-- ----------------------------
-- Table structure for db_borrow
-- ----------------------------
DROP TABLE IF EXISTS `db_borrow`;
CREATE TABLE `db_borrow` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_uid_bid` (`uid`,`bid`),
  KEY `fk_bid` (`bid`),
  CONSTRAINT `fk_bid` FOREIGN KEY (`bid`) REFERENCES `db_book` (`bid`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `db_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of db_borrow
-- ----------------------------
INSERT INTO `db_borrow` VALUES ('1', '1', '1');
INSERT INTO `db_borrow` VALUES ('2', '2', '3');

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `sex` enum('男生','女生','未知') COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('1', '小明', '18', '男生');
INSERT INTO `db_user` VALUES ('2', '小红', '19', '女生');
