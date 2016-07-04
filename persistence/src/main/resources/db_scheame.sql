DROP DATABASE if EXISTS  osbb;
CREATE DATABASE osbb;

use osbb;

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: softserve
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appartament`
--

DROP TABLE IF EXISTS `appartament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appartament` (
  `id_appartament` int(11) NOT NULL AUTO_INCREMENT,
  `id_house` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `id_owner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_appartament`),
  KEY `fk_appHouse` (`id_house`),
  KEY `fr_ownerUser` (`id_owner`),
  CONSTRAINT `fk_appHouse` FOREIGN KEY (`id_house`) REFERENCES `house` (`id_house`),
  CONSTRAINT `fr_ownerUser` FOREIGN KEY (`id_owner`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appartament`
--

LOCK TABLES `appartament` WRITE;
/*!40000 ALTER TABLE `appartament` DISABLE KEYS */;
/*!40000 ALTER TABLE `appartament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appartament_user`
--

DROP TABLE IF EXISTS `appartament_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appartament_user` (
  `id_appartament` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  KEY `id_appartament` (`id_appartament`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `appartament_user_ibfk_1` FOREIGN KEY (`id_appartament`) REFERENCES `appartament` (`id_appartament`),
  CONSTRAINT `appartament_user_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appartament_user`
--

LOCK TABLES `appartament_user` WRITE;
/*!40000 ALTER TABLE `appartament_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `appartament_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `id_contract` int(11) NOT NULL AUTO_INCREMENT,
  `id_osbb` int(11) DEFAULT NULL,
  `id_provider` int(11) DEFAULT NULL,
  `dateStart` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `dateFinish` timestamp(6) NOT NULL DEFAULT '0000-00-00 00:00:00.000000',
  `text` varchar(400) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `document` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_contract`),
  KEY `cont_prov` (`id_provider`),
  KEY `cont_osbb` (`id_osbb`),
  CONSTRAINT `cont_osbb` FOREIGN KEY (`id_osbb`) REFERENCES `osbb` (`id_osbb`),
  CONSTRAINT `cont_prov` FOREIGN KEY (`id_provider`) REFERENCES `provider` (`id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `id_osbb` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_event`),
  KEY `id_osbb` (`id_osbb`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`id_osbb`) REFERENCES `osbb` (`id_osbb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `id_house` int(11) NOT NULL AUTO_INCREMENT,
  `id_osbb` int(11) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_house`),
  KEY `fk_HouOsbb` (`id_osbb`),
  CONSTRAINT `fk_HouOsbb` FOREIGN KEY (`id_osbb`) REFERENCES `osbb` (`id_osbb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `massege`
--

DROP TABLE IF EXISTS `massege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `massege` (
  `id_massage` int(11) NOT NULL AUTO_INCREMENT,
  `id_ticket` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL,
  `massage` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id_massage`),
  KEY `id_ticket` (`id_ticket`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `massege_ibfk_1` FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id_ticket`),
  CONSTRAINT `massege_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `massege`
--

LOCK TABLES `massege` WRITE;
/*!40000 ALTER TABLE `massege` DISABLE KEYS */;
/*!40000 ALTER TABLE `massege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `osbb`
--

DROP TABLE IF EXISTS `osbb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osbb` (
  `id_osbb` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `id_creator` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_osbb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osbb`
--

LOCK TABLES `osbb` WRITE;
/*!40000 ALTER TABLE `osbb` DISABLE KEYS */;
/*!40000 ALTER TABLE `osbb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provider` (
  `id_provider` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `logoUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `id_report` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `dateCreation` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `filePath` varchar(100) DEFAULT NULL,
  `id_osbb` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_report`),
  KEY `fk_reportOsbb` (`id_osbb`),
  CONSTRAINT `fk_reportOsbb` FOREIGN KEY (`id_osbb`) REFERENCES `osbb` (`id_osbb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `id_staff` int(11) NOT NULL AUTO_INCREMENT,
  `id_osbb` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_staff`),
  KEY `fk_StOsbb` (`id_osbb`),
  KEY `fk_StaffRole` (`id_role`),
  KEY `fk_staffUser` (`id_user`),
  CONSTRAINT `fk_StOsbb` FOREIGN KEY (`id_osbb`) REFERENCES `osbb` (`id_osbb`),
  CONSTRAINT `fk_StaffRole` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  CONSTRAINT `fk_staffUser` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ticket`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `birthDate` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
  `email` varchar(25) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Oleg','Kotsik','2016-06-29 21:10:12.812448','cavayman@gmail.com','0679167305','123456123456',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id_event` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `vote_value` tinyint(1) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `id_event` (`id_event`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`),
  CONSTRAINT `vote_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-01 14:31:37
