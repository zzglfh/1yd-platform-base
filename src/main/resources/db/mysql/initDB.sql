CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_time` datetime DEFAULT NULL,
  `remove_mark` tinyint(4) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `test_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
