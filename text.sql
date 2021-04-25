/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : text

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-01-23 12:52:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(255) NOT NULL,
  `a_date` date NOT NULL,
  `a_status` varchar(255) DEFAULT NULL,
  `a_reason` varchar(255) NOT NULL,
  `t_id` int(11) NOT NULL,
  `t_name` varchar(255) NOT NULL,
  PRIMARY KEY (`s_id`,`a_date`),
  KEY `b` (`t_id`),
  CONSTRAINT `b` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', '张弟', '2000-11-11', '拒绝', '1', '1', '张哥');
INSERT INTO `application` VALUES ('1', '张弟', '2000-11-12', '拒绝', '我', '1', '张哥');
INSERT INTO `application` VALUES ('1', '张弟', '2000-11-13', null, '我', '1', '张哥');
INSERT INTO `application` VALUES ('1', '张弟', '2021-01-18', null, '1', '1', '张哥');

-- ----------------------------
-- Table structure for checkifo
-- ----------------------------
DROP TABLE IF EXISTS `checkifo`;
CREATE TABLE `checkifo` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(255) DEFAULT NULL,
  `c_date` varchar(255) NOT NULL,
  `c_healthy` varchar(255) DEFAULT NULL,
  `c_adress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`,`c_date`),
  CONSTRAINT `s_id` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkifo
-- ----------------------------
INSERT INTO `checkifo` VALUES ('1', '张弟', '2000-11-12', '1', '1');
INSERT INTO `checkifo` VALUES ('1', '张弟', '2021-01-22', '健康', '3');
INSERT INTO `checkifo` VALUES ('1', '张弟', '2021-1-18', '1', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL,
  `s_pwd` varchar(255) NOT NULL,
  `s_name` varchar(255) NOT NULL,
  `t_id` int(11) NOT NULL,
  `t_name` varchar(255) NOT NULL,
  PRIMARY KEY (`s_id`),
  KEY `tid` (`t_id`),
  CONSTRAINT `tid` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '张弟', '1', '张哥');
INSERT INTO `student` VALUES ('2', '1', '孙一', '1', '张哥');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL,
  `t_pwd` varchar(255) NOT NULL,
  `t_name` varchar(255) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1', '张哥');
