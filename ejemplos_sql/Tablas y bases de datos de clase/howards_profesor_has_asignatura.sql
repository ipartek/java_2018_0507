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
-- Table structure for table `profesor_has_asignatura`
--

DROP TABLE IF EXISTS `profesor_has_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor_has_asignatura` (
  `profesor_id` int(11) NOT NULL,
  `asignatura_id` int(11) NOT NULL,
  `anio` int(4) NOT NULL,
  PRIMARY KEY (`profesor_id`,`anio`),
  KEY `fk_profesor_has_asignatura_asignatura1_idx` (`asignatura_id`),
  KEY `fk_profesor_has_asignatura_profesor1_idx` (`profesor_id`),
  KEY `anio` (`anio`),
  CONSTRAINT `fk_profesor_has_asignatura_asignatura1` FOREIGN KEY (`asignatura_id`) REFERENCES `asignatura` (`id`),
  CONSTRAINT `fk_profesor_has_asignatura_profesor1` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_has_asignatura`
--

LOCK TABLES `profesor_has_asignatura` WRITE;
/*!40000 ALTER TABLE `profesor_has_asignatura` DISABLE KEYS */;
INSERT INTO `profesor_has_asignatura` VALUES (1,1,2015),(1,1,2016),(1,1,2017),(6,2,2017),(3,4,2014),(3,4,2017),(2,5,2017),(7,5,2014),(5,6,2017),(7,6,2016),(2,7,2016),(7,7,2017);
/*!40000 ALTER TABLE `profesor_has_asignatura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 16:59:42
