/*
SQLyog Ultimate v8.32 
MySQL - 5.6.15-enterprise-commercial-advanced-log : Database - mobilegateway
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mobilegateway` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `mobilegateway`;

/*Table structure for table `bloodglucose` */

DROP TABLE IF EXISTS `bloodglucose`;

CREATE TABLE `bloodglucose` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `company` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '单位代码',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `bloodpressure` */

DROP TABLE IF EXISTS `bloodpressure`;

CREATE TABLE `bloodpressure` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `company` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '单位代码',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `dailyexercise` */

DROP TABLE IF EXISTS `dailyexercise`;

CREATE TABLE `dailyexercise` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `company` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '单位代码',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `datastatistics` */

DROP TABLE IF EXISTS `datastatistics`;

CREATE TABLE `datastatistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `exceptionNum` int(11) DEFAULT NULL,
  `receiveNum` int(11) DEFAULT NULL,
  `sendNum` int(11) DEFAULT NULL,
  `zeroValueNum` int(11) DEFAULT NULL,
  `statisticsTime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `ecgdata` */

DROP TABLE IF EXISTS `ecgdata`;

CREATE TABLE `ecgdata` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `company` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '单位代码',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` mediumtext COLLATE utf8_bin COMMENT '数据内容',
  `deviceUseFlag` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `pname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `exceptiondata` */

DROP TABLE IF EXISTS `exceptiondata`;

