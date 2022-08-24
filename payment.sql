CREATE DATABASE  IF NOT EXISTS `payment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `payment`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: payment
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` int NOT NULL,
  `account_no` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_no_UNIQUE` (`account_no`),
  UNIQUE KEY `UK_ruxg86y66hmn0a129n4j75akk` (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,100,'Anuj Kotarkar','anuj@gmail.com',90000),(2,101,'Prem Chhabria','prem@gmail.com',92000),(3,102,'Rutuja More','rutuja@gmail.com',89000),(4,103,'Swapnil Ghule','swapnil@gmail.com',90000),(5,104,'Nishtha Sehgal','nishtha@gmail.com',90000),(6,105,'Vaishnavi Deokate','vaishnavi@gmail.com',90000),(7,106,'Sumit Raut','sumit@gmail.com',90000),(8,107,'Vinod','vinod@gmail.com',90000),(9,108,'Sravya','sravya@gmail.com',90000),(10,109,'Airtel','airtel@gmail.com',90000),(11,110,'Jio','jio@gmail.com',90000),(12,111,'Vi','vi@gmail.com',90000),(13,112,'Tata Electric','tata@gmail.com',90000),(14,113,'Adani Electricity','adani@gmail.com',90000);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bill_id` int NOT NULL,
  `biller_code` char(4) NOT NULL,
  `consumer_no` int NOT NULL,
  `amount` double NOT NULL,
  `due_date` date NOT NULL,
  `status` enum('PENDING','PAID') DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `biller_code` (`biller_code`,`consumer_no`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`biller_code`, `consumer_no`) REFERENCES `registeredbiller` (`biller_code`, `consumer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'B001',134,1000,'2022-08-25','PAID'),(2,'B001',134,1000,'2022-08-27','PENDING'),(3,'B003',134,900,'2022-08-29','PENDING'),(4,'B011',134,4000,'2022-08-30','PENDING'),(5,'B001',134,10000,'2022-08-29','PENDING'),(6,'B002',234,1080,'2022-08-29','PENDING');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterbiller`
--

DROP TABLE IF EXISTS `masterbiller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masterbiller` (
  `biller_code` char(4) NOT NULL,
  `biller_account_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`biller_code`),
  KEY `biller_account_id` (`biller_account_id`),
  CONSTRAINT `masterbiller_ibfk_1` FOREIGN KEY (`biller_account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterbiller`
--

LOCK TABLES `masterbiller` WRITE;
/*!40000 ALTER TABLE `masterbiller` DISABLE KEYS */;
INSERT INTO `masterbiller` VALUES ('B001',10,'Airtel'),('B002',11,'Jio'),('B003',12,'Vi'),('B011',13,'Tata Electric'),('B012',14,'Adani Electricity');
/*!40000 ALTER TABLE `masterbiller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeredbiller`
--

DROP TABLE IF EXISTS `registeredbiller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registeredbiller` (
  `biller_id` int NOT NULL,
  `biller_code` char(4) NOT NULL,
  `consumer_no` int NOT NULL,
  `account_no` int NOT NULL,
  `autopay` tinyint(1) DEFAULT '0',
  `autopay_limit` double DEFAULT NULL,
  PRIMARY KEY (`biller_id`),
  UNIQUE KEY `biller_code` (`biller_code`,`consumer_no`),
  UNIQUE KEY `UK_cf8f0tq9u2k0k57y062w8bq7g` (`biller_code`,`consumer_no`),
  KEY `registeredbiller_ibfk_2_idx` (`account_no`),
  CONSTRAINT `registeredbiller_ibfk_1` FOREIGN KEY (`biller_code`) REFERENCES `masterbiller` (`biller_code`),
  CONSTRAINT `registeredbiller_ibfk_2` FOREIGN KEY (`account_no`) REFERENCES `account` (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeredbiller`
--

LOCK TABLES `registeredbiller` WRITE;
/*!40000 ALTER TABLE `registeredbiller` DISABLE KEYS */;
INSERT INTO `registeredbiller` VALUES (1,'B001',134,100,1,1000),(2,'B002',234,101,1,1000),(3,'B003',134,100,0,0),(4,'B011',134,100,0,0);
/*!40000 ALTER TABLE `registeredbiller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `name` enum('Bank manager','Consumer') NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Bank manager'),(2,'Consumer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int NOT NULL,
  `account_id` int NOT NULL,
  `date_time` datetime NOT NULL,
  `amount` double NOT NULL,
  `description` varchar(45) NOT NULL,
  `bill_id` int NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `account_id` (`account_id`),
  KEY `bill_id` (`bill_id`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (2,1,'2022-08-24 04:55:43',1000,'Mobile Recharge',1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `login_id` int NOT NULL,
  `password` varchar(15) NOT NULL,
  `role_id` int NOT NULL,
  `account_id` int DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  KEY `role_id` (`role_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (99,'admin',1,NULL),(100,'password',2,1),(101,'password',2,2),(102,'password',2,3),(103,'password',2,4),(104,'password',2,5),(105,'password',2,6),(106,'password',2,7),(107,'password',2,8),(108,'password',2,9);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 12:52:42
