CREATE DATABASE  IF NOT EXISTS `empadronamiento` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empadronamiento`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: empadronamiento
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
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `municipios` (
  `idmunicipios` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` char(3) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmunicipios`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,'BIL','Bilbao'),(2,'BAR','Barakaldo'),(3,'GET','Getxo');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personas` (
  `idpersonas` int(11) NOT NULL AUTO_INCREMENT,
  `habitar_vivienda_id` int(11) DEFAULT NULL,
  `empadronado_en_vivienda_id` int(11) NOT NULL,
  `dni` char(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) DEFAULT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersonas`),
  KEY `fk_personas_viviendas_idx` (`habitar_vivienda_id`),
  KEY `fk_personas_viviendas1_idx` (`empadronado_en_vivienda_id`),
  CONSTRAINT `fk_personas_viviendas` FOREIGN KEY (`habitar_vivienda_id`) REFERENCES `viviendas` (`idviviendas`),
  CONSTRAINT `fk_personas_viviendas1` FOREIGN KEY (`empadronado_en_vivienda_id`) REFERENCES `viviendas` (`idviviendas`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,1,1,'12345678Z','Nombre1','Apellido11','Apellido21'),(2,1,2,'23456789A','Nombre2','Apellido12','Apellido22'),(3,2,2,'34567890B','Nombre3','Apellido13','Apellido23'),(4,3,3,'45678901C','Nombre4','Apellido14','Apellido24'),(5,4,4,'56789012D','Nombre5','Apellido15','Apellido25'),(6,5,5,'67890123E','Nombre6','Apellido16','Apellido26');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `viviendas`
--

DROP TABLE IF EXISTS `viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `viviendas` (
  `idviviendas` int(11) NOT NULL AUTO_INCREMENT,
  `pertenece_municipio_id` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `numero` varchar(10) NOT NULL,
  PRIMARY KEY (`idviviendas`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_viviendas_municipios1_idx` (`pertenece_municipio_id`),
  CONSTRAINT `fk_viviendas_municipios1` FOREIGN KEY (`pertenece_municipio_id`) REFERENCES `municipios` (`idmunicipios`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viviendas`
--

LOCK TABLES `viviendas` WRITE;
/*!40000 ALTER TABLE `viviendas` DISABLE KEYS */;
INSERT INTO `viviendas` VALUES (1,1,'PRIMERA','Calle1','1'),(2,1,'SEGUNDO','Calle2','2'),(3,1,'TERCERA','Calle3','3'),(4,2,'CUARTO','Calle4','4'),(5,2,'CINCO','Calle5','5'),(6,3,'SEIS','Calle6','6');
/*!40000 ALTER TABLE `viviendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-16 10:25:55
