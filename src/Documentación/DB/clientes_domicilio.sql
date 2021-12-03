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
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilio` (
  `idDomicilio` int(11) NOT NULL,
  `calleyaltura` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDomicilio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'Av roca 2066','San Miguel de Tucumán','Tucumán','Argentina'),(2,'Av. Rivadavia 300','Monteros','Tucumán','Argentina'),(3,'Av. Jujuy 4000','Trancas','Tucumán','Argentina'),(4,'Pje. Belgrano S/N','Mendoza','Mendoza','Argentina'),(5,'Calle 16 N° 602','Godoy Cruz','Mendoza','Argentina'),(6,'Alsina 65','Balcarce','Buenos Aires','Argentina'),(7,'Av. Colon','Bahía Blanca','Buenos Aires','Argentina'),(8,'Psje Rosales 1854','Jesus María','Córdoba','Argentina'),(9,'San Juan 200','Córdoba','Córdoba','Argentina'),(10,'San Martin','Córdoba','Córdoba','Argentina'),(11,'Velez','Trancas','Tucumán','Argentina'),(12,'San Juan','Monteros','Tucumán','Argentina'),(13,'Av vega','San Miguel de Tucumán','Tucumán','Argentina'),(15,'San Martin','Córdoba','Córdoba','Argentina');
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
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
