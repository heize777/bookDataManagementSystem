-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `isbn` varchar(17) DEFAULT NULL,
  `publication_year` int DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'活着','余华','9787020042415',1993,'人民文学出版社',25.00),(2,'追风筝的人','卡勒德·胡赛尼','9787530211459',2003,'北京十月文艺出版社',29.90),(3,'解忧杂货店','东野圭吾','9787539995720',2014,'江苏文艺出版社',32.80),(4,'百年孤独','加西亚·马尔克斯','9787532753686',1967,'上海译文出版社',45.00),(5,'小王子','安东尼·德·圣-埃克苏佩里','9787530107429',1942,'北京十月文艺出版社',20.00),(6,'围城','钱钟书','9787530204372',1947,'人民文学出版社',28.00),(7,'三体','刘慈欣','9787539189295',2006,'重庆出版社',35.00),(8,'白夜行','东野圭吾','9787539947911',1997,'南海出版公司',38.00),(9,'解忧杂货店（新版）','东野圭吾','9787559624730',2018,'南海出版公司',39.80),(10,'人间词话','王国维','9787544725564',1908,'译林出版社',22.00),(11,'平凡的世界','路遥','9787020050500',1986,'人民文学出版社',45.00),(12,'局外人','阿尔贝·加缪','9787532736470',1942,'上海译文出版社',25.00),(13,'无声告白','伍绮诗','9787539995904',2015,'江苏凤凰文艺出版社',30.00),(14,'一句顶一万句','刘震云','9787539959703',2009,'江苏文艺出版社',36.00),(16,'天才与疯子','李白','1234343',2000,'北京出版社',30.00);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `user_pic` text,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin123','admin123','鲍勃','E:\\vueProjects\\vue-bookManagement\\src\\assets\\ae0cb8c0971b481e8679610e026940ec.png','2024-06-08 22:18:32'),(2,'admin1','admin1','czj','E:\\vueProjects\\vue-bookManagement\\src\\assets\\00eab579d87a45a69499b036ddc8418b.png','2024-06-09 17:05:10'),(3,'admin12','admin12','杜甫','E:\\vueProjects\\vue-bookManagement\\src\\assets\\c15a203c5b0544e695c0f27f251b03a7.png','2024-06-09 17:10:14'),(4,'admin1234','admin1234',NULL,NULL,'2024-06-09 17:16:02');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-10 15:13:01
