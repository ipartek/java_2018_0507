-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taller_mecanico
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
-- Table structure for table `vehiculo_has_trabajadores`
--

DROP TABLE IF EXISTS `vehiculo_has_trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculo_has_trabajadores` (
  `Vehiculo_bastidor` varchar(17) NOT NULL,
  `Trabajadores_idTrabajador` int(11) NOT NULL,
  `Trabajadores_tipos_trabajadores_idtipos_trabajadores` int(11) NOT NULL,
  PRIMARY KEY (`Vehiculo_bastidor`,`Trabajadores_idTrabajador`,`Trabajadores_tipos_trabajadores_idtipos_trabajadores`),
  KEY `fk_Vehiculo_has_Trabajadores_Trabajadores1_idx` (`Trabajadores_idTrabajador`,`Trabajadores_tipos_trabajadores_idtipos_trabajadores`),
  KEY `fk_Vehiculo_has_Trabajadores_Vehiculo1_idx` (`Vehiculo_bastidor`),
  CONSTRAINT `fk_Vehiculo_has_Trabajadores_Trabajadores1` FOREIGN KEY (`Trabajadores_idTrabajador`, `Trabajadores_tipos_trabajadores_idtipos_trabajadores`) REFERENCES `trabajadores` (`idtrabajador`, `tipos_trabajadores_idtipos_trabajadores`),
  CONSTRAINT `fk_Vehiculo_has_Trabajadores_Vehiculo1` FOREIGN KEY (`Vehiculo_bastidor`) REFERENCES `vehiculo` (`bastidor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo_has_trabajadores`
--

LOCK TABLES `vehiculo_has_trabajadores` WRITE;
/*!40000 ALTER TABLE `vehiculo_has_trabajadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo_has_trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 14:47:51
