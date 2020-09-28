/*
Navicat MySQL Data Transfer

Source Server         : try_aliyun_mysql
Source Server Version : 50720
Source Host           : 47.99.68.133:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-09-28 09:06:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL COMMENT '打卡开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '打开结束时间',
  `stuCardId` varchar(30) DEFAULT NULL COMMENT '学生cardId',
  `teaCardId` varchar(30) DEFAULT NULL COMMENT '老师cardId',
  `course` varchar(100) DEFAULT NULL COMMENT '课程',
  `content` varchar(1000) DEFAULT NULL COMMENT '上课内容',
  `editStatus` varchar(1) DEFAULT NULL COMMENT '上课编辑状态（0未编辑 1已编辑）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '2020-05-02 01:30:22', '2020-05-02 02:05:19', '290AC4B2', 'admin', '高等数学A', '本节课老师讲述了微积分原理，并且布置了书本P30页的练习题1、2', '1');
INSERT INTO `attendance` VALUES ('2', '2020-05-02 01:48:45', '2020-05-02 02:30:59', '73CFF502', 'admin', '线性代数', '主要讲述了列运算，矩阵运算。并布置了书本P42页的习题3、4', '1');
INSERT INTO `attendance` VALUES ('3', '2020-05-04 19:14:27', '2020-05-04 20:00:52', '73CFF502', 'admin', '语文', '该节课学的好', '1');
INSERT INTO `attendance` VALUES ('4', '2020-05-04 10:15:33', '2020-05-04 11:00:45', '290AC4B2', 'admin', '高等数学A', '本节老师讲了课后做的练习题', '1');
INSERT INTO `attendance` VALUES ('5', '2020-05-04 14:00:48', '2020-05-04 14:45:55', '290AC4B2', 'admin', '语文', '本节课老师举行了一场辩论赛', '1');
INSERT INTO `attendance` VALUES ('6', '2020-05-04 15:00:03', '2020-05-04 15:45:25', '290AC4B2', 'admin', '英语', '本节课老师抽人背诵课文以及随堂考试', '1');
INSERT INTO `attendance` VALUES ('7', '2020-05-04 19:14:32', '2020-05-04 20:00:44', '290AC4B2', 'admin', '体育', '今天这节课老师主要教了一套动作，主要分为踢腿、伸头、旋转等动作', '1');
INSERT INTO `attendance` VALUES ('8', '2020-05-04 17:00:53', '2020-05-04 17:45:02', '290AC4B2', 'admin', '语文', '这节课我们学习了爱莲说文言文，要求熟悉背诵', '1');
INSERT INTO `attendance` VALUES ('9', '2020-05-10 16:31:53', '2020-05-10 16:55:58', '290AC4B2', '', null, null, '0');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `imageUrl` varchar(255) DEFAULT NULL,
  `userId` int(32) DEFAULT NULL,
  `addTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for leaveform
-- ----------------------------
DROP TABLE IF EXISTS `leaveform`;
CREATE TABLE `leaveform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applyCardId` varchar(20) DEFAULT NULL COMMENT '申请人的cardId',
  `leaveName` varchar(20) DEFAULT NULL COMMENT '申请人姓名',
  `startTime` datetime DEFAULT NULL COMMENT '请假开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '请假结束时间',
  `approverCardId` varchar(20) DEFAULT NULL COMMENT '审批者cardId',
  `reason` varchar(255) DEFAULT NULL COMMENT '请假理由',
  `addTime` datetime DEFAULT NULL COMMENT '添加时间（申请时间）',
  `status` varchar(1) DEFAULT NULL COMMENT '状态(0待审核 ，1 审核通过 2 审核不通过)',
  `verifyTime` datetime DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leaveform
-- ----------------------------
INSERT INTO `leaveform` VALUES ('9', 'C7989760', '大卫', '2020-05-02 08:00:00', '2020-05-03 08:00:00', 'admin', '家里母亲生病，急需回家探望', '2020-05-02 01:00:02', '1', '2020-05-02 01:24:54');
INSERT INTO `leaveform` VALUES ('10', '290AC4B2', '张三', '2020-03-20 08:00:00', '2020-03-23 08:00:00', 'admin', '家里有事，急需回家处理', '2020-05-02 01:01:08', '1', '2020-05-08 02:17:41');
INSERT INTO `leaveform` VALUES ('12', '290AC4B2', '张三', '2020-05-08 01:00:00', '2020-05-08 14:00:00', 'admin', '实施沪市', '2020-05-08 02:38:20', '1', '2020-05-10 17:16:22');
INSERT INTO `leaveform` VALUES ('13', 'C7989760', '大卫', '2020-05-12 08:00:00', '2020-05-12 14:00:00', 'admin', '我想回家看看', '2020-05-12 18:56:58', '1', '2020-05-12 19:05:26');
INSERT INTO `leaveform` VALUES ('14', '290AC4B2', '张三', '2020-05-02 08:00:00', '2020-05-02 18:00:00', 'admin', '因为感冒了，请一天假去医院打点滴', '2020-05-23 00:36:31', '1', '2020-05-23 02:50:13');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(255) DEFAULT NULL COMMENT '密码',
  `cardId` varchar(255) DEFAULT '' COMMENT '卡号',
  `identity` varchar(1) DEFAULT NULL COMMENT '所属身份（0学生 1老师）',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `classInfo` varchar(255) DEFAULT NULL COMMENT '所在班级',
  `motto` varchar(255) DEFAULT NULL COMMENT '座右铭',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别（0男 1女）',
  `addTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('25', '李四', '123456', '73CFF502', '0', '15556060632', '16物联网工程（2）班', '不要失望，胜利就在眼前', '0', '2020-05-02 01:47:19', '2020-05-02 01:48:14');
INSERT INTO `user` VALUES ('26', '大卫', '123456', 'C7989760', '0', '15556046091', '16物联网（3）班', '梦在远方，需要我们努力实现', '0', '2020-05-12 18:46:24', '2020-05-12 18:53:32');
INSERT INTO `user` VALUES ('28', '张三', '123456', '290AC4B2', '0', '15556046091', '16物联网工程（1）班', '好好学习，天天向上', '0', '2020-05-23 01:37:42', '2020-05-23 01:38:49');
INSERT INTO `user` VALUES ('29', '王倩', '111111', 'admin', '1', '15056436983', '', '好好教学，不放弃任何学生', '1', '2020-05-23 01:49:55', '2020-05-23 02:23:51');
