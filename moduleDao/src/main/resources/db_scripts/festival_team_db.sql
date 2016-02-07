-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.10-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.5040
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for festival_team_db
DROP DATABASE IF EXISTS `festival_team_db`;
CREATE DATABASE IF NOT EXISTS `festival_team_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `festival_team_db`;


-- Dumping structure for table festival_team_db. t_employers
CREATE TABLE IF NOT EXISTS ` t_employers` (
  `c_ID` int(5) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  `c_phone` varchar(50) DEFAULT NULL,
  `c_email` varchar(50) DEFAULT NULL,
  `c_fk_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db. t_employers: ~3 rows (approximately)
/*!40000 ALTER TABLE ` t_employers` DISABLE KEYS */;
INSERT INTO ` t_employers` (`c_ID`, `c_name`, `c_phone`, `c_email`, `c_fk_address_id`) VALUES
	(1, 'Some Work_1', '+375171111111', 'employer1@some.com', 1),
	(2, 'Some University_1', '+375172222222', 'employer2@some.com', 2),
	(3, 'Some Work_2', '+375173333333', 'employer3@some.com', 3);
/*!40000 ALTER TABLE ` t_employers` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_addresses
CREATE TABLE IF NOT EXISTS `t_addresses` (
  `c_ID` int(5) NOT NULL AUTO_INCREMENT,
  `c_country` varchar(50) DEFAULT NULL,
  `c_city` varchar(50) DEFAULT NULL,
  `c_building` varchar(4) DEFAULT NULL,
  `c_street_name` varchar(50) DEFAULT NULL,
  `c_block` varchar(3) DEFAULT NULL,
  `c_flat` varchar(5) DEFAULT NULL,
  `c_zip_code` varchar(10) DEFAULT NULL,
  `c_city_phone` varchar(10) DEFAULT NULL,
  `c_fk_street_type` int(10) DEFAULT NULL,
  PRIMARY KEY (`c_ID`),
  KEY `c_fk_street_type` (`c_fk_street_type`),
  CONSTRAINT `c_fk_street_type` FOREIGN KEY (`c_fk_street_type`) REFERENCES `t_street_types` (`c_ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_addresses: ~5 rows (approximately)
/*!40000 ALTER TABLE `t_addresses` DISABLE KEYS */;
INSERT INTO `t_addresses` (`c_ID`, `c_country`, `c_city`, `c_building`, `c_street_name`, `c_block`, `c_flat`, `c_zip_code`, `c_city_phone`, `c_fk_street_type`) VALUES
	(1, 'Belarus', 'City1', '11', 'Street1', NULL, '11', '220011', '1234567', 1),
	(2, 'Belarus', 'City2', '22', 'Street2', '2', '22', '220022', '2345678', 2),
	(3, 'Belarus', 'City3', '33', 'Street3', '3', '33', '220033', '3456789', 3),
	(4, 'Belarus', 'City4', '44', 'Street4', '4', '44', '220044', '4567890', 4);
/*!40000 ALTER TABLE `t_addresses` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_occupations
CREATE TABLE IF NOT EXISTS `t_occupations` (
  `c_ID` int(5) NOT NULL AUTO_INCREMENT,
  `c_post` varchar(50) DEFAULT NULL,
  `c_stud_department` varchar(50) DEFAULT NULL,
  `c_stud_group` varchar(10) DEFAULT NULL,
  `c_stud_course` int(1) DEFAULT NULL,
  `c_fk_employer_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`c_ID`),
  KEY `c_FK_employer_id` (`c_fk_employer_id`),
  CONSTRAINT `c_FK_employer_id` FOREIGN KEY (`c_fk_employer_id`) REFERENCES ` t_employers` (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_occupations: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_occupations` DISABLE KEYS */;
INSERT INTO `t_occupations` (`c_ID`, `c_post`, `c_stud_department`, `c_stud_group`, `c_stud_course`, `c_fk_employer_id`) VALUES
	(1, 'worker', NULL, NULL, NULL, 1),
	(2, 'student', 'Some Department', '111', 1, 2);
/*!40000 ALTER TABLE `t_occupations` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_passports
CREATE TABLE IF NOT EXISTS `t_passports` (
  `c_ID` int(5) NOT NULL AUTO_INCREMENT,
  `c_personal_num` varchar(14) DEFAULT '0',
  `c_f_name_lat` varchar(50) DEFAULT NULL,
  `c_l_name_lat` varchar(50) DEFAULT NULL,
  `c_series` varchar(2) DEFAULT NULL,
  `c_number` int(7) DEFAULT NULL,
  `c_issue_date` date DEFAULT NULL,
  `c_expiry_date` date DEFAULT NULL,
  `c_issuing_org` varchar(50) DEFAULT NULL,
  `c_issuing_org_inner` varchar(50) DEFAULT NULL,
  `c_registration_address` varchar(50) DEFAULT NULL,
  `c_fingers` int(1) NOT NULL DEFAULT '0',
  `c_citizenship` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_passports: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_passports` DISABLE KEYS */;
