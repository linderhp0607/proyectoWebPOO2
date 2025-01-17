CREATE DATABASE  IF NOT EXISTS `gestion_academica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestion_academica`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion_academica
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(60) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombres` varchar(60) NOT NULL,
  `telefono` varchar(60) NOT NULL,
  `aula_id` int DEFAULT NULL,
  `carrera` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKgmjuky8o7hx4nbdhg8jvspy0k` (`correo`),
  UNIQUE KEY `UKplf8ctke992i5j3vkkxyt80jc` (`dni`),
  KEY `FKs5n6nwno6l7x7b4deys01s510` (`aula_id`),
  CONSTRAINT `FKs5n6nwno6l7x7b4deys01s510` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (10,'paredes leiba','benito@gmail.com','campo verde','56784532','1995-01-22','pedrito','987654345',4,'derecho'),(11,'escobedo maitahuari','kike@gmail.com','yarina','67854326','2000-12-30','enrique','976453109',1,'medicina'),(12,'hidalgo pinedo','linderhidalgo@gmail.com','yarina','73791281','2002-07-06','linder','990407684',6,'ingenieria_sistemas'),(13,'lopez montalvan','lopez@gmail.com','manantay','67895462','2001-11-10','hector','949012437',2,'ingenieria_civil');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `turno` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'aula 1','mañana'),(2,'aula 2','mañana'),(4,'aula 4','tarde'),(6,'aula 7','tarde'),(7,'aula 8','mañana'),(8,'aula 10','mañana'),(9,'aula 11','tarde');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(60) NOT NULL,
  `area_especializacion` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nombres` varchar(60) NOT NULL,
  `telefono` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlqibfv3dna1e70n4h3h2gfn8w` (`correo`),
  UNIQUE KEY `UKxsbc345m2vlo2cms5rqv4g9v` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (2,'cordova sanchez','lengua y filosofia','edu@gmail.com','yarina','76954674','1993-12-18','eduardo','980567345'),(4,'del aguila pinedo','Historia','omar@gmail.com','calleria','67854120','2000-05-08','omar','951345789');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente_aula`
--

DROP TABLE IF EXISTS `docente_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente_aula` (
  `docente_id` int NOT NULL,
  `aula_id` int NOT NULL,
  PRIMARY KEY (`docente_id`,`aula_id`),
  KEY `FK5v043yywdfola8kimtnav8g7v` (`aula_id`),
  CONSTRAINT `FK5v043yywdfola8kimtnav8g7v` FOREIGN KEY (`aula_id`) REFERENCES `aula` (`id`),
  CONSTRAINT `FK80uwtpr1y1nwwcoly73gnvldp` FOREIGN KEY (`docente_id`) REFERENCES `docente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente_aula`
--

LOCK TABLES `docente_aula` WRITE;
/*!40000 ALTER TABLE `docente_aula` DISABLE KEYS */;
INSERT INTO `docente_aula` VALUES (2,1),(2,2),(4,4),(4,6);
/*!40000 ALTER TABLE `docente_aula` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 11:02:50
