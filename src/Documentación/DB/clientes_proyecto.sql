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
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `idProyecto` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `horasEmpleadas` double DEFAULT NULL,
  `finalizado` tinyint(4) DEFAULT NULL,
  `EquipoDesarrollo_idEquipo` int(11) NOT NULL,
  `historial_idHistorial` int(11) NOT NULL,
  PRIMARY KEY (`idProyecto`,`EquipoDesarrollo_idEquipo`,`historial_idHistorial`),
  KEY `fk_Proyecto_EquipoDesarrollo1_idx` (`EquipoDesarrollo_idEquipo`),
  KEY `fk_proyecto_historial1_idx` (`historial_idHistorial`),
  CONSTRAINT `fk_Proyecto_EquipoDesarrollo1` FOREIGN KEY (`EquipoDesarrollo_idEquipo`) REFERENCES `equipodesarrollo` (`idEquipo`),
  CONSTRAINT `fk_proyecto_historial1` FOREIGN KEY (`historial_idHistorial`) REFERENCES `historial` (`idHistorial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (0,'SysMed','App Mobil - Gestión Turnos','2021-02-11',20.5,0,1,1),(1,'SysConstruc','App Escritorio - Sistema Facturación','2021-05-15',21.5,1,2,2),(2,'miTienda','Página Web - Tienda Ropa','2021-05-21',10.5,1,1,3),(3,'BeberAgua','App Mobil - Alarmas Recordar Beber Agua','2021-05-30',15.5,0,3,4),(4,'miAgenda','App Mobil - Agenda Personal','2021-06-14',20,0,2,5),(5,'PeluCom','Página Web - Peluquería Gestión Turnos','2021-07-08',20,0,3,1),(6,'PeluTuc','Pág Web - Peluquería Venta Catálogo','2021-07-10',10,0,3,2);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
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
