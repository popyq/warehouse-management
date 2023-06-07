/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : warehouse

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/06/2023 11:04:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `clientId` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `goodsId` int(0) NULL DEFAULT NULL,
  `goodsNum` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (202204, '李信', '男', 18, 1004, 100);
INSERT INTO `client` VALUES (202205, '肖潇', '女', 18, 1005, 130);
INSERT INTO `client` VALUES (202206, '李四', '女', 18, 2001, 100);
INSERT INTO `client` VALUES (202201, '李大钊', '男', 19, 1001, 110);
INSERT INTO `client` VALUES (202203, '周树人', '男', 18, 1003, 120);
INSERT INTO `client` VALUES (202207, '鲁迅', '男', 18, 2002, 140);
INSERT INTO `client` VALUES (202208, '张三', '女', 18, 2003, 100);
INSERT INTO `client` VALUES (202209, '王五', '女', 18, 2004, 150);
INSERT INTO `client` VALUES (202210, '熊二', '女', 18, 2005, 100);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `site` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1002, '洋葱', 200, '湖南', '2022-12-05 12:15:12');
INSERT INTO `goods` VALUES (1004, '茄子', 200, '安福', '2022-12-15 12:11:50');
INSERT INTO `goods` VALUES (1005, '生姜', 230, '江西', '2022-12-15 20:30:09');
INSERT INTO `goods` VALUES (1007, '苹果', 200, '九江', '2022-12-20 07:00:05');
INSERT INTO `goods` VALUES (2001, '桃子', 200, '北京', '2022-12-15 20:30:12');
INSERT INTO `goods` VALUES (2002, '橘子', 240, '赣南', '2022-12-15 20:30:15');
INSERT INTO `goods` VALUES (2003, '苹果', 200, '抚州', '2022-12-15 20:30:17');
INSERT INTO `goods` VALUES (2004, '梨子', 250, '上饶', '2022-12-15 20:30:20');
INSERT INTO `goods` VALUES (2005, '李子', 260, '南昌', '2022-12-15 20:30:23');
INSERT INTO `goods` VALUES (3001, '老母鸡', 270, '九江', '2022-12-15 20:30:26');
INSERT INTO `goods` VALUES (3002, '水鸭', 200, '吉水', '2022-12-15 20:30:30');

-- ----------------------------
-- Table structure for goods_id
-- ----------------------------
DROP TABLE IF EXISTS `goods_id`;
CREATE TABLE `goods_id`  (
  `uid` int(0) NOT NULL,
  `id` int(0) NOT NULL,
  `clientId` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_id
-- ----------------------------
INSERT INTO `goods_id` VALUES (101, 1004, 202204);
INSERT INTO `goods_id` VALUES (101, 1005, 202205);
INSERT INTO `goods_id` VALUES (101, 2001, 202206);
INSERT INTO `goods_id` VALUES (101, 2002, 202207);
INSERT INTO `goods_id` VALUES (102, 2001, 202208);
INSERT INTO `goods_id` VALUES (102, 2003, 202209);
INSERT INTO `goods_id` VALUES (102, 2004, 202210);
INSERT INTO `goods_id` VALUES (102, 2005, 202201);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT 20,
  `gender` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '男',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (101, 'kafka', '222222', 18, '男');
INSERT INTO `user` VALUES (102, 'fanfan', '111111', 19, '男');
INSERT INTO `user` VALUES (103, 'lili', '111111', 22, '女');
INSERT INTO `user` VALUES (108, 'yueyue', '111111', 20, '男');

SET FOREIGN_KEY_CHECKS = 1;
