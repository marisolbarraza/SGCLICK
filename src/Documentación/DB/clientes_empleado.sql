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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `legajoEmpleado` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `fechaNac` date DEFAULT NULL,
  `fecIngreso` date DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `visible` tinyint(4) NOT NULL,
  `rol_idRol` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `domicilio_idDomicilio` int(11) NOT NULL,
  PRIMARY KEY (`legajoEmpleado`,`rol_idRol`,`domicilio_idDomicilio`),
  KEY `fk_empleado_rol1_idx` (`rol_idRol`),
  KEY `fk_empleado_domicilio1_idx` (`domicilio_idDomicilio`),
  CONSTRAINT `fk_empleado_domicilio1` FOREIGN KEY (`domicilio_idDomicilio`) REFERENCES `domicilio` (`idDomicilio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_rol1` FOREIGN KEY (`rol_idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (43623,'Maria Valentina','Cesca Foggiato',38159753,'1995-07-20','2015-06-01',4257463,1,3,'mariavalentina@gmail.com',0),(44444,'Luciano Nicolas','Acosta',38963147,'1994-04-15','2015-06-01',4851214,1,5,'lucianoacosta28@gmail.com ',0),(44539,'Alicia Marisol','Barraza Frias',39852147,'1997-08-21','2015-06-01',4341214,1,6,'marisolbarraza08@gmail.com',1),(44634,'Leandro David','Bechara',37412785,'1996-04-23','2015-06-01',4177412,1,1,'leodbechara@gmail.com',2),(45151,'Mariano Miguel','Ruiz Andrade',35486426,'1996-07-22','2015-06-01',4121111,1,2,'miguelruiz@gmail.com',3),(46911,'Juan Leandro','Vilta',38111777,'1994-11-15','2015-06-01',4369874,1,4,'juanvilta02@gmail.com',4);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
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
