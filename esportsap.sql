-- MariaDB dump 10.19  Distrib 10.4.18-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: esportsapp
-- ------------------------------------------------------
-- Server version	10.4.18-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `esportsapp`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `esportsapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `esportsapp`;

--
-- Table structure for table `administratzaileak`
--

DROP TABLE IF EXISTS `administratzaileak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administratzaileak` (
  `USER` varchar(15) NOT NULL,
  `PASSWORD` varchar(150) NOT NULL,
  PRIMARY KEY (`USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administratzaileak`
--

LOCK TABLES `administratzaileak` WRITE;
/*!40000 ALTER TABLE `administratzaileak` DISABLE KEYS */;
INSERT INTO `administratzaileak` VALUES ('iker','e637d52df1ebdfc8eef062c325ee3cb2'),('jon','006cb570acdab0e0bfc8e3dcb7bb4edf'),('julen','f2ae6c30e4ec2fd73d5e965fb4ece688'),('markel','5dd7c0dde1118e8d65b3d18b07486f0f');
/*!40000 ALTER TABLE `administratzaileak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `babesle`
--

DROP TABLE IF EXISTS `babesle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `babesle` (
  `IZENA` varchar(15) NOT NULL,
  PRIMARY KEY (`IZENA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `babesle`
--

LOCK TABLES `babesle` WRITE;
/*!40000 ALTER TABLE `babesle` DISABLE KEYS */;
INSERT INTO `babesle` VALUES ('ADIDAS'),('ASTRO'),('CORSAIR'),('FONT VELLA'),('GILLETE'),('HYPERX'),('INTEL'),('KAIKU'),('LOGITECH'),('MAPFRE'),('MOVISTAR'),('NIKE'),('ORANGE'),('PULEVA'),('PUMA'),('RAZER'),('RED BULL'),('STEEL SERIES'),('T-MOBILE'),('UPV-EHU'),('VODAFONE');
/*!40000 ALTER TABLE `babesle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `babestu`
--

DROP TABLE IF EXISTS `babestu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `babestu` (
  `IZENABABESLE` varchar(15) NOT NULL,
  `IZENATALDE` varchar(15) NOT NULL,
  `DIRUKOP` int(11) DEFAULT NULL,
  PRIMARY KEY (`IZENABABESLE`,`IZENATALDE`),
  KEY `IZENATALDE` (`IZENATALDE`),
  CONSTRAINT `babestu_ibfk_1` FOREIGN KEY (`IZENABABESLE`) REFERENCES `babesle` (`IZENA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `babestu_ibfk_2` FOREIGN KEY (`IZENATALDE`) REFERENCES `talde` (`IZENA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `babestu`
--

LOCK TABLES `babestu` WRITE;
/*!40000 ALTER TABLE `babestu` DISABLE KEYS */;
INSERT INTO `babestu` VALUES ('ADIDAS','Heretics',500),('ASTRO','G2 Esports',400),('CORSAIR','G2 Esports',400),('FONT VELLA','Betis',200),('GILLETE','Heretics',300),('HYPERX','Fnatic',450),('INTEL','Liquid',550),('KAIKU','Dream Team',300),('LOGITECH','Cloud9',400),('MAPFRE','G2 Esports',250),('MOVISTAR','Dallas E.',450),('NIKE','Dallas E.',300),('ORANGE','RBLZ Gaming',400),('PULEVA','Team BDS',350),('PUMA','Team BDS',250),('RAZER','Team USA',300),('RED BULL','RBLZ Gaming',450),('STEEL SERIES','Cloud9',250),('T-MOBILE','Fnatic',400),('UPV-EHU','Dream Team',1500),('VODAFONE','Team USA',400);
/*!40000 ALTER TABLE `babestu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bideojoko`
--

DROP TABLE IF EXISTS `bideojoko`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bideojoko` (
  `KODEA` int(11) NOT NULL,
  `IZENA` varchar(20) NOT NULL,
  `JOKALARIKOP` int(11) NOT NULL,
  `IRABAZLEA` varchar(15) DEFAULT NULL,
  `hurrengoLehiaketa` date DEFAULT NULL,
  PRIMARY KEY (`KODEA`),
  UNIQUE KEY `IZENA` (`IZENA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bideojoko`
--

LOCK TABLES `bideojoko` WRITE;
/*!40000 ALTER TABLE `bideojoko` DISABLE KEYS */;
INSERT INTO `bideojoko` VALUES (1,'LOL',4,'G2 Esports','2021-05-18'),(2,'Rocket League',3,'Team BDS','2021-05-27'),(3,'Fifa 21',1,'RBLZ Gaming','2021-06-15'),(4,'PES 2021',1,'Liquid','2021-05-31'),(5,'Overwatch',6,'Team USA','2021-07-07'),(6,'Fortnite',4,'Heretics','2021-07-12'),(7,'DOTA 2',4,'Cloud9','2021-07-17'),(8,'PUBG',4,'Liquid','2021-09-02'),(9,'CS:GO',5,'Fnatic','2021-09-10'),(10,'COD',6,'Dallas E.','2021-07-25');
/*!40000 ALTER TABLE `bideojoko` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jokalari`
--

DROP TABLE IF EXISTS `jokalari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jokalari` (
  `IZENA` varchar(15) NOT NULL,
  `ABIZENA1` varchar(15) NOT NULL,
  `ABIZENA2` varchar(15) NOT NULL,
  `ADINA` int(11) NOT NULL,
  `HERRIALDEA` varchar(15) NOT NULL,
  `TALDETXIKIIZENA` varchar(15) NOT NULL,
  `TALDEIZENA` varchar(15) NOT NULL,
  PRIMARY KEY (`IZENA`,`ABIZENA1`,`ABIZENA2`),
  KEY `TALDEIZENA` (`TALDEIZENA`),
  KEY `jokalari_ibfk_1` (`TALDETXIKIIZENA`),
  CONSTRAINT `jokalari_ibfk_1` FOREIGN KEY (`TALDETXIKIIZENA`) REFERENCES `talde_txiki` (`TALDETXIKIIZENA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `jokalari_ibfk_2` FOREIGN KEY (`TALDEIZENA`) REFERENCES `talde` (`IZENA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jokalari`
--

LOCK TABLES `jokalari` WRITE;
/*!40000 ALTER TABLE `jokalari` DISABLE KEYS */;
INSERT INTO `jokalari` VALUES ('Caps','Rasmus','Winther',28,'Erresuma Batua','G21','G2 Esports'),('Iker','Palacios','Tamayo',20,'Euskadi','DT1','Dream Team'),('Jankos','Marcin','Jankowski',20,'Polonia','G21','G2 Esports'),('Joaquin','Sanchez','Rodriguez',39,'Espainia','B1','Betis'),('Jon','Blanco','Suberbiola',21,'Euskadi','DT1','Dream Team'),('Julen','Fuentes','Aguirre',20,'Euskadi','DT1','Dream Team'),('Markel','Rubinos','Lopez',20,'Euskadi','DT1','Dream Team'),('Mikyx','Mihael','Mehle',29,'Alemania','G22','G2 Esports'),('Rekkles','Martin','Larsson',22,'Dinamarka','G22','G2 Esports'),('Wunder','Martin','Hansen',26,'Finlandia','G22','G2 Esports');
/*!40000 ALTER TABLE `jokalari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parte_hartu`
--

DROP TABLE IF EXISTS `parte_hartu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parte_hartu` (
  `BIDEOJOKOKODE` int(11) NOT NULL,
  `TALDEIZENA` varchar(15) NOT NULL,
  PRIMARY KEY (`BIDEOJOKOKODE`,`TALDEIZENA`),
  KEY `TALDEIZENA` (`TALDEIZENA`),
  CONSTRAINT `parte_hartu_ibfk_1` FOREIGN KEY (`BIDEOJOKOKODE`) REFERENCES `bideojoko` (`KODEA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parte_hartu_ibfk_2` FOREIGN KEY (`TALDEIZENA`) REFERENCES `talde` (`IZENA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parte_hartu`
--

LOCK TABLES `parte_hartu` WRITE;
/*!40000 ALTER TABLE `parte_hartu` DISABLE KEYS */;
INSERT INTO `parte_hartu` VALUES (1,'Dream Team'),(1,'Fnatic'),(1,'G2 Esports'),(1,'Heretics'),(2,'Cloud9'),(2,'Dallas E.'),(2,'Team BDS'),(2,'Team USA'),(4,'Betis'),(4,'Cloud9'),(4,'Fnatic'),(4,'Team USA'),(5,'Dream Team'),(5,'RBLZ Gaming'),(5,'Team BDS'),(5,'Team USA'),(6,'Dream Team'),(6,'G2 Esports'),(6,'Liquid'),(6,'RBLZ Gaming'),(7,'Cloud9'),(7,'Fnatic'),(7,'G2 Esports'),(7,'Heretics'),(8,'Betis'),(8,'Fnatic'),(8,'Team BDS'),(8,'Team USA'),(9,'Cloud9'),(9,'Fnatic'),(9,'Liquid'),(9,'RBLZ Gaming'),(10,'Cloud9'),(10,'G2 Esports'),(10,'Heretics'),(10,'Team USA');
/*!40000 ALTER TABLE `parte_hartu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformak`
--

DROP TABLE IF EXISTS `plataformak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plataformak` (
  `BIDEOKODE` int(11) NOT NULL,
  `PLATAFORMA` varchar(15) NOT NULL,
  PRIMARY KEY (`BIDEOKODE`,`PLATAFORMA`),
  CONSTRAINT `plataformak_ibfk_1` FOREIGN KEY (`BIDEOKODE`) REFERENCES `bideojoko` (`KODEA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformak`
--

LOCK TABLES `plataformak` WRITE;
/*!40000 ALTER TABLE `plataformak` DISABLE KEYS */;
INSERT INTO `plataformak` VALUES (1,'PC'),(2,'PC'),(4,'PS5'),(5,'PC'),(6,'PC'),(7,'PC'),(8,'PC'),(9,'PC'),(10,'XBOX ONE X');
/*!40000 ALTER TABLE `plataformak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talde`
--

DROP TABLE IF EXISTS `talde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talde` (
  `IZENA` varchar(15) NOT NULL,
  `EKIKOLOREA` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IZENA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talde`
--

LOCK TABLES `talde` WRITE;
/*!40000 ALTER TABLE `talde` DISABLE KEYS */;
INSERT INTO `talde` VALUES ('Betis','Berdea'),('Cloud9','Urdina'),('Dallas E.','Beltza'),('Dream Team','Beige'),('Fnatic','Laranja'),('G2 Esports','Beltza'),('Heretics','Beltza'),('Liquid','Zuria'),('R. Madrid','Zuria'),('RBLZ Gaming','Zuria'),('Team BDS','Gorria/Urdina'),('Team USA','Gorria');
/*!40000 ALTER TABLE `talde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talde_txiki`
--

DROP TABLE IF EXISTS `talde_txiki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talde_txiki` (
  `TALDETXIKIIZENA` varchar(15) NOT NULL,
  `JOKALARIKOP` int(11) DEFAULT NULL,
  `ENTRENATZAILEA` varchar(20) DEFAULT NULL,
  `IRABAZIKOP` int(11) DEFAULT NULL,
  `TALDEIZENA` varchar(15) NOT NULL,
  `KODEBIDEOJOKO` int(11) NOT NULL,
  PRIMARY KEY (`TALDETXIKIIZENA`,`TALDEIZENA`),
  KEY `KODEBIDEOJOKO` (`KODEBIDEOJOKO`),
  KEY `talde_txiki_ibfk_1` (`TALDEIZENA`),
  CONSTRAINT `talde_txiki_ibfk_1` FOREIGN KEY (`TALDEIZENA`) REFERENCES `talde` (`IZENA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `talde_txiki_ibfk_2` FOREIGN KEY (`KODEBIDEOJOKO`) REFERENCES `bideojoko` (`KODEA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talde_txiki`
--

LOCK TABLES `talde_txiki` WRITE;
/*!40000 ALTER TABLE `talde_txiki` DISABLE KEYS */;
INSERT INTO `talde_txiki` VALUES ('B1',1,'Manolo Puertas',27,'Betis',3),('B2',1,'Manolo Puertas',27,'Betis',4),('B3',4,'Manolo Puertas',12,'Betis',8),('BDS1',3,'Lewis Hamilton',44,'Team BDS',2),('BDS2',6,'Lewis Hamilton',16,'Team BDS',5),('BDS3',4,'Lewis Hamilton',27,'Team BDS',8),('C1',3,'Matthew Roberts',8,'Cloud9',2),('C2',1,'Matthew Roberts',12,'Cloud9',4),('C3',4,'Matthew Roberts',17,'Cloud9',7),('C4',5,'Matthew Roberts',13,'Cloud9',9),('C5',6,'Matthew Roberts',11,'Cloud9',10),('DT1',4,'Gorka Labaka',85,'Dream Team',1),('DT2',1,'Gorka Labaka',18,'Dream Team',3),('DT3',6,'Gorka Labaka',44,'Dream Team',5),('DT4',4,'Gorka Labaka',57,'Dream Team',6),('F1',4,'Gerald Bolmaro',12,'Fnatic',1),('F2',1,'Gerald Bolmaro',7,'Fnatic',4),('F3',4,'Gerald Bolmaro',7,'Fnatic',7),('F4',4,'Gerald Bolmaro',5,'Fnatic',8),('F5',5,'Gerald Bolmaro',24,'Fnatic',9),('G21',4,'Ocelote',24,'G2 Esports',1),('G22',4,'Ocelote',23,'G2 Esports',6),('G23',4,'Ocelote',24,'G2 Esports',7),('G24',6,'Ocelote',17,'G2 Esports',10),('H1',4,'Guillerno Navarro',8,'Heretics',1),('H2',1,'Guillerno Navarro',4,'Heretics',3),('H3',4,'Guillerno Navarro',6,'Heretics',7),('H4',6,'Guillerno Navarro',14,'Heretics',10),('L1',1,'David Bisbal',7,'Liquid',3),('L2',4,'David Bisbal',14,'Liquid',6),('L3',5,'David Bisbal',17,'Liquid',9),('USA1',3,'Mark Evans',10,'Team USA',2),('USA2',1,'Mark Evans',4,'Team USA',4),('USA3',6,'Mark Evans',9,'Team USA',5),('USA4',4,'Mark Evans',16,'Team USA',8),('USA5',6,'Mark Evans',20,'Team USA',10);
/*!40000 ALTER TABLE `talde_txiki` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 11:46:20
