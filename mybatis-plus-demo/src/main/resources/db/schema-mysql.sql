DROP TABLE  IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_name` varchar(40) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '秘密',
  `nickname` varchar(50) NOT NULL COMMENT '昵称',
  `type` int(10) unsigned DEFAULT NULL COMMENT '类型',
  `state` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '状态：-1失败，0等待,1成功',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_uid` bigint(20) DEFAULT '0' COMMENT '修改人用户ID',
  `login_ip` varchar(50) DEFAULT NULL COMMENT '登录IP地址',
  `login_addr` varchar(100) DEFAULT NULL COMMENT '登录地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL COMMENT '书名',
  `author` varchar(255) NOT NULL COMMENT '作者',
  `user_id` bigint(20) NOT NULL COMMENT '读者用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;