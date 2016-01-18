-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.10 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.5040
-- --------------------------------------------------------

/* !40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/* !40101 SET NAMES utf8 */;
/* !50503 SET NAMES utf8mb4 */;
/* !40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/* !40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for festival_team_db
DROP DATABASE IF EXISTS `festival_team_db`;
CREATE DATABASE IF NOT EXISTS `festival_team_db` /* !40100 DEFAULT CHARACTER SET latin1 */;
USE `festival_team_db`;


-- Dumping structure for table festival_team_db.addresses
CREATE TABLE IF NOT EXISTS `addresses` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street_name` varchar(50) DEFAULT NULL,
  `building` varchar(4) DEFAULT NULL,
  `block` varchar(3) DEFAULT NULL,
  `flat` varchar(5) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  `city_phone` varchar(10) DEFAULT NULL,
#   TODO: вынести тип улиц в отдельный справочник
  `fk_street_type` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.addresses: ~4 rows (approximately)
DELETE FROM `addresses`;
/* !40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` (`ID`, `country`, `city`, `street_name`, `building`, `block`, `flat`, `zip_code`, `city_phone`, `fk_street_type`) VALUES
	(1, 'Belarus', 'City1', 'Street1', '11', NULL, '11', '220011', '1234567', NULL),
	(2, 'Belarus', 'City2', 'Street2', '22', '2', '22', '220022', '2345678', NULL),
	(3, 'Belarus', 'City3', 'Street3', '33', '3', '33', '220033', '3456789', NULL),
	(4, 'Belarus', 'City4', 'Street4', '44', '4', '44', '220044', '4567890', NULL);
/* !40000 ALTER TABLE `addresses` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.employers
CREATE TABLE IF NOT EXISTS `employers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fk_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.employers: ~3 rows (approximately)
DELETE FROM `employers`;
/* !40000 ALTER TABLE `employers` DISABLE KEYS */;
INSERT INTO `employers` (`ID`, `name`, `phone`, `email`, `fk_address_id`) VALUES
	(1, 'Some Work_1', '+375171111111', 'employer1@some.com', 1),
	(2, 'Some University_1', '+375172222222', 'employer2@some.com', 2),
	(3, 'Some Work_2', '+375173333333', 'employer3@some.com', 3);
/* !40000 ALTER TABLE `employers` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.occupations
CREATE TABLE IF NOT EXISTS `occupations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `post` varchar(50) DEFAULT NULL,
  `stud_department` varchar(50) DEFAULT NULL,
  `stud_group` varchar(10) DEFAULT NULL,
  `stud_course` int(1) DEFAULT NULL,
  `fk_employer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_employer_id` (`fk_employer_id`),
  CONSTRAINT `FK_employer_id` FOREIGN KEY (`fk_employer_id`) REFERENCES `employers` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.occupations: ~2 rows (approximately)
DELETE FROM `occupations`;
/* !40000 ALTER TABLE `occupations` DISABLE KEYS */;
INSERT INTO `occupations` (`ID`, `post`, `stud_department`, `stud_group`, `stud_course`, `fk_employer_id`) VALUES
	(1, 'worker', NULL, NULL, NULL, 1),
	(2, 'student', 'Some Department', '111', 1, 2);
/* !40000 ALTER TABLE `occupations` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.passports
CREATE TABLE IF NOT EXISTS `passports` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `personal_num` varchar(14) DEFAULT '0',
  `f_name_lat` varchar(50) DEFAULT NULL,
  `l_name_lat` varchar(50) DEFAULT NULL,
  `series` varchar(2) DEFAULT NULL,
  `number` int(7) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `issuing_org` varchar(50) DEFAULT NULL,
  `issuing_org_inner` varchar(50) DEFAULT NULL,
  `registration_address` varchar(50) DEFAULT NULL,
  `fingers` int(1) NOT NULL DEFAULT '0',
  `citizenship` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.passports: ~2 rows (approximately)
DELETE FROM `passports`;
/* !40000 ALTER TABLE `passports` DISABLE KEYS */;
INSERT INTO `passports` (`ID`, `personal_num`, `f_name_lat`, `l_name_lat`, `series`, `number`, `issue_date`, `expiry_date`, `issuing_org`, `issuing_org_inner`, `registration_address`, `fingers`, `citizenship`) VALUES
	(1, '1234567A123AB1', 'Name1', 'Surname1', 'AA', 1234567, '2015-12-29', '2015-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '1', 0, 'REPUBLIC OF BELARUS'),
	(2, '7654321B321BA1', 'Name2', 'Surname2', 'BB', 7654321, '2016-12-29', '2016-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '2', 1, 'REPUBLIC OF BELARUS');
/* !40000 ALTER TABLE `passports` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.teammates
CREATE TABLE IF NOT EXISTS `teammates` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL,
  `f_name_cyr` varchar(50) DEFAULT NULL,
  `m_name_cyr` varchar(50) DEFAULT NULL,
  `l_name_cyr` varchar(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
#   TODO: вынести пол в отдельный справочник
  `sex` int(1) DEFAULT NULL,
  `vk_profile` varchar(50) DEFAULT NULL,
  `contact_phone` varchar(50) DEFAULT NULL,
  `fk_passport_id` int(11) DEFAULT NULL,
  `fk_occupation_id` int(11) DEFAULT NULL,
  `fk_current_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_passport_id` (`fk_passport_id`),
  KEY `fk_occupation_id` (`fk_occupation_id`),
  KEY `fk_address_id` (`fk_current_address_id`),
  CONSTRAINT `FK_current_address_id` FOREIGN KEY (`fk_current_address_id`) REFERENCES `addresses` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_occupation_id` FOREIGN KEY (`fk_occupation_id`) REFERENCES `occupations` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_passport_id` FOREIGN KEY (`fk_passport_id`) REFERENCES `passports` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.teammates: ~2 rows (approximately)
DELETE FROM `teammates`;
/* !40000 ALTER TABLE `teammates` DISABLE KEYS */;
INSERT INTO `teammates` (`ID`, `nick_name`, `f_name_cyr`, `m_name_cyr`, `l_name_cyr`, `birth_date`, `sex`, `vk_profile`, `contact_phone`, `fk_passport_id`, `fk_occupation_id`, `fk_current_address_id`) VALUES
	(1, 'TeamMate1', 'Имя1', 'Отчество1', 'Фамилия1', '2011-01-11', 0, 'http://vk.com/loki_baggins', '+375291234567', 1, 1, 1),
	(2, 'TeamMate2', 'Имя2', 'Отчество2', 'Фамилия2', '2022-02-22', 1, 'http://vk.com/tm2', '+375292345678', 2, 2, 3);
/* !40000 ALTER TABLE `teammates` ENABLE KEYS */;
/* !40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/* !40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/* !40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
