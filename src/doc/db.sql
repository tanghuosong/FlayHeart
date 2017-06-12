/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.28 : Database - flay_heart
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flay_heart` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `flay_heart`;

/*Table structure for table `tb_board` */

DROP TABLE IF EXISTS `tb_board`;

CREATE TABLE `tb_board` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '版块名称',
  `description` text COLLATE utf8_unicode_ci NOT NULL COMMENT '板块描述',
  `state` int(11) NOT NULL COMMENT '板块状态',
  `stateDisplay` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '板块状态说明',
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_board` */

insert  into `tb_board`(`id`,`name`,`description`,`state`,`stateDisplay`,`createTime`,`updateTime`) values (1,'Android 学习','关于Android 学习',100,'上线','2017-06-01 13:43:39','2017-06-12 09:41:58'),(2,'Kotlin','关于Kotlin学习',100,'上线','2017-06-01 13:44:25','2017-06-09 17:54:57');

/*Table structure for table `tb_favorite` */

DROP TABLE IF EXISTS `tb_favorite`;

CREATE TABLE `tb_favorite` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topicId` bigint(20) unsigned NOT NULL COMMENT '所属帖子',
  `userId` bigint(20) unsigned NOT NULL COMMENT '点赞用户',
  `favoriteTime` datetime NOT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_favorite` */

/*Table structure for table `tb_focus` */

DROP TABLE IF EXISTS `tb_focus`;

CREATE TABLE `tb_focus` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) unsigned NOT NULL COMMENT '关注用户id',
  `focusUserId` bigint(20) unsigned NOT NULL COMMENT '被关注用户id',
  `focusTime` datetime NOT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_focus` */

insert  into `tb_focus`(`id`,`userId`,`focusUserId`,`focusTime`) values (1,1,3,'2017-05-30 12:06:52'),(2,1,4,'2017-05-30 12:07:04');

/*Table structure for table `tb_manager` */

DROP TABLE IF EXISTS `tb_manager`;

CREATE TABLE `tb_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员名称',
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员密码',
  `permission` int(11) NOT NULL DEFAULT '200' COMMENT '管理员权限',
  `permissionDisplay` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限说明',
  `email` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员邮箱',
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL COMMENT '管理员手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_manager` */

insert  into `tb_manager`(`id`,`name`,`password`,`permission`,`permissionDisplay`,`email`,`phone`) values (1,'admin','123456',100,'超级管理员','admin@admin.com','18949344290'),(2,'admin1','123456',200,'普通管理员','admin@admin.com','18949344290');

/*Table structure for table `tb_reply` */

DROP TABLE IF EXISTS `tb_reply`;

CREATE TABLE `tb_reply` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topicId` bigint(20) unsigned NOT NULL COMMENT '所属帖子',
  `userId` bigint(20) unsigned NOT NULL COMMENT '回帖用户',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '回帖内容',
  `replayTime` datetime NOT NULL COMMENT '回帖时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_reply` */

insert  into `tb_reply`(`id`,`topicId`,`userId`,`content`,`replayTime`) values (1,1,1,'我是用来测试的','2017-05-31 20:30:06'),(2,1,1,'我是用来测试的','2017-05-31 20:30:06'),(3,1,1,'我是用来测试的','2017-05-31 20:30:06'),(4,1,1,'我是用来测试的','2017-05-31 20:30:06'),(5,1,1,'我是用来测试的','2017-05-31 20:30:06'),(6,1,1,'我是用来测试的','2017-05-31 20:30:06'),(7,1,1,'我是用来测试的','2017-05-31 20:30:06'),(8,1,1,'我是用来测试的','2017-05-31 20:30:06'),(9,1,1,'我是用来测试的','2017-05-31 20:30:06'),(10,1,1,'我是用来测试的','2017-05-31 20:30:06'),(11,1,1,'我是用来测试的','2017-05-31 20:30:06');

/*Table structure for table `tb_topic` */

DROP TABLE IF EXISTS `tb_topic`;

