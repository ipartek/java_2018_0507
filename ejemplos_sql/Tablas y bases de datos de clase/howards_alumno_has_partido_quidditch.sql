-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: howards
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
-- Table structure for table `alumno_has_partido_quidditch`
--

DROP TABLE IF EXISTS `alumno_has_partido_quidditch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno_has_partido_quidditch` (
  `alumno_id` int(11) NOT NULL,
  `partido_quidditch_id` int(11) NOT NULL,
  PRIMARY KEY (`alumno_id`,`partido_quidditch_id`),
  KEY `fk_alumno_has_partido_quidditch_partido_quidditch1_idx` (`partido_quidditch_id`),
  KEY `fk_alumno_has_partido_quidditch_alumno1_idx` (`alumno_id`),
  CONSTRAINT `fk_alumno_has_partido_quidditch_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  CONSTRAINT `fk_alumno_has_partido_quidditch_partido_quidditch1` FOREIGN KEY (`partido_quidditch_id`) REFERENCES `partido_quidditch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_partido_quidditch`
--

LOCK TABLES `alumno_has_partido_quidditch` WRITE;
/*!40000 ALTER TABLE `alumno_has_partido_quidditch` DISABLE KEYS */;
INSERT INTO `alumno_has_partido_quidditch` VALUES (1,1),(2,1),(4,1),(5,1),(6,1),(1,2),(2,2),(3,2),(3,3),(7,3),(4,4),(5,4),(6,4),(7,4);
/*!40000 ALTER TABLE `alumno_has_partido_quidditch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 16:59:40
