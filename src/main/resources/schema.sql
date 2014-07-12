DROP TABLE IF EXISTS `daytip`;
CREATE TABLE `daytip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id自增主键',
  `tipDate` date DEFAULT NULL COMMENT '日期',
  `tipDateStr` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '日期原字符串',
  `week` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '星期',
  `money` float DEFAULT NULL COMMENT '使用的钱的数量',
  `desc` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_daytip_tipDateStr` (`tipDateStr`)
) ENGINE=InnoDB AUTO_INCREMENT=1948 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


DROP TABLE IF EXISTS `daytipdetail`;
CREATE TABLE `daytipdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id自增主键',
  `tipDate` date DEFAULT NULL COMMENT '日期',
  `tipDateStr` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '日期原字符串',
  `week` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '星期',
  `money` float DEFAULT NULL COMMENT '使用的钱的数量',
  `desc` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1377 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;