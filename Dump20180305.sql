CREATE DATABASE  IF NOT EXISTS `dbqcm` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbqcm`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: dbqcm
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `Answer`
--

DROP TABLE IF EXISTS `Answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Answer` (
  `idAnswer` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAnswer`),
  KEY `FK752F2BDE39914C90` (`idQuestion`),
  CONSTRAINT `FK752F2BDE39914C90` FOREIGN KEY (`idQuestion`) REFERENCES `Question` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Answer`
--

LOCK TABLES `Answer` WRITE;
/*!40000 ALTER TABLE `Answer` DISABLE KEYS */;
INSERT INTO `Answer` VALUES (1,2,'just something'),(2,2,'a docker engine'),(3,4,'a server'),(4,4,'just something'),(5,3,'a java class that helps to create dynamically some data on a http server'),(6,3,'anothing stuff'),(7,1,'a technology for creating application'),(8,1,'even the sparrow know'),(9,1,'rescuer'),(10,1,'delivered'),(11,4,'stop the music'),(12,4,'check on google');
/*!40000 ALTER TABLE `Answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Qcm`
--

DROP TABLE IF EXISTS `Qcm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Qcm` (
  `idQcm` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `difficulty` varchar(255) DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idQcm`),
  KEY `FK13C7B36F3337F` (`idUser`),
  CONSTRAINT `FK13C7B36F3337F` FOREIGN KEY (`idUser`) REFERENCES `teacher` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Qcm`
--

LOCK TABLES `Qcm` WRITE;
/*!40000 ALTER TABLE `Qcm` DISABLE KEYS */;
INSERT INTO `Qcm` VALUES (1,'J2ee','A qcm over the j2ee technology of oracle','V',2),(2,'Java ','A MCQ over the java programming language','I',2);
/*!40000 ALTER TABLE `Qcm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Question` (
  `idQuestion` int(11) NOT NULL,
  `entitled` varchar(255) DEFAULT NULL,
  `goodAnswer` varchar(255) DEFAULT NULL,
  `idQcm` int(11) NOT NULL,
  PRIMARY KEY (`idQuestion`),
  KEY `FKBE5CA006CADA9F2` (`idQcm`),
  CONSTRAINT `FKBE5CA006CADA9F2` FOREIGN KEY (`idQcm`) REFERENCES `Qcm` (`idQcm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
INSERT INTO `Question` VALUES (1,'What is j2ee?',NULL,1),(2,'what is a container?',NULL,1),(3,'What is a servlet?',NULL,1),(4,'what is an application server?',NULL,1);
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `idUser` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `login` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,0,'admin		','admin	','Man','admin','administrateur'),(2,1,'Brigitte','Groelas','Woman','brig','brigitte'),(3,2,'Joy','Jed','Man','joyjedid','joyjedid');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `user_id` int(11) NOT NULL,
  `numStudent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK8FFE823BC761A903` (`user_id`),
  CONSTRAINT `FK8FFE823BC761A903` FOREIGN KEY (`user_id`) REFERENCES `Users` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (3,'21708879');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `user_id` int(11) NOT NULL,
  `courseTitle` varchar(255) DEFAULT NULL,
  `activated` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKAA31CBE2C761A903` (`user_id`),
  CONSTRAINT `FKAA31CBE2C761A903` FOREIGN KEY (`user_id`) REFERENCES `Users` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (2,'J2EE','');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-05  1:08:24