CREATE TABLE `tb_topic` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `boardId` bigint(20) unsigned NOT NULL COMMENT '所属版块',
  `userId` bigint(20) unsigned NOT NULL COMMENT '所属用户',
  `title` varchar(80) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '内容',
  `views` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '浏览量',
  `state` int(10) unsigned NOT NULL DEFAULT '100' COMMENT '状态',
  `stateDisplay` varchar(40) COLLATE utf8_unicode_ci NOT NULL DEFAULT '审核通过' COMMENT '状态说明',
  `postTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发帖时间',
  `favorites` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_topic` */

insert  into `tb_topic`(`id`,`boardId`,`userId`,`title`,`content`,`views`,`state`,`stateDisplay`,`postTime`,`favorites`) values (1,1,1,'测试','测试',0,100,'审核通过','2017-05-29 23:00:00',0),(2,2,3,'测试2','测试2',0,100,'审核通过','2017-05-28 23:00:00',0),(3,2,3,'测试2','测试2',0,100,'审核通过','2017-05-28 23:00:00',0),(4,5,4,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(5,2,3,'测试2','测试2',0,100,'审核通过','2017-05-28 23:00:00',0),(6,1,1,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(7,1,1,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(8,3,2,'ce','ce',0,100,'审核通过','2017-05-29 23:34:07',0),(9,1,1,'测试','测试',0,100,'审核通过','2017-05-29 23:00:00',0),(10,2,3,'测试2','测试2',0,100,'审核通过','2017-05-28 23:00:00',0),(11,5,4,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(12,2,3,'测试2','测试2',0,100,'审核通过','2017-05-28 23:00:00',0),(13,1,1,'测试','测试',0,200,'不可评论','2017-05-30 15:11:21',0),(14,1,1,'测试','测试',0,200,'禁止评论','2017-05-30 14:30:46',0),(15,3,2,'ce','ce',0,100,'审核通过','2017-05-29 23:34:07',0),(16,1,1,'测试','测试',0,100,'审核通过','2017-05-29 23:00:00',0),(17,1,1,'测试','测试',0,100,'审核通过','2017-05-29 23:00:00',0),(18,1,1,'测试','测试',0,100,'审核通过','2017-05-29 23:00:00',0),(19,1,1,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(20,1,1,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(21,1,1,'测试','测试',0,100,'审核通过','2017-05-28 23:00:00',0),(22,1,1,'测试','我就是测试一下',0,100,'审核通过','2017-05-30 14:30:06',0),(23,1,1,'测试','我就是测试一下',0,100,'审核通过','2017-05-30 14:30:07',0),(25,2,1,'测试','我就是测试一下',0,100,'正常','2017-05-30 15:24:43',0),(26,2,1,'测试','我就是测试一下',0,100,'审核通过','2017-05-30 15:34:04',0),(27,2,1,'测试','我就是测试一下',0,100,'审核通过','2017-06-04 22:49:14',0);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `sex` varchar(2) COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `registTime` datetime DEFAULT NULL COMMENT '注册时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `state` int(11) unsigned NOT NULL COMMENT '状态',
  `stateDisplay` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '状态说明',
  `focusCount` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '关注人数',
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`name`,`phone`,`password`,`sex`,`registTime`,`lastLoginTime`,`state`,`stateDisplay`,`focusCount`,`email`) values (1,'ths','18949344290','123456','男','2017-05-30 14:26:40','2017-06-04 22:27:33',100,'正常',0,'ths930910@163.com'),(2,'ths2','18949344290','123456','男','2017-05-30 14:16:46','2017-05-30 15:10:19',200,'限制登录',0,'ths930910@163.com'),(3,'ths3','18949344290','123456','男','2017-05-30 14:16:50','2017-05-30 14:15:49',100,'正常',0,'ths930910@163.com'),(8,'ths4','18949344290','123456','男','2017-05-30 16:09:10','2017-05-30 16:09:10',100,'正常',0,'tanghuosong@qq.com'),(9,'ths5','18949344290','123456','男','2017-05-30 14:26:40','2017-06-04 22:27:33',100,'正常',0,'ths930910@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
