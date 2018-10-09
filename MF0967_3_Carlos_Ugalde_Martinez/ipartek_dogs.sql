-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ipartek
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dogs`
--

DROP TABLE IF EXISTS `dogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `edad` int(2) NOT NULL,
  `raza` varchar(45) NOT NULL,
  `chip` varchar(12) NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `peso` double NOT NULL,
  `apadrinado` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogs`
--

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;
INSERT INTO `dogs` VALUES (1,'Dolby',5,'Surround','11-1111-2013',22.7,22.8,5.3,1),(2,'Ford',5,'Fiesta','11-1111-2013',22.7,22.8,5.3,1),(3,'Mustang',5,'Coupe','11-1111-2013',22.7,22.8,5.3,1),(4,'a',2,'GAto','11-1111-2018',11,11,2.2,1),(5,'Porsche',2,'Cayenne','11-1111-2018',11,11,34,1),(6,'William',3,'GAto','11-1111-2018',11,11,2.2,1),(7,'nanan',3,'GAto','11-1111-2018',11,11,34,1),(8,'Autor: a',2,'Cayenne','11-1111-2018',11,11,2.2,1),(9,'asfsasaf',2,'GAto','11-1111-2018',11,11,34,1),(10,'Marramiau',2,'Grey','AA-AAAA-2018',23,23,32,2),(11,'William',3,'Alien','11-1111-2018',23,23,2.2,1),(12,'gato',2,'Alien','AA-AAAA-2018',11,32,34,2),(13,'nanan',2,'Grey','11-1111-2018',23,32,2.2,1),(14,'nanan',2,'Grey','11-1111-2018',23,32,2.2,1),(15,'a',44,'Grey','AA-AAAA-2018',23,32,34,2),(16,'Xenomorph',3,'','AA-AAAA-2018',32,32,2.2,2),(17,'Xenomorfo',45,'milrazas','AA-AAAA-2018',11,11,3,1);
/*!40000 ALTER TABLE `dogs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-09  8:28:14
