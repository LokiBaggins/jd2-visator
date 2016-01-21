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
DROP DATABASE IF EXISTS `c_festival_team_db`;
CREATE DATABASE IF NOT EXISTS `c_festival_team_db` /* !40100 DEFAULT CHARACTER SET latin1 */;
USE `c_festival_team_db`;


-- Dumping structure for table festival_team_db.t_addresses
CREATE TABLE IF NOT EXISTS `c_t_addresses` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
  `c_country` varchar(50) DEFAULT NULL,
  `c_city` varchar(50) DEFAULT NULL,
  `c_street_name` varchar(50) DEFAULT NULL,
  `c_building` varchar(4) DEFAULT NULL,
  `c_block` varchar(3) DEFAULT NULL,
  `c_flat` varchar(5) DEFAULT NULL,
  `c_zip_code` varchar(10) DEFAULT NULL,
  `c_city_phone` varchar(10) DEFAULT NULL,
#   TODO: вынести тип улиц в отдельный справочник
  `c_fk_street_type` int(10) DEFAULT NULL,
  PRIMARY KEY  (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.t_addresses: ~4 rows (approximately)
DELETE FROM `c_t_addresses`;
/* !40000 ALTER TABLE `c_t_addresses` DISABLE KEYS */;
INSERT INTO `c_t_addresses`  (`c_ID`, `c_country`, `c_city`, `c_street_name`, `c_building`, `c_block`, `c_flat`, `c_zip_code`, `c_city_phone`, `c_fk_street_type`) VALUES
	(1, 'Belarus', 'City1', 'Street1', '11', NULL, '11', '220011', '1234567', NULL),
	(2, 'Belarus', 'City2', 'Street2', '22', '2', '22', '220022', '2345678', NULL),
	(3, 'Belarus', 'City3', 'Street3', '33', '3', '33', '220033', '3456789', NULL),
	(4, 'Belarus', 'City4', 'Street4', '44', '4', '44', '220044', '4567890', NULL);
/* !40000 ALTER TABLE `c_t_addresses` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.employers
CREATE TABLE IF NOT EXISTS ` t_employers` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  `c_phone` varchar(50) DEFAULT NULL,
  `c_email` varchar(50) DEFAULT NULL,
  `c_fk_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY  (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.employers: ~3 rows (approximately)
DELETE FROM ` t_employers`;
/* !40000 ALTER TABLE ` t_employers` DISABLE KEYS */;
INSERT INTO ` t_employers`  (`c_ID`, `c_name`, `c_phone`, `c_email`, `c_fk_address_id`) VALUES
	(1, 'Some Work_1', '+375171111111', 'employer1@some.com', 1),
	(2, 'Some University_1', '+375172222222', 'employer2@some.com', 2),
	(3, 'Some Work_2', '+375173333333', 'employer3@some.com', 3);
/* !40000 ALTER TABLE ` t_employers` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.occupations
CREATE TABLE IF NOT EXISTS `t_occupations` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
  `c_post` varchar(50) DEFAULT NULL,
  `c_stud_department` varchar(50) DEFAULT NULL,
  `c_stud_group` varchar(10) DEFAULT NULL,
  `c_stud_course` int(1) DEFAULT NULL,
  `c_fk_employer_id` int(11) DEFAULT NULL,
  PRIMARY KEY  (`c_ID`),
  KEY `c_FK_employer_id`  (`c_fk_employer_id`),
  CONSTRAINT `c_FK_employer_id` FOREIGN KEY  (`c_fk_employer_id`) REFERENCES ` t_employers`  (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.occupations: ~2 rows (approximately)
DELETE FROM `t_occupations`;
/* !40000 ALTER TABLE `t_occupations` DISABLE KEYS */;
INSERT INTO `t_occupations`  (`c_ID`, `c_post`, `c_stud_department`, `c_stud_group`, `c_stud_course`, `c_fk_employer_id`) VALUES
	(1, 'worker', NULL, NULL, NULL, 1),
	(2, 'student', 'Some Department', '111', 1, 2);
/* !40000 ALTER TABLE `t_occupations` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.passports
CREATE TABLE IF NOT EXISTS `t_passports` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY  (`c_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.passports: ~2 rows (approximately)
DELETE FROM `t_passports`;
/* !40000 ALTER TABLE `t_passports` DISABLE KEYS */;
INSERT INTO `t_passports`  (`c_ID`, `c_personal_num`, `c_f_name_lat`, `c_l_name_lat`, `c_series`, `c_number`, `c_issue_date`, `c_expiry_date`, `c_issuing_org`, `c_issuing_org_inner`, `c_registration_address`, `c_fingers`, `c_citizenship`) VALUES
	(1, '1234567A123AB1', 'Name1', 'Surname1', 'AA', 1234567, '2015-12-29', '2015-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '1', 0, 'REPUBLIC OF BELARUS'),
	(2, '7654321B321BA1', 'Name2', 'Surname2', 'BB', 7654321, '2016-12-29', '2016-12-31', 'MINISTRY OF INTERNAL AFFAIRS', 'Жэстачайшы РУВД г. Минска', '2', 1, 'REPUBLIC OF BELARUS');
/* !40000 ALTER TABLE `t_passports` ENABLE KEYS */;


-- Dumping structure for table festival_team_db.teammates
CREATE TABLE IF NOT EXISTS `t_teammates` (
  `c_ID` int(11) NOT NULL AUTO_INCREMENT,
  `c_nick_name` varchar(50) DEFAULT NULL,
  `c_f_name_cyr` varchar(50) DEFAULT NULL,
  `c_m_name_cyr` varchar(50) DEFAULT NULL,
  `c_l_name_cyr` varchar(50) DEFAULT NULL,
  `c_birth_date` date DEFAULT NULL,
#   TODO: вынести пол в отдельный справочник
  `c_sex` int(1) DEFAULT NULL,
  `c_vk_profile` varchar(50) DEFAULT NULL,
  `c_contact_phone` varchar(50) DEFAULT NULL,
  `c_fk_passport_id` int(11) DEFAULT NULL,
  `c_fk_occupation_id` int(11) DEFAULT NULL,
  `c_fk_current_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY  (`c_ID`),
  KEY `c_fk_passport_id`  (`c_fk_passport_id`),
  KEY `c_fk_occupation_id`  (`c_fk_occupation_id`),
  KEY `c_fk_address_id`  (`c_fk_current_address_id`),
  CONSTRAINT `c_FK_current_address_id` FOREIGN KEY  (`c_fk_current_address_id`) REFERENCES `c_t_addresses`  (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `c_FK_occupation_id` FOREIGN KEY  (`c_fk_occupation_id`) REFERENCES `t_occupations`  (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `c_FK_passport_id` FOREIGN KEY  (`c_fk_passport_id`) REFERENCES `t_passports`  (`c_ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table festival_team_db.teammates: ~2 rows (approximately)
DELETE FROM `t_teammates`;
/* !40000 ALTER TABLE `t_teammates` DISABLE KEYS */;
INSERT INTO `t_teammates`  (`c_ID`, `c_nick_name`, `c_f_name_cyr`, `c_m_name_cyr`, `c_l_name_cyr`, `c_birth_date`, `c_sex`, `c_vk_profile`, `c_contact_phone`, `c_fk_passport_id`, `c_fk_occupation_id`, `c_fk_current_address_id`) VALUES
	(1, 'TeamMate1', 'Имя1', 'Отчество1', 'Фамилия1', '2011-01-11', 0, 'http://vk.com/loki_baggins', '+375291234567', 1, 1, 1),
	(2, 'TeamMate2', 'Имя2', 'Отчество2', 'Фамилия2', '2022-02-22', 1, 'http://vk.com/tm2', '+375292345678', 2, 2, 3);
/* !40000 ALTER TABLE `t_teammates` ENABLE KEYS */;
/* !40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/* !40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/* !40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
