-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hogwarts
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
-- Table structure for table `alumno_has_asignatura`
--

DROP TABLE IF EXISTS `alumno_has_asignatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno_has_asignatura` (
  `alumno_id` int(11) NOT NULL,
  `asignatura_id` int(11) NOT NULL,
  `anio` int(4) NOT NULL DEFAULT '0',
  `nota` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alumno_id`,`asignatura_id`,`anio`),
  KEY `fk_alumno_has_asignatura_asignatura1_idx` (`asignatura_id`),
  KEY `fk_alumno_has_asignatura_alumno1_idx` (`alumno_id`),
  KEY `anio` (`anio`),
  CONSTRAINT `fk_alumno_has_asignatura_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  CONSTRAINT `fk_alumno_has_asignatura_asignatura1` FOREIGN KEY (`asignatura_id`) REFERENCES `asignatura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_has_asignatura`
--

LOCK TABLES `alumno_has_asignatura` WRITE;
/*!40000 ALTER TABLE `alumno_has_asignatura` DISABLE KEYS */;
INSERT INTO `alumno_has_asignatura` VALUES (1,1,2016,9),(1,1,2017,6),(1,2,2016,9),(1,2,2017,8),(1,3,2016,9),(1,3,2017,4),(1,4,2016,9),(1,4,2017,6),(1,6,2017,8),(1,7,2016,9),(1,7,2017,7),(2,2,2016,5),(2,2,2017,6),(2,3,2016,4),(2,3,2017,9),(2,4,2016,9),(2,4,2017,5),(2,5,2016,5),(2,5,2017,9),(2,6,2016,5),(2,6,2017,5),(3,1,2016,4),(3,1,2017,5),(3,2,2016,4),(3,2,2017,9),(3,4,2016,4),(3,4,2017,6),(3,6,2016,4),(3,6,2017,9),(3,7,2016,4),(3,7,2017,5),(4,2,2016,4),(4,2,2017,3),(4,3,2016,8),(4,3,2017,10),(4,4,2016,7),(4,4,2017,2),(4,5,2016,8),(4,5,2017,3),(4,7,2016,7),(4,7,2017,2),(5,1,2017,5),(5,2,2017,5),(5,3,2017,5),(5,4,2017,5),(5,5,2017,5),(6,1,2017,0),(6,2,2017,0),(6,3,2017,0),(6,4,2017,0),(6,5,2017,0),(7,1,2015,10),(7,1,2016,1),(7,1,2017,4),(7,2,2015,10),(7,2,2016,1),(7,2,2017,5),(7,3,2015,10),(7,3,2016,1),(7,3,2017,10),(7,4,2015,10),(7,4,2016,1),(7,4,2017,4),(7,5,2015,10),(7,5,2016,1),(7,5,2017,6),(7,6,2015,10),(7,6,2016,1),(7,6,2017,10),(7,7,2015,10),(7,7,2016,1),(7,7,2017,10);
/*!40000 ALTER TABLE `alumno_has_asignatura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 14:47:31
