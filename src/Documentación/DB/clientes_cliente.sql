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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `CUIT` bigint(20) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `visible` tinyint(4) NOT NULL,
  `domicilio_idDomicilio` int(11) NOT NULL,
  PRIMARY KEY (`CUIT`,`domicilio_idDomicilio`),
  KEY `fk_cliente_domicilio1_idx` (`domicilio_idDomicilio`),
  CONSTRAINT `fk_cliente_domicilio` FOREIGN KEY (`domicilio_idDomicilio`) REFERENCES `domicilio` (`idDomicilio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (201475,'785963','juanPerez@gmail.com','Juan Perez',1,7),(203541,'4378952','eusebiajimenez@gmail.com','Eusebia Jimenez',1,8),(203824,'3816024','lucianoacosta28@gmail.com','LUCIANO SA',1,2),(204074,'6024995','luciano.acosta@hotmail.com','Luciano Acosta',0,9),(274069,'4363690','marisolbarraza08@gmail.com','Marisol Barraza',1,10),(274368,'4826930','juanavarela83@outlook.com','Juana Varela',1,11),(274806,'4527830','juanpa@gmail.com','Juan Pablo López',1,13);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03  7:44:48
