-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clientes
-- ------------------------------------------------------
-- Server version	5.7.36-log

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
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidad` (
  `descripcion` varchar(45) DEFAULT NULL,
  `provincia_idprovincia` int(11) NOT NULL,
  `codPostal` varchar(45) NOT NULL,
  PRIMARY KEY (`provincia_idprovincia`,`codPostal`),
  CONSTRAINT `fk_localidad_provincia1` FOREIGN KEY (`provincia_idprovincia`) REFERENCES `provincia` (`idprovincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES ('San Miguel de Tucumán',1,'4000'),('Trancas',1,'4124'),('Monteros',1,'4142'),('Balcarce',2,'7620'),('Bahía Blanca',2,'8000'),('Mendoza',3,'5500'),('Godoy Cruz',3,'5501'),('General Alvear',3,'5620'),('Córdoba',4,'5000'),('Jesús María',4,'5220');
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03  7:44:47
