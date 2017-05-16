-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.12-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for equipment_web
DROP DATABASE IF EXISTS `equipment_web`;
CREATE DATABASE IF NOT EXISTS `equipment_web` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `equipment_web`;


-- Dumping structure for table equipment_web.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` enum('EQ','AC') NOT NULL DEFAULT 'EQ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.category: ~3 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`, `type`) VALUES
	(1, 'bycicle', 'EQ'),
	(2, 'skate', 'EQ'),
	(3, 'helmet', 'EQ');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Dumping structure for table equipment_web.equipment
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `model` varchar(50) NOT NULL DEFAULT '0',
  `price` double unsigned NOT NULL DEFAULT '0',
  `weight` double NOT NULL DEFAULT '0',
  `width` double NOT NULL DEFAULT '0',
  `height` double NOT NULL DEFAULT '0',
  `person_category` set('ADULT','CHILD') NOT NULL,
  `is_rent` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `category_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_equipment_category` (`category_id`),
  CONSTRAINT `FK_equipment_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.equipment: ~1 rows (approximately)
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` (`id`, `model`, `price`, `weight`, `width`, `height`, `person_category`, `is_rent`, `category_id`) VALUES
	(1, 'bycicle', 12, 0, 0, 0, 'ADULT', 0, 1),
	(6, 'skate', 45, 0, 0, 0, 'ADULT', 0, 2),
	(7, 'helmet', 65, 0, 0, 0, 'ADULT', 0, 3),
	(8, 'bycicle1', 65, 0, 0, 0, 'ADULT', 0, 1),
	(9, 'bycicle 2', 87, 0, 0, 0, 'ADULT', 0, 1),
	(10, 'helmet', 8, 0, 0, 0, 'ADULT', 0, 3);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;


-- Dumping structure for table equipment_web.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `id_user` int(11) unsigned NOT NULL DEFAULT '0',
  `id_equipment` int(11) unsigned NOT NULL DEFAULT '0',
  `date_start` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order1_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.order: ~0 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


-- Dumping structure for table equipment_web.params
DROP TABLE IF EXISTS `params`;
CREATE TABLE IF NOT EXISTS `params` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_params_category` (`category_id`),
  CONSTRAINT `FK_params_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.params: ~0 rows (approximately)
/*!40000 ALTER TABLE `params` DISABLE KEYS */;
/*!40000 ALTER TABLE `params` ENABLE KEYS */;


-- Dumping structure for table equipment_web.param_value
DROP TABLE IF EXISTS `param_value`;
CREATE TABLE IF NOT EXISTS `param_value` (
  `id_param` int(11) unsigned NOT NULL,
  `id_equipment` int(11) unsigned NOT NULL,
  `value` varchar(255) NOT NULL,
  KEY `FK_param_value_params` (`id_param`),
  KEY `FK_param_value_equipment` (`id_equipment`),
  CONSTRAINT `FK_param_value_equipment` FOREIGN KEY (`id_equipment`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_param_value_params` FOREIGN KEY (`id_param`) REFERENCES `params` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.param_value: ~0 rows (approximately)
/*!40000 ALTER TABLE `param_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `param_value` ENABLE KEYS */;


-- Dumping structure for table equipment_web.rent_list
DROP TABLE IF EXISTS `rent_list`;
CREATE TABLE IF NOT EXISTS `rent_list` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) unsigned NOT NULL,
  `equipment_id` int(11) unsigned NOT NULL,
  `date_begin` datetime NOT NULL,
  `date_end` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_user` (`order_id`),
  KEY `FK_order_equipment` (`equipment_id`),
  CONSTRAINT `FK_order_equipment` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.rent_list: ~0 rows (approximately)
/*!40000 ALTER TABLE `rent_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent_list` ENABLE KEYS */;


-- Dumping structure for table equipment_web.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `secondName` varchar(100) NOT NULL,
  `passport` varchar(100) NOT NULL,
  `role` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table equipment_web.user: ~5 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `password`, `firstName`, `secondName`, `passport`, `role`) VALUES
	(1, 'user', 'user', 'user 1', '', '', 0),
	(2, 'admin', 'admin', 'user 2', '', '', 1),
	(4, 'user2', 'user2', 'user 4', '', '', 0),
	(6, 'user3', 'user3', 'user 4', '', '', 0),
	(7, 'user3', 'user3', 'user 4', '', '', 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
