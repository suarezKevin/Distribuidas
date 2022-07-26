-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: empresa
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacto` (
  `id_contacto` int NOT NULL AUTO_INCREMENT,
  `apellido_contacto` varchar(255) NOT NULL,
  `cedula_contacto` varchar(255) NOT NULL,
  `contrasenia_contacto` varchar(255) NOT NULL,
  `direccion_contacto` varchar(255) NOT NULL,
  `nombre_contacto` varchar(255) NOT NULL,
  `telefono_contacto` varchar(255) NOT NULL,
  `usuario_contacto` varchar(255) NOT NULL,
  `sucursalpertenece_id_sucursal` int DEFAULT NULL,
  PRIMARY KEY (`id_contacto`),
  UNIQUE KEY `UK_ren7d99h8qmqhdf6p6oner16v` (`cedula_contacto`),
  UNIQUE KEY `UK_bpdy3l9h1sg2s6ju11xnuwi7s` (`usuario_contacto`),
  KEY `FK4mfjad7t1g72osjr4y2h90kxj` (`sucursalpertenece_id_sucursal`),
  CONSTRAINT `FK4mfjad7t1g72osjr4y2h90kxj` FOREIGN KEY (`sucursalpertenece_id_sucursal`) REFERENCES `sucursal` (`id_sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` VALUES (1,'sefe','1807','12345','nel','Maria','090909090','maria',1),(4,'TP','1801','12345','nel','Alex Ignacio','090909090','alex',1);
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `fecha_noti` datetime(6) NOT NULL,
  `sucursal_id_sucursal` int DEFAULT NULL,
  PRIMARY KEY (`id_notificacion`),
  KEY `FKl8e9nmd7mbl1fqktiv8eke0hs` (`sucursal_id_sucursal`),
  CONSTRAINT `FKl8e9nmd7mbl1fqktiv8eke0hs` FOREIGN KEY (`sucursal_id_sucursal`) REFERENCES `sucursal` (`id_sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
INSERT INTO `notificacion` VALUES (1,'2022-07-24 18:24:54.104000',NULL),(2,'2022-07-24 18:26:08.918000',NULL),(3,'2022-07-24 18:28:18.016000',NULL),(4,'2022-07-24 18:35:31.578000',1),(5,'2022-07-24 18:38:23.125000',1),(6,'2022-07-24 18:39:23.417000',1),(7,'2022-07-24 18:55:36.820000',1);
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `id_sucursal` int NOT NULL AUTO_INCREMENT,
  `ciudad_sucursal` varchar(255) NOT NULL,
  `direccion_sucursal` varchar(255) NOT NULL,
  `latitud_sucursal` varchar(255) NOT NULL,
  `longitud_sucursal` varchar(255) NOT NULL,
  `nombre_sucursal` varchar(255) NOT NULL,
  `provincia_sucursal` varchar(255) NOT NULL,
  `telefono_sucursal` varchar(255) NOT NULL,
  PRIMARY KEY (`id_sucursal`),
  UNIQUE KEY `UK_i96lbmqlyak3m3jo48de6m7rt` (`nombre_sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Ambato','BBB','090980','090980','BBB','Tungurahua','090980'),(3,'Ambato','AAAA','090980','090980','AAA','Tungurahua','090980');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-24 20:01:13
