/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.33 : Database - mf_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `mf_db`;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单主键',
  `uid` bigint DEFAULT NULL COMMENT '用户id',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`uid`,`buy_time`,`goods_name`,`amount`) values 
(1,1,'2023-05-16 12:10:27','鸡蛋',20.00),
(2,1,'2023-05-04 12:10:32','磁带',30.00);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `sex` int DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`nickname`,`birthday`,`created`,`sex`) values 
(1,'迪丽热巴','1990-01-01','2023-05-16 11:23:05',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
