-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: incidencias
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
-- Table structure for table `incidencia`
--

DROP TABLE IF EXISTS `incidencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `incidencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `usuario_creador` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `equipo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `usuario_asignado` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencia`
--

LOCK TABLES `incidencia` WRITE;
/*!40000 ALTER TABLE `incidencia` DISABLE KEYS */;
INSERT INTO `incidencia` VALUES (1,'2018-01-02 00:00:00','usuariodsf','titulodsf','descripciondfs','equipo1sdaf','1dsf'),(2,'2017-03-02 00:00:00','yoyofsadfsdf','dsdssdfasd','sadafsdf','equipo2dsfds','1'),(3,'2017-03-02 00:00:00','yoyo','dsds','sada','equipo3','1'),(4,'2018-03-02 00:00:00','Usuario1','Titulo1','Descripcion1','equipo4','1'),(5,'2018-03-02 00:00:00','Usuario1','Titulo1','Descripcion1','equipo5','1'),(6,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo6','1'),(7,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo7','1'),(8,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo8','1'),(9,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo9','1'),(10,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo10','1'),(11,'2017-03-02 00:00:00','Usuario1','incidencia primera','algo se ha rotp','equipo11','1'),(12,'2017-03-02 00:00:00','ana','anatitu','anadksjf','anaequip','45345'),(13,'2018-08-02 00:00:00','yoyo','adsf','descripciodsfdsafsfdn','equipo','1ss'),(14,'2018-08-02 00:00:00','sad','titulo12','descripciodsfdsafsfdn','fds','yo1');
/*!40000 ALTER TABLE `incidencia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 14:47:34
