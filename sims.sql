/*
 Navicat Premium Data Transfer

 Source Server         : 半亩方塘
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 21/07/2020 09:20:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账号表的主键',
  `a_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'student_name' COMMENT '用户显示的用户名称',
  `a_gender` int(1) NULL DEFAULT NULL COMMENT '用户的性别 1 为男，2为女',
  `a_birthday` date NULL DEFAULT NULL COMMENT '用户年龄',
  `a_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的登录账户id，非空',
  `a_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1234567' COMMENT '用户的登录账户密码，非空',
  `a_major_id` int(11) NULL DEFAULT NULL COMMENT '用户的专业id，对应 major.major_id',
  `a_create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建的人账号',
  `a_create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建的时间',
  `a_modify_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人的账号',
  `a_modfify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改的 时间',
  `age` int(11) NULL DEFAULT NULL COMMENT '无用的age',
  PRIMARY KEY (`a_id`) USING BTREE,
  UNIQUE INDEX `a_user`(`a_user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '超级管理员', 1, '2001-03-17', '1234567', '1234567', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (2, '路人01', 1, '0000-00-00', '1234568', '1234567', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (3, '路人02', 1, '0000-00-00', '1234569', '1234567', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (4, '路人03', 1, '0000-00-00', '1234570', '1234567', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (5, '路人04', 1, '0000-00-00', '1234571', '1234567', 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (6, '路人05', 1, '0000-00-00', '1234572', '1234567', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (7, '路人06', 1, '0000-00-00', '1234573', '1234567', 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (8, '路人07', 1, '0000-00-00', '1234574', '1234567', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (9, '路人08', 1, '0000-00-00', '1234575', '1234567', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (10, '路人09', 1, '0000-00-00', '1234576', '1234567', 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (11, '路人10', 2, '0000-00-00', '1234577', '1234567', 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (12, '路人11', 2, '0000-00-00', '1234578', '1234567', 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (13, '路人12', 2, '0000-00-00', '1234579', '1234567', 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (14, '路人13', 2, '0000-00-00', '1234580', '1234567', 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (15, '路人14', 2, '0000-00-00', '1234581', '1234567', 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (16, '路人15', 2, '0000-00-00', '1234582', '1234567', 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (17, '路人16', 2, '0000-00-00', '1234583', '1234567', 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (18, '路人17', 2, '0000-00-00', '1234584', '1234567', 5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `account` VALUES (25, '范德萨发', 1, NULL, 'fdsafas', NULL, 1, '1234567', '2020-07-20 00:00:00', NULL, NULL, 12);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `m_id` int(11) NOT NULL COMMENT 'major表的id',
  `m_major_id` int(11) NULL DEFAULT NULL COMMENT '和account学生专业对应的 id',
  `m_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业major_id对应的专业名称',
  `m_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业的描述',
  `m_stu_count` int(10) NULL DEFAULT NULL COMMENT '专业的人数',
  `m_create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建专业的人的user账号',
  `m_create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `m_modify_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `m_modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, 1, '软件工程', '我与徐公熟美', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (2, 2, '通信工程', '我与徐公熟美', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (3, 3, '电子信息工程', '我与徐公熟美', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (4, 4, '信息工程', '我与徐公熟美', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `major` VALUES (5, 5, '广播电视工程', '我与徐公熟美', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
