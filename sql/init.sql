/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : tictok-e-commerce

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 01/03/2025 13:06:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
                            `price` decimal(10, 2) NOT NULL COMMENT '价格',
                            `type` int NOT NULL COMMENT '商品类别 0:食物 1:日用品 2:商务电子 3:服装饰品 4:书籍',
                            `stock` int NOT NULL COMMENT '库存',
                            `status` int NULL DEFAULT NULL COMMENT '状态 0:禁用 1:启用',
                            `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                            `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                            `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
                            `updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
                            `is_deleted` int NULL DEFAULT NULL COMMENT '是否删除 0:未删除 1:已删除',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES (3, '菠萝手机3代 pro max', 6999.99, 4, 5000, 0, '2025-03-01 13:03:08', '2025-03-01 13:03:08', 'admin', 'admin', 0);

SET FOREIGN_KEY_CHECKS = 1;
