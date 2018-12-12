-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: empadronamiento
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
-- Table structure for table `personas_propiedad_viviendas`
--

DROP TABLE IF EXISTS `personas_propiedad_viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personas_propiedad_viviendas` (
  `personas_idpersonas` int(11) NOT NULL,
  `viviendas_idviviendas` int(11) NOT NULL,
  PRIMARY KEY (`personas_idpersonas`,`viviendas_idviviendas`),
  KEY `fk_personas_has_viviendas_viviendas1_idx` (`viviendas_idviviendas`),
  KEY `fk_personas_has_viviendas_personas1_idx` (`personas_idpersonas`),
  CONSTRAINT `fk_personas_has_viviendas_personas1` FOREIGN KEY (`personas_idpersonas`) REFERENCES `personas` (`idpersonas`),
  CONSTRAINT `fk_personas_has_viviendas_viviendas1` FOREIGN KEY (`viviendas_idviviendas`) REFERENCES `viviendas` (`idviviendas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas_propiedad_viviendas`
--

LOCK TABLES `personas_propiedad_viviendas` WRITE;
/*!40000 ALTER TABLE `personas_propiedad_viviendas` DISABLE KEYS */;
INSERT INTO `personas_propiedad_viviendas` VALUES (1,1),(2,1),(1,2),(3,3),(4,4),(1,5),(5,6);
/*!40000 ALTER TABLE `personas_propiedad_viviendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 14:47:52
