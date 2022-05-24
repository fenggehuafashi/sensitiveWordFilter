-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `topic_id` bigint unsigned NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (2,18477318,2,'上海疫情不作为 政府失职 干你妈','2022-05-24 17:00:00'),(5,18477319,2,'人在上海的外地人表示，很难。目前，这个状况，已躺宿舍74天，没活干，没钱挣，。目前，发的物资有，每人一箱桶装方便面，三包挂面，一小包榨菜，四包脆皮肠，一包十斤的大米，想尽办法去弄吃的。开车回家的话，需要两遍证明，老家那块明确不接收，这边根本不知道找哪里开，坐火车的话，各种中转，票也很难抢。老板为了省钱，让我们住在一个厂房隔的违规宿舍里，现在连门都不能随意开，有人会检查。','2022-05-21 15:59:11'),(9,18477317,3,'我建议所有的企业、个人都密切关注国际形势，做好相关的预案，特别是当一和二的努力失败时，及时切割。\r\n\r\n我可是提前告诉你们了的，还有，不要以为新加坡等中立国在一和二的努力失败时能够独善其身、保持“中立”。\r\n\r\n不要把财产身家性命全部放在新加坡。\r\n\r\n\r\n\r\n这些独立于其他走向之外，算独立的因素。\r\n\r\n发展中国家和发达国家中还有一些地区性强国，它们也不满现有的国际秩序，可以利用。\r\n\r\n我记得在霍尔木兹海峡美军和伊朗军队隔着海峡相望。\r\n\r\n土耳其也不满意，总之地区性强国都是可能的盟友。\r\n\r\n法国、俄国不满意美国在欧洲。','2022-05-24 18:34:29'),(10,18477317,2,'上海这几年心心念念的是当“金融中心”，过去上海骄傲的中国高科技和产业中心的桂冠他们不是很感冒了。','2022-05-24 18:42:39'),(11,18477318,3,'\r\n       之前在上海生活了四年，期间离开了一年多，今年三月份又回到了这里临时做业务。 公司给我租的是公寓双床的，还有另外一个同事一起住。在上海发布4月1日期到5日封城的时候，我自己在携程定了5天的酒店，想一个人隔离五天安静一些，好方便和爱人视频语音。 物资也准备了一周的量。','2022-05-24 19:07:24'),(12,18477318,1,'前些年，日本福岛地震后，周边企业停产。重庆一些要死不活的机械厂有人冒生命危险以福岛为圆心，挨家挨户做工作买技术，邀入股....吸引了一大批日本熟练工人，结果莫名其妙催生重庆的一些精密制造产业，并且抢了日本人的国际市场。其中有个仇日的东北老板，引进当年，这批日籍员工给他带来丰厚利润，让他乐开了花，变得不那么仇日了，再也不见他满眼怒火朗声高唱《我的家住在东北松花江上》的场景。产业升级这个命题很大，但我的确看到那些贪得无厌的老板们自发的为了中国产业升级挖空心思，反正有国家政策刺激，他们到处挖人挖技术挖市场，闷声发大财!最近这群人经常鬼鬼祟祟的在以色列和美国闲逛，鬼知道他们又想干点什么。\r\n','2022-05-24 19:58:33'),(16,18477318,1,'2003年我去新加坡探亲都是带的苹果，当季的芸豆，芸豆干，内衣裤这类农贸和初级工业品。背回来的是手持吸尘器，笔记本电脑，品牌电动工具这些工业品。今年是2019年，这个月接待俩外国友人来中国，除了旅游纪念品，买的最多的是科技产品带回国……买了3个华为手机，1个红米手机，6个U盘和两个硬盘，三个内存条，大疆的灵眸，没买无人机，因为德国不让飞……但是租了一个玩了个爽。给我带了三包饼干……巧克力味的……还挺好吃的。\r\n','2022-05-24 20:01:01'),(21,18477317,1,'dshit shit','2022-05-24 20:28:17'),(22,18477317,1,'shit\r\n','2022-05-24 20:28:48');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `topic_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(100) DEFAULT '',
  `creater_id` bigint unsigned DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'中国经济',18477317,'2022-05-23 16:06:00'),(2,'上海疫情',18477318,'2022-05-23 16:07:00'),(3,'全球局势',18477319,'2022-05-23 16:08:00');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'user:allow' COMMENT 'shiro 权限管理',
  `violation` tinyint unsigned DEFAULT '0' COMMENT '违规次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18477326 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (18477317,'刘志强','123456','user:allow',0),(18477318,'侯鑫宇','123456','user:allow',2),(18477319,'小黑','123456','user:ban',10);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'community'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24 20:48:53
