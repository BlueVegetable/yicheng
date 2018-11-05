/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.53 : Database - blue14
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blue14` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blue14`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values (1,'root','e10adc3949ba59abbe56e057f20f883e'),(2,'孙悟空','e10adc3949ba59abbe56e057f20f883e'),(5,'里件','e10adc3949ba59abbe56e057f20f883e'),(6,'神奇','e10adc3949ba59abbe56e057f20f883e'),(7,'是金时','e10adc3949ba59abbe56e057f20f883e'),(8,'高热','e10adc3949ba59abbe56e057f20f883e'),(9,'行国','e10adc3949ba59abbe56e057f20f883e'),(10,'理处出','e10adc3949ba59abbe56e057f20f883e'),(11,'是事','e10adc3949ba59abbe56e057f20f883e'),(12,'水得','e10adc3949ba59abbe56e057f20f883e'),(13,'对回','e10adc3949ba59abbe56e057f20f883e'),(14,'这性','e10adc3949ba59abbe56e057f20f883e'),(15,'所先','e10adc3949ba59abbe56e057f20f883e'),(16,'说心个','e10adc3949ba59abbe56e057f20f883e'),(17,'作第着','e10adc3949ba59abbe56e057f20f883e'),(18,'们意','e10adc3949ba59abbe56e057f20f883e'),(19,'发民','e10adc3949ba59abbe56e057f20f883e'),(20,'加知人','e10adc3949ba59abbe56e057f20f883e'),(21,'我平','e10adc3949ba59abbe56e057f20f883e'),(22,'机区','e10adc3949ba59abbe56e057f20f883e'),(23,'成数','e10adc3949ba59abbe56e057f20f883e'),(24,'也总','e10adc3949ba59abbe56e057f20f883e'),(25,'种生党','e10adc3949ba59abbe56e057f20f883e'),(26,'是地','e10adc3949ba59abbe56e057f20f883e'),(27,'物活学','e10adc3949ba59abbe56e057f20f883e'),(28,'分回得','e10adc3949ba59abbe56e057f20f883e'),(29,'法根正','e10adc3949ba59abbe56e057f20f883e'),(30,'当保三','e10adc3949ba59abbe56e057f20f883e'),(31,'用结','e10adc3949ba59abbe56e057f20f883e'),(32,'电如','e10adc3949ba59abbe56e057f20f883e'),(33,'当又立','e10adc3949ba59abbe56e057f20f883e'),(34,'现自九','e10adc3949ba59abbe56e057f20f883e'),(35,'以油','e10adc3949ba59abbe56e057f20f883e'),(36,'十以','e10adc3949ba59abbe56e057f20f883e'),(37,'对的些','e10adc3949ba59abbe56e057f20f883e'),(38,'理老面','e10adc3949ba59abbe56e057f20f883e'),(39,'动作正','e10adc3949ba59abbe56e057f20f883e'),(40,'电公','e10adc3949ba59abbe56e057f20f883e'),(41,'之第','e10adc3949ba59abbe56e057f20f883e'),(42,'加民前','e10adc3949ba59abbe56e057f20f883e'),(43,'力物长','e10adc3949ba59abbe56e057f20f883e'),(44,'中面接','e10adc3949ba59abbe56e057f20f883e'),(45,'说年本','e10adc3949ba59abbe56e057f20f883e'),(46,'如心的','e10adc3949ba59abbe56e057f20f883e'),(47,'来求','e10adc3949ba59abbe56e057f20f883e'),(48,'不规资','e10adc3949ba59abbe56e057f20f883e'),(49,'定要或','e10adc3949ba59abbe56e057f20f883e'),(50,'作常','e10adc3949ba59abbe56e057f20f883e'),(51,'行人','e10adc3949ba59abbe56e057f20f883e'),(52,'家此性','e10adc3949ba59abbe56e057f20f883e'),(53,'国动七','e10adc3949ba59abbe56e057f20f883e'),(54,'化地','e10adc3949ba59abbe56e057f20f883e'),(55,'主建被','e10adc3949ba59abbe56e057f20f883e'),(56,'一干先','e10adc3949ba59abbe56e057f20f883e'),(57,'生常样','e10adc3949ba59abbe56e057f20f883e'),(58,'经合其','e10adc3949ba59abbe56e057f20f883e'),(59,'种思又','e10adc3949ba59abbe56e057f20f883e'),(60,'时会级','e10adc3949ba59abbe56e057f20f883e'),(61,'起边建','e10adc3949ba59abbe56e057f20f883e'),(62,'当接','e10adc3949ba59abbe56e057f20f883e'),(63,'在认','e10adc3949ba59abbe56e057f20f883e'),(64,'成料现','e10adc3949ba59abbe56e057f20f883e'),(65,'都能度','e10adc3949ba59abbe56e057f20f883e'),(66,'就组','e10adc3949ba59abbe56e057f20f883e'),(67,'可利被','e10adc3949ba59abbe56e057f20f883e'),(68,'下发','e10adc3949ba59abbe56e057f20f883e'),(69,'生直','e10adc3949ba59abbe56e057f20f883e'),(70,'经相地','e10adc3949ba59abbe56e057f20f883e'),(71,'中了','e10adc3949ba59abbe56e057f20f883e'),(72,'来并你','e10adc3949ba59abbe56e057f20f883e'),(73,'地各阶','e10adc3949ba59abbe56e057f20f883e'),(74,'度三已','e10adc3949ba59abbe56e057f20f883e'),(75,'主此','e10adc3949ba59abbe56e057f20f883e'),(76,'来期','e10adc3949ba59abbe56e057f20f883e'),(77,'动那六','e10adc3949ba59abbe56e057f20f883e'),(78,'分见','e10adc3949ba59abbe56e057f20f883e'),(79,'水使','e10adc3949ba59abbe56e057f20f883e'),(80,'十都义','e10adc3949ba59abbe56e057f20f883e'),(81,'人将','e10adc3949ba59abbe56e057f20f883e'),(82,'起又头','e10adc3949ba59abbe56e057f20f883e'),(83,'都放两','e10adc3949ba59abbe56e057f20f883e'),(84,'的面多','e10adc3949ba59abbe56e057f20f883e'),(85,'之图联','e10adc3949ba59abbe56e057f20f883e'),(86,'物结位','e10adc3949ba59abbe56e057f20f883e'),(87,'从外','e10adc3949ba59abbe56e057f20f883e'),(88,'也月程','e10adc3949ba59abbe56e057f20f883e'),(89,'本线','e10adc3949ba59abbe56e057f20f883e'),(90,'经老','e10adc3949ba59abbe56e057f20f883e'),(91,'在做解','e10adc3949ba59abbe56e057f20f883e'),(92,'化百地','e10adc3949ba59abbe56e057f20f883e'),(93,'加两','e10adc3949ba59abbe56e057f20f883e'),(94,'地我点','e10adc3949ba59abbe56e057f20f883e'),(95,'这水因','e10adc3949ba59abbe56e057f20f883e'),(96,'说七总','e10adc3949ba59abbe56e057f20f883e'),(97,'时五','e10adc3949ba59abbe56e057f20f883e'),(98,'可以','e10adc3949ba59abbe56e057f20f883e'),(99,'家运南','e10adc3949ba59abbe56e057f20f883e'),(100,'人现看','e10adc3949ba59abbe56e057f20f883e');

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `lastModify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(30) NOT NULL,
  `adminID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  KEY `adminID` (`adminID`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`adminID`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`,`lastModify`,`type`,`adminID`) values (1,'第一篇','第一篇的内容','2018-08-26 19:44:37','0',1),(4,'试验品2','内容','2018-08-27 00:16:07','0',NULL),(5,'试验品2','好玩不好玩？','2018-09-02 23:35:03','0',1),(6,'试验品3','<p>另一个内容,是吗?</p>','2018-08-30 21:22:22','0',1),(7,'Hello World','<p>1阿达是否</p>','2018-08-30 13:53:15','0',1),(8,'10','<p>预防系统功能</p>','2018-08-30 13:55:33','10',1),(9,'2','<p>是师弟</p>','2018-08-30 13:57:00','1',1),(10,'1','<p><strong>标题：</strong><br/></p><p>傻逼之王</p><p style=\"text-align: center;\"><img src=\"/studio1_view/upload/image/20180830/1535636562948012545.jpg\" title=\"1535636562948012545.jpg\" alt=\"1.jpg\" width=\"456\" height=\"223\"/></p><p>下一页就没有了</p><p>哦？<img src=\"http://img.baidu.com/hi/jx2/j_0009.gif\"/></p>','2018-08-30 22:21:57','0',1),(11,'图片试验','<p><img src=\"http://localhost:80/upload/ueditor/image/1535954859039-1244994524-2147483647.jpeg\" title=\"1535954859039-1244994524-2147483647.jpeg\" alt=\"1535954859039-1244994524-2147483647.jpeg\" width=\"621\" height=\"318\"/></p>','2018-09-03 14:08:08','0',1),(12,'立华奏','<p><img src=\"http://localhost/upload/ueditor/image/1540986712114-2105116531-2147483647.jpeg\" title=\"1540986712114-2105116531-2147483647.jpeg\" alt=\"1540986712114-2105116531-2147483647.jpeg\" width=\"300\" height=\"296\"/></p><p>立华奏</p>','2018-10-31 19:52:11','1',1),(13,'Hello World1','<p><img src=\"http://localhost/upload/ueditor/image/1540987990787-1587099456-2147483647.png\" title=\"1540987990787-1587099456-2147483647.png\" alt=\"1540987990787-1587099456-2147483647.png\" width=\"280\" height=\"288\"/></p><p>炮姐赛高</p>','2018-10-31 20:15:49','采访记',1);

/*Table structure for table `article_type` */

DROP TABLE IF EXISTS `article_type`;

CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `article_type` */

insert  into `article_type`(`id`,`type`) values (1,'小说'),(2,'散文'),(3,'散文诗'),(4,'戏曲'),(5,'剧本'),(6,'诗歌'),(7,'寓言'),(8,'童话'),(9,'科幻故事'),(10,'议论文'),(11,'说明文'),(12,'记叙文'),(13,'书信'),(14,'启事'),(15,'合同'),(16,'广告'),(17,'座谈会纪要'),(18,'声明'),(19,'日记'),(20,'说明书'),(21,'报告'),(22,'总结'),(23,'摘要'),(24,'演讲辞'),(25,'辩论辞'),(26,'简章'),(27,'简报'),(28,'序'),(29,'采访记'),(30,'BBS'),(31,'广播');

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
  `path` varchar(500) NOT NULL COMMENT '轮播图路径',
  `visible` tinyint(1) DEFAULT '1' COMMENT '轮播图是否为可视(0为不显示,1为显示)',
  `position` int(11) NOT NULL COMMENT '轮播图的播放位置',
  `type` varchar(50) DEFAULT NULL COMMENT '轮播图的类型',
  `url` varchar(300) DEFAULT '' COMMENT '轮播图跳转网址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `banner` */

insert  into `banner`(`id`,`path`,`visible`,`position`,`type`,`url`) values (35,'/banner-image/1539597585659-1267415429-2147483647.jpeg',1,1,'image/jpeg','');

/*Table structure for table `consult` */

DROP TABLE IF EXISTS `consult`;

CREATE TABLE `consult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `phoneNumber` varchar(24) NOT NULL COMMENT '手机号码',
  `state` int(11) DEFAULT '0' COMMENT '状态:0为未确认，1为已确认',
  `createTime` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `attribution` varchar(50) DEFAULT NULL COMMENT '手机号码归属地',
  `applyMethod` smallint(6) DEFAULT NULL COMMENT '报名方式',
  `origin` varchar(100) DEFAULT NULL COMMENT '来源',
  `academy` int(10) DEFAULT NULL COMMENT '院校',
  `profession` int(5) DEFAULT NULL COMMENT '专业',
  `level` smallint(5) DEFAULT NULL COMMENT '报考层次',
  `type` smallint(5) DEFAULT NULL COMMENT '类别',
  `currentEducation` int(11) DEFAULT NULL COMMENT '目前学历',
  `age` smallint(6) DEFAULT NULL COMMENT '年龄',
  `securityTime` smallint(6) DEFAULT NULL COMMENT '社保年限',
  `workTime` smallint(6) DEFAULT NULL COMMENT '工作年限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `consult` */

insert  into `consult`(`id`,`name`,`phoneNumber`,`state`,`createTime`,`attribution`,`applyMethod`,`origin`,`academy`,`profession`,`level`,`type`,`currentEducation`,`age`,`securityTime`,`workTime`) values (2,'想本','13210632805',1,'2018-08-14 16:30:00','山东省日照市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'到头','13067329749',1,'2018-08-14 16:30:00','福建省福州市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'去人线','13520483679',1,'2018-08-14 16:30:00','北京省市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'七当','13946027978',1,'2018-08-14 16:30:00','黑龙江省哈尔滨市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'想五','15592437747',1,'2018-08-14 16:30:00','黑龙江省哈尔滨市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'广间','18884075710',1,'2018-08-14 16:30:00','四川省成都市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'地利通','1516368517',1,'2018-08-14 16:30:00','四川省成都市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'外过然','1858147971',1,'2018-08-14 16:30:01','四川省成都市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'非学','18921682964',1,'2018-08-28 16:30:01','江苏省南通市',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'神','15632248596',1,'2018-09-15 10:55:44','江苏省南通市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'神','15632248596',1,'2018-09-15 11:00:52','未知',4,'非首页',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'神','15632248596',1,'2018-09-15 11:00:52','江苏省南通市',1,'非首页',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'神','15632248596',1,'2018-09-15 12:19:08','未知',5,'非首页',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'神与神','13569962345',1,'2018-09-15 17:19:10','江苏省南通市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'神与神','13569962345',1,'2018-09-15 17:22:13','未知',2,NULL,NULL,0,NULL,NULL,0,NULL,NULL,NULL),(18,'神与神','13569962345',1,'2018-09-15 17:24:03','未知',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'神与神','15294236529',0,'2018-09-16 16:45:57','未知',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'神与神','15294236529',0,'2018-09-16 19:30:15','浙江省金华市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'青藏高原','13566952056',0,'2018-09-16 19:34:54','浙江省金华市',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'青藏高原','13566952056',0,'2018-09-16 20:14:46','浙江省金华市',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'青藏高原','13566952056',0,'2018-09-16 20:14:53','浙江省金华市',5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,NULL,'15322685423',0,'2018-09-26 21:19:35','未知',7,NULL,0,NULL,NULL,NULL,0,0,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
