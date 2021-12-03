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
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle` (
  `idDetalle` int(11) NOT NULL,
  `horasPagadas` double NOT NULL,
  `subTotal` varchar(45) DEFAULT NULL,
  `Factura_idFactura` int(11) NOT NULL,
  `Proyecto_idProyecto` int(11) NOT NULL,
  PRIMARY KEY (`idDetalle`,`Factura_idFactura`,`Proyecto_idProyecto`),
  KEY `fk_Detalle_Factura1_idx` (`Factura_idFactura`),
  KEY `fk_Detalle_Proyecto1_idx` (`Proyecto_idProyecto`),
  CONSTRAINT `fk_Detalle_Factura1` FOREIGN KEY (`Factura_idFactura`) REFERENCES `factura` (`idFactura`),
  CONSTRAINT `fk_Detalle_Proyecto1` FOREIGN KEY (`Proyecto_idProyecto`) REFERENCES `proyecto` (`idProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
INSERT INTO `detalle` VALUES (1,5,'18000',1,0),(2,10.5,'18900',2,0),(3,2,'7200',3,0),(4,2,'7200',4,0),(5,21.5,'77400',5,1),(6,10.5,'37800',6,2),(7,4,'14400',7,3),(8,4,'14400',7,4),(9,2,'7200',8,3),(10,2,'7200',8,4),(11,3,'10800',9,5),(12,5,'18000',9,6);
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
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