INSERT INTO `t_passports` (`c_ID`, `c_personal_num`, `c_f_name_lat`, `c_l_name_lat`, `c_series`, `c_number`, `c_issue_date`, `c_expiry_date`, `c_issuing_org`, `c_issuing_org_inner`, `c_registration_address`, `c_fingers`, `c_citizenship`) VALUES
	(1, '1234567A123AB1', 'Name1', 'Surname1', 'AA', 1234567, '2015-12-29', '2015-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '1', 0, 'REPUBLIC OF BELARUS'),
	(2, '7654321B321BA1', 'Name2', 'Surname2', 'BB', 7654321, '2016-12-29', '2016-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '2', 1, 'REPUBLIC OF BELARUS');
/*!40000 ALTER TABLE `t_passports` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_sexes
CREATE TABLE IF NOT EXISTS `t_sexes` (
  `c_ID` int(1) NOT NULL AUTO_INCREMENT,
  `c_sex_name` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_sexes: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_sexes` DISABLE KEYS */;
INSERT INTO `t_sexes` (`c_ID`, `c_sex_name`) VALUES
	(1, 'male'),
	(2, 'female');
/*!40000 ALTER TABLE `t_sexes` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_street_types
CREATE TABLE IF NOT EXISTS `t_street_types` (
  `c_ID` int(2) NOT NULL AUTO_INCREMENT,
  `c_type_name` varchar(10) NOT NULL DEFAULT '0',
  `c_type_code` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table festival_team_db.t_street_types: ~10 rows (approximately)
/*!40000 ALTER TABLE `t_street_types` DISABLE KEYS */;
INSERT INTO `t_street_types` (`c_ID`, `c_type_name`, `c_type_code`) VALUES
	(1, 'улица', 'ул.'),
	(2, 'переулок', 'пер.'),
	(3, 'проспект', 'пр-т'),
	(4, 'проезд', 'пр-д'),
	(5, 'бульвар', 'булю'),
	(6, 'площадь', 'пл.'),
	(7, 'тракт', 'тракт'),
	(8, 'шоссе', 'шос.'),
	(9, 'набережная', 'наб.'),
	(10, 'м-н', 'микрорайон');
/*!40000 ALTER TABLE `t_street_types` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.t_teammates
CREATE TABLE IF NOT EXISTS `t_teammates` (
  `c_ID` int(5) NOT NULL AUTO_INCREMENT,
  `c_nick_name` varchar(50) DEFAULT NULL,
  `c_f_name_cyr` varchar(50) DEFAULT NULL,
  `c_m_name_cyr` varchar(50) DEFAULT NULL,
  `c_l_name_cyr` varchar(50) DEFAULT NULL,
  `c_birth_date` date DEFAULT NULL,
  `c_vk_profile` varchar(50) DEFAULT NULL,
  `c_contact_phone` varchar(50) DEFAULT NULL,
  `c_fk_sexes_id` int(1) DEFAULT NULL,
  `c_fk_passport_id` int(5) DEFAULT NULL,
  `c_fk_occupation_id` int(5) DEFAULT NULL,
  `c_fk_current_address_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`c_ID`),
  KEY `c_fk_passport_id` (`c_fk_passport_id`),
  KEY `c_fk_occupation_id` (`c_fk_occupation_id`),
  KEY `c_fk_address_id` (`c_fk_current_address_id`),
  KEY `c_fk_sex_id` (`c_fk_sexes_id`),
  CONSTRAINT `c_FK_current_address_id` FOREIGN KEY (`c_fk_current_address_id`) REFERENCES `t_addresses` (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `c_FK_occupation_id` FOREIGN KEY (`c_fk_occupation_id`) REFERENCES `t_occupations` (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `c_FK_passport_id` FOREIGN KEY (`c_fk_passport_id`) REFERENCES `t_passports` (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `c_FK_sexes_id` FOREIGN KEY (`c_fk_sexes_id`) REFERENCES `t_sexes` (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_teammates: ~2 rows (approximately)
/*!40000 ALTER TABLE `t_teammates` DISABLE KEYS */;
INSERT INTO `t_teammates` (`c_ID`, `c_nick_name`, `c_f_name_cyr`, `c_m_name_cyr`, `c_l_name_cyr`, `c_birth_date`, `c_vk_profile`, `c_contact_phone`, `c_fk_sexes_id`, `c_fk_passport_id`, `c_fk_occupation_id`, `c_fk_current_address_id`) VALUES
	(1, 'TeamMate1', 'Имя1', 'Отчество1', 'Фамилия1', '2011-01-11', 'http://vk.com/loki_baggins', '+375291234567', 1, 1, 1, 1),
	(2, 'TeamMate2', 'Имя2', 'Отчество2', 'Фамилия2', '2022-02-22', 'http://vk.com/tm2', '+375292345678', 2, 2, 2, 3);
/*!40000 ALTER TABLE `t_teammates` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
