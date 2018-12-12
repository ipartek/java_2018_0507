-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alojamientos_rurales
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
-- Table structure for table `alojamientos_has_actividades`
--

DROP TABLE IF EXISTS `alojamientos_has_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alojamientos_has_actividades` (
  `Alojamientos_id` int(11) NOT NULL,
  `Actividades_idActividades` int(11) NOT NULL,
  `dia_semana` varchar(10) NOT NULL,
  PRIMARY KEY (`Alojamientos_id`,`Actividades_idActividades`),
  KEY `fk_Alojamientos_has_Actividades_Actividades1_idx` (`Actividades_idActividades`),
  KEY `fk_Alojamientos_has_Actividades_Alojamientos1_idx` (`Alojamientos_id`),
  CONSTRAINT `fk_Alojamientos_has_Actividades_Actividades1` FOREIGN KEY (`Actividades_idActividades`) REFERENCES `actividades` (`idactividades`),
  CONSTRAINT `fk_Alojamientos_has_Actividades_Alojamientos1` FOREIGN KEY (`Alojamientos_id`) REFERENCES `alojamientos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamientos_has_actividades`
--

LOCK TABLES `alojamientos_has_actividades` WRITE;
/*!40000 ALTER TABLE `alojamientos_has_actividades` DISABLE KEYS */;
INSERT INTO `alojamientos_has_actividades` VALUES (1,1,'Lunes'),(1,2,'Martes'),(2,1,'Martes'),(3,1,'Viernes'),(3,3,'Jueves');
/*!40000 ALTER TABLE `alojamientos_has_actividades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 14:47:45
