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
-- Table structure for table `equipodesarrollo`
--

DROP TABLE IF EXISTS `equipodesarrollo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipodesarrollo` (
  `idEquipo` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `empleado_legajoEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idEquipo`,`empleado_legajoEmpleado`),
  KEY `fk_equipodesarrollo_empleado1_idx` (`empleado_legajoEmpleado`),
  CONSTRAINT `fk_equipodesarrollo_empleado1` FOREIGN KEY (`empleado_legajoEmpleado`) REFERENCES `empleado` (`legajoEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipodesarrollo`
--

LOCK TABLES `equipodesarrollo` WRITE;
/*!40000 ALTER TABLE `equipodesarrollo` DISABLE KEYS */;
INSERT INTO `equipodesarrollo` VALUES (1,'Equipo de desarrollo 1',43623),(1,'Equipo de desarrollo 1',44539),(2,'Equipo de desarrollo 2',43623),(2,'Equipo de desarrollo 2',44444),(2,'Equipo de Desarrollo 2',44539),(3,'Equipo de desarrollo 3',43623),(3,'Equipo de Desarrollo 3',44444);
/*!40000 ALTER TABLE `equipodesarrollo` ENABLE KEYS */;
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
