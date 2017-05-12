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

-- Dumping structure for table sport.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table sport.category: ~3 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`, `type`) VALUES
	(1, 'bycicle', 1),
	(2, 'skate', 1),
	(3, 'helmet', 0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Dumping structure for table sport.equipment
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `price` double unsigned NOT NULL DEFAULT '0',
  `model` varchar(50) NOT NULL DEFAULT '0',
  `is_rent` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `category_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_equipment_category` (`category_id`),
  CONSTRAINT `FK_equipment_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sport.equipment: ~4 rows (approximately)
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` (`id`, `price`, `model`, `is_rent`, `category_id`) VALUES
	(1, 20, 'byke model 1', 0, 1),
	(2, 25.7, 'byke model 2', 0, 1),
	(3, 16, 'skate model 1', 0, 2),
	(4, 23, 'helmet model 1', 0, 3);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;


-- Dumping structure for table sport.order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `user_id` int(11) unsigned NOT NULL,
  `equipment_id` int(11) unsigned NOT NULL,
  `date_begin` int(11) unsigned NOT NULL,
  `date_end` int(11) unsigned NOT NULL,
  KEY `FK_order_user` (`user_id`),
  KEY `FK_order_equipment` (`equipment_id`),
  CONSTRAINT `FK_order_equipment` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sport.order: ~0 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


-- Dumping structure for table sport.params
DROP TABLE IF EXISTS `params`;
CREATE TABLE IF NOT EXISTS `params` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) unsigned NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_params_category` (`category_id`),
  CONSTRAINT `FK_params_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sport.params: ~4 rows (approximately)
/*!40000 ALTER TABLE `params` DISABLE KEYS */;
INSERT INTO `params` (`id`, `category_id`, `name`) VALUES
	(1, 1, 'count_speed_mode'),
	(2, 2, 'size'),
	(3, 3, 'material'),
	(4, 3, 'size');
/*!40000 ALTER TABLE `params` ENABLE KEYS */;


-- Dumping structure for table sport.param_value
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

-- Dumping data for table sport.param_value: ~1 rows (approximately)
/*!40000 ALTER TABLE `param_value` DISABLE KEYS */;
INSERT INTO `param_value` (`id_param`, `id_equipment`, `value`) VALUES
	(1, 1, '5');
/*!40000 ALTER TABLE `param_value` ENABLE KEYS */;


-- Dumping structure for table sport.user
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

-- Dumping data for table sport.user: ~5 rows (approximately)
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
