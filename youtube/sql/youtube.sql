-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: youtube
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
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comentarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_videos` int(11) NOT NULL,
  `id_usuarios` int(11) NOT NULL,
  `texto` text NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comentarios_videos1_idx` (`id_videos`),
  KEY `fk_comentarios_usuarios1_idx` (`id_usuarios`),
  CONSTRAINT `fk_comentarios_usuarios1` FOREIGN KEY (`id_usuarios`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_comentarios_videos1` FOREIGN KEY (`id_videos`) REFERENCES `videos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (1,11,2,'Este video está de p*** madre','2018-10-23 08:00:00'),(2,11,1,'Qué dices, es más malo que la peste','2018-10-23 08:01:00'),(3,12,1,'No entiendo como nadie ha comentado esta maravilla de video','2018-10-22 00:00:00'),(4,11,1,'Y una m****. Mola un montón y tú eres un p*** g******** de m******','2018-10-23 08:15:00'),(5,11,1,'Admin es tonto... JAJAJAJAJAJA','2018-10-23 08:50:41'),(6,11,1,'Admin es tonto... JAJAJAJAJAJA','2018-10-23 08:52:55');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'javier@email.com','yepa'),(2,'admin@email.com','nuevapassword');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_puntua_videos`
--

DROP TABLE IF EXISTS `usuarios_puntua_videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios_puntua_videos` (
  `usuarios_id` int(11) NOT NULL,
  `videos_id` int(11) NOT NULL,
  `puntuacion` tinyint(4) NOT NULL,
  PRIMARY KEY (`usuarios_id`,`videos_id`),
  KEY `fk_usuarios_has_videos_videos1_idx` (`videos_id`),
  KEY `fk_usuarios_has_videos_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_usuarios_has_videos_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_usuarios_has_videos_videos1` FOREIGN KEY (`videos_id`) REFERENCES `videos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_puntua_videos`
--

LOCK TABLES `usuarios_puntua_videos` WRITE;
/*!40000 ALTER TABLE `usuarios_puntua_videos` DISABLE KEYS */;
INSERT INTO `usuarios_puntua_videos` VALUES (1,11,3),(1,12,1),(2,11,5),(2,12,5);
/*!40000 ALTER TABLE `usuarios_puntua_videos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idvideo` char(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USUARIOS_idx` (`id_usuario`),
  KEY `ID_VIDEOS_idx` (`idvideo`),
  CONSTRAINT `FK_USUARIOS` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (11,'-J4RP7JjqPI','Keith Emerson Band Marche Train',2),(12,'30U5Uyg2Wp8','Keith Emerson Band Nutcracker',1),(14,'vpIduDaggVA','YES Owner of a Lonely Heart',1),(15,'zKjpsDbZrtQ','Arizona Sunshine doblaje',1);
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-23 12:02:22
