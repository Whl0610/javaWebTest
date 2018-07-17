/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-17 16:44:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for que
-- ----------------------------
DROP TABLE IF EXISTS `que`;
CREATE TABLE `que` (
  `id` int(11) NOT NULL,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `A` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `B` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `D` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of que
-- ----------------------------
INSERT INTO `que` VALUES ('1', '什么碗打不烂？（）', '木碗', '陶瓷碗', '铁饭碗', '塑料碗', 'C');
INSERT INTO `que` VALUES ('2', '先秦时代,教育内容以六艺为主,下列不属于六艺的是？（）', '射', '御', '礼', '武', 'D');
INSERT INTO `que` VALUES ('3', '生当做人杰,死亦为鬼雄,至今思项羽,不肯过江东。为哪位诗人的作品?（）', '李白', '杜甫', '李商隐', '李清照', 'D');
INSERT INTO `que` VALUES ('4', '鲁迅先生称(  )为史家之绝唱,无韵之离骚。', '史记', '汉书', '三国志', '资治通鉴', 'A');
