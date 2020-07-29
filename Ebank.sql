-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: project_db
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Account` (
  `account_no` int(11) NOT NULL AUTO_INCREMENT,
  `acc_type` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  `opening_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_no`),
  KEY `FKrm03lwfg5yl6swf9ttvbfcesc` (`user_id`),
  CONSTRAINT `FKrm03lwfg5yl6swf9ttvbfcesc` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1042 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1000,'SAVINGS',1234,'2019-09-08',4),(1011,'SAVINGS',377,'2019-08-07',20),(1030,'SAVINGS',47111,'2019-09-08',24),(1031,'CURRENT',47111,'2019-09-08',25),(1033,'SAVINGS',5345,'2019-06-17',25),(1034,'CURRENT',700,'2019-09-09',24),(1036,'SAVINGS',1425,'2020-01-26',31),(1037,'CURRENT',600,'2020-01-26',28),(1038,'SAVINGS',975,'2020-01-26',28),(1039,'SAVINGS',1000,'2020-02-12',25),(1040,'SAVINGS',1000,'2020-02-12',25);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `News`
--

DROP TABLE IF EXISTS `News`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `News` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `News`
--

LOCK TABLES `News` WRITE;
/*!40000 ALTER TABLE `News` DISABLE KEYS */;
INSERT INTO `News` VALUES (100,'The bank will be closed on 9 April to 20 April due to threat of corornavirus so please check our e-banking website'),(101,'Please see our new interest rates on the our website'),(102,'please visit www.ebanking.com for more info');
/*!40000 ALTER TABLE `News` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `confirmpassword` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobileno` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pan` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `otp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ncoa9bfasrql0x4nhmh1plxxy` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (2,'pune','vibha','tiwari.vibhatiwari1895@gmail.com','7899999999','vibha','456','vibha','ADMIN',1),(4,'Bilaspur','vikas123','vicky138verma@gmail.com','789637412','VikasDeep Verma','788945','vikas123','MANAGER',0),(20,'Pune City','123','mak@gmail.com','6789056789','Mukund Chandra','123','123','MANAGER',0),(22,'mumbai','12345','saurabh@gmail.com','7895887463','saurabh','789','12345','CUSTOMER',0),(23,'Nagar','12345678','vish@gmail.com','8899776654','Vishal','12341234','12345678','CUSTOMER',0),(24,'Gondia','123456','sumit@gmail.com','09090909','sumit','78521','123456','CUSTOMER',0),(25,'amravati','zeeshan','zeeshan@gmail.com','7896021450','zeeshan','9898989898','zeeshan','CUSTOMER',0),(26,'kolhapur','omkar','omkar@gmail.com','9876598765','Omkar Patil','567567','omkar','MANAGER',0),(27,'Sangli','akshay','akshay@gmail.com','9998887770','Anup','88998899889','akshay','CUSTOMER',0),(28,'Surat','Shubham@123','shubham@gmail.com','7809767890','shubham','78909876','Shubham@123','CUSTOMER',0),(29,'Nashik','admin123','admin@gmail.com','9098708780','Admin','2001089','admin123','ADMIN',0),(30,'Hyderabad','manager123','manager@gmail.com','9120198098','Customer','1010235','customer123','CUSTOMER',0),(31,'kanpur','maddy1234','mady@gmail.com','9988998890','Madhusudan','98980','maddy1234','CUSTOMER',0),(32,'Jalgaon','123','swapnil@gmail.com','9087856709','Swapnil Warke','12345678','123','MANAGER',0),(33,'Aurangabad','vinay','vinay@gmail.com','5678901234','Vinay','1907823','vinay','CUSTOMER',0),(34,'Delhi','tejas123','tejas@gmail.com','8908907890','Tejas','98098077','tejas123','MANAGER',0),(35,'Chandrapur','chetan123','chetan@gmail.com','8909012345','Chetan','890909','chetan123','MANAGER',0),(36,'7894561230','nawab123','nawab@gmail.com','7894561234','Nawab shaikh','7894561236','Nawab*123','CUSTOMER',0),(37,'punr','123456','c@g','4563210596','chennai express','7894561230','123456','CUSTOMER',0),(74,'pune','12345','l@g.com','7894561230','lmn','hjkl','12345','CUSTOMER',0),(75,'pune','123456','s@g.com','4789652310','sudhhir','12345678909','1234567','CUSTOMER',0),(77,'chattisgarh','1234567','s@k.com','7894561211','shahrukh','7894561230','shahrukh','CUSTOMER',0),(78,'chattisgarh','irfankha','a@g.com','7894561230','irfankhan','7894561230','irfankhan','CUSTOMER',0),(79,'kanpur','irfankhan','x@g.com','7894561230','irfankhan','7894561230','irfankhan','CUSTOMER',0),(85,'pine','akshaykumar','akki@g.com','7894561230','akshaykumar','7894561230','akshaykumar','CUSTOMER',0);
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-29 19:18:32