CREATE TABLE `exceptiondata` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `patientID` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户的标示',
  `company` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位名称',
  `deviceID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '发送标识',
  `sendFlag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT 'phr2.0',
  `spareFlag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '备用标识符',
  `packageNum` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数据包的标号',
  `totalSteps` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '8-1 :简要包的总数',
  `receiveTime` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '数据接收时间',
  `data_newcontent_stepcount2` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '8-3：手机号+PHR+日期+字节值',
  `STEP3NEWVALUE` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '8-3 :详细包的文件名+手机号+Json数据包',
  `STEP2NEWVALUE` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '8-2 :详细包的文件名+手机号+Json数据包',
  `sendTime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数据发送时间',
  `location` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '8-4：位置信息',
  `realTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `firmware_version` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `exceptionuser` */

DROP TABLE IF EXISTS `exceptionuser`;

CREATE TABLE `exceptionuser` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `loginTime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deviceID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patientID` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_excepuser_logintime` (`loginTime`),
  KEY `index_excepuser_deviceid` (`deviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=8874 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `heartfunction` */

DROP TABLE IF EXISTS `heartfunction`;

CREATE TABLE `heartfunction` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `company` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '单位代码',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `packagedata` */

DROP TABLE IF EXISTS `packagedata`;

CREATE TABLE `packagedata` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `patientID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `company` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deviceID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flag` varchar(1) COLLATE utf8_unicode_ci DEFAULT '0',
  `sendFlag` varchar(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT 'phr2.0',
  `spareFlag` char(1) COLLATE utf8_unicode_ci DEFAULT '0',
  `packageNum` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `totalSteps` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiveTime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `data_newcontent_stepcount2` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STEP3NEWVALUE` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STEP2NEWVALUE` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sendTime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '基站信息',
  `realTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数据测量时间',
  `firmware_version` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '固件版本信息',
  `deviceType` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_packagedata_flag` (`flag`),
  KEY `index_packagedata_company` (`company`),
  KEY `index_packagedata_patientID` (`patientID`),
  KEY `index_packagedata_receiveTime` (`receiveTime`),
  KEY `index_packagedata_totalSteps` (`totalSteps`),
  KEY `index_packagedata_packageNum` (`packageNum`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `resetrecord` */

DROP TABLE IF EXISTS `resetrecord`;

CREATE TABLE `resetrecord` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `deviceID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patientID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receiveTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `totalSteps` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `packagedataID` int(10) DEFAULT NULL,
  `companyName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `teamName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `sleep` */

DROP TABLE IF EXISTS `sleep`;

CREATE TABLE `sleep` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `pname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` mediumtext COLLATE utf8_bin COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `spo2` */

DROP TABLE IF EXISTS `spo2`;

CREATE TABLE `spo2` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `pname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `sports` */

DROP TABLE IF EXISTS `sports`;

CREATE TABLE `sports` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `pname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `hourvalue` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据所属小时',
  `dataValue` varchar(1500) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `threadexceptionrecord` */

DROP TABLE IF EXISTS `threadexceptionrecord`;

CREATE TABLE `threadexceptionrecord` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `threadName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `exceptionTime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `recoverTime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apptype` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `idcard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `realname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Table structure for table `userbaseinfo` */

DROP TABLE IF EXISTS `userbaseinfo`;

CREATE TABLE `userbaseinfo` (
  `user_email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_passwd` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_realName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_birth` datetime DEFAULT NULL,
  `user_sex` bigint(1) DEFAULT NULL,
  `user_phone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_registerTime` datetime DEFAULT NULL,
  `user_pic` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activateflag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '0表示未激活，1表示已经激活',
  `shortmsgflag` char(1) COLLATE utf8_unicode_ci DEFAULT '1' COMMENT '0表示不发送短信提醒，1表示发送短信提醒',
  PRIMARY KEY (`user_email`),
  KEY `ind_userbaseinfo_userpasswd` (`user_passwd`),
  KEY `ind_userbaseinfo_userphone` (`user_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `userparaminfo_gateway` */

DROP TABLE IF EXISTS `userparaminfo_gateway`;

CREATE TABLE `userparaminfo_gateway` (
  `phone` varchar(50) NOT NULL,
  `weight` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL COMMENT '年龄段',
  `height` varchar(50) DEFAULT NULL COMMENT '身高',
  `sex` char(1) DEFAULT NULL COMMENT '性别，1表示男，0表示女',
  `changetime` datetime DEFAULT NULL COMMENT '更改时间',
  `needsend` char(1) DEFAULT NULL COMMENT '0表示没有下推到计步器，1表示已经下推到计步器',
  `datafromip` varchar(50) DEFAULT NULL,
  `datafromdomain` varchar(50) DEFAULT NULL,
  `port` varchar(50) DEFAULT NULL,
  `autouploadtime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Table structure for table `userstatistics` */

DROP TABLE IF EXISTS `userstatistics`;

CREATE TABLE `userstatistics` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `deviceID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `company` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patientID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最后上传时间',
  `statisticsTime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '统计时间',
  `nodataDays` int(10) DEFAULT NULL COMMENT '没数据天数',
  `companyName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司名',
  `teamName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班组名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `usertbl` */

DROP TABLE IF EXISTS `usertbl`;

CREATE TABLE `usertbl` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `deviceID` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '设备编号',
  `patientID` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
  `deviceType` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '设备类型',
  `appType` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用类型，多个之间以分号分隔',
  `deviceUseFlag` varchar(100) COLLATE utf8_unicode_ci DEFAULT '1' COMMENT '1 正常使用, 0 停用',
  `company` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位代号',
  `pname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `teamName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班组名',
  `companyName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isActivate` varchar(10) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '0 未激活，1 已激活',
  `lastTime` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最后一次上传数据时间',
  `modifyTime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户信息最新修改时间',
  `ywId` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户在业务系统的id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_usertbl_diviceid` (`deviceID`),
  UNIQUE KEY `userId` (`ywId`),
  KEY `index_usertbl_patientid` (`patientID`),
  KEY `index_usertbl_company` (`company`),
  KEY `index_usertbl_useflag` (`deviceUseFlag`)
) ENGINE=InnoDB AUTO_INCREMENT=3248 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `weight` */

DROP TABLE IF EXISTS `weight`;

CREATE TABLE `weight` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `deviceID` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `dataType` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据类型',
  `appType` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '应用类型',
  `pname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `sendFlag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '发送标识',
  `receiveTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '接收时间',
  `realTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '数据真实时间',
  `sendTime` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '转发时间',
  `dataValue` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '数据内容',
  `WSJK_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚健康发送标识',
  `WSYD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚运动发送标识',
  `WSXHH_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心呵护发送标识',
  `WSSM_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚睡眠发送标识',
  `WSXD_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '我尚心电发送标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!50106 set global event_scheduler = 1*/;

/* Event structure for event `deviceUseStatus` */

/*!50106 DROP EVENT IF EXISTS `deviceUseStatus`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `deviceUseStatus` ON SCHEDULE EVERY 1 DAY STARTS '2013-10-28 05:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
CALL deviceUseStatus();
END */$$
DELIMITER ;

/* Event structure for event `query_reset_deviceID` */

/*!50106 DROP EVENT IF EXISTS `query_reset_deviceID`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `query_reset_deviceID` ON SCHEDULE EVERY 1 DAY STARTS '2013-09-27 06:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
CALL query_reset_deviceID();
END */$$
DELIMITER ;

/* Event structure for event `query_unupload_deviceID` */

/*!50106 DROP EVENT IF EXISTS `query_unupload_deviceID`*/;

DELIMITER $$

/*!50106 CREATE DEFINER=`root`@`localhost` EVENT `query_unupload_deviceID` ON SCHEDULE EVERY 1 DAY STARTS '2013-09-25 07:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
CALL query_unupload_deviceID();
END */$$
DELIMITER ;

/* Procedure structure for procedure `deviceUseStatus` */

/*!50003 DROP PROCEDURE IF EXISTS  `deviceUseStatus` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deviceUseStatus`()
BEGIN
	DECLARE var_deviceID VARCHAR(20);
	DECLARE done INT;
	DECLARE hasdata INT;
	DECLARE lastTime VARCHAR(20);
	DECLARE rs_cursor CURSOR FOR SELECT DISTINCT deviceID FROM usertbl WHERE deviceUseFlag='1';
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	OPEN rs_cursor;
	   cursor_loop:LOOP
	      FETCH rs_cursor INTO var_deviceID;
	      IF done=1 THEN
	          LEAVE cursor_loop;
	      END IF;
		UPDATE usertbl SET lastTime = (SELECT MAX(p.receiveTime) FROM packagedata p WHERE p.deviceID = var_deviceID) WHERE deviceID=var_deviceID;
	   END LOOP cursor_loop;
	CLOSE rs_cursor;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `query_reset_deviceID` */

/*!50003 DROP PROCEDURE IF EXISTS  `query_reset_deviceID` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `query_reset_deviceID`()
BEGIN
	DECLARE var_id INT(10);
	DECLARE done INT;
	DECLARE num INT;
	DECLARE rs_cursor CURSOR FOR SELECT DISTINCT id FROM packagedata p1 WHERE DATE(receiveTime)=DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND packageNum='8-3';
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	OPEN rs_cursor;
	   cursor_loop:LOOP
	      FETCH rs_cursor INTO var_id;
	      IF done=1 THEN
	          LEAVE cursor_loop;
	      END IF;
	      SELECT COUNT(1) INTO num FROM packagedata p1, packagedata p2 WHERE  p1.id=var_id  AND DATE(p2.receiveTime)=DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND p2.patientID=p1.patientID AND p2.packageNum='8-3'
			AND p1.receiveTime>=p2.receiveTime AND CONVERT(p1.totalSteps,SIGNED)<CONVERT(p2.totalSteps,SIGNED);
	      IF num>0 THEN 
	      INSERT INTO resetrecord(deviceID,company,patientID,receiveTime,totalSteps,packagedataID) SELECT p1.deviceID,p1.company,p1.patientID,p1.receiveTime,p1.totalSteps,p1.id FROM packagedata p1 WHERE p1.id=var_id;
	      END IF;
	   END LOOP cursor_loop;
	CLOSE rs_cursor;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `query_unupload_deviceID` */

/*!50003 DROP PROCEDURE IF EXISTS  `query_unupload_deviceID` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `query_unupload_deviceID`()
BEGIN
	DECLARE var_deviceID VARCHAR(20);
	DECLARE done INT;
	DECLARE lastTime VARCHAR(20);
	DECLARE rs_cursor CURSOR FOR SELECT DISTINCT deviceID FROM packagedata p1 ORDER BY p1.deviceID;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
	OPEN rs_cursor;
	   cursor_loop:LOOP
	      FETCH rs_cursor INTO var_deviceID;
	      IF done=1 THEN
	          LEAVE cursor_loop;
	      END IF;
	      SELECT MAX(p.receiveTime) INTO lastTime FROM packagedata p,usertbl u WHERE p.deviceID=var_deviceID AND u.deviceID=var_deviceID and u.deviceUseFlag='1';
		IF (lastTime IS NOT NULL AND (TO_DAYS(CURDATE())-TO_DAYS(lastTime))>2) THEN
			INSERT INTO userstatistics(deviceID,company,patientID,pname,companyName,teamName,lastTime) SELECT p.deviceID,u.company,u.patientID,u.pname,u.companyName,u.teamName,MAX(p.receiveTime) AS lastTime
				FROM usertbl u, packagedata p WHERE u.deviceID=var_deviceID AND p.deviceID=var_deviceID;
		END IF;
	   END LOOP cursor_loop;
	CLOSE rs_cursor;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
