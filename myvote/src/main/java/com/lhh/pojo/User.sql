-- auto Generated on 2020-10-16
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	vu_user_id INT (11) UNIQUE AUTO_INCREMENT COMMENT '自己id',
	vu_user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户名',
	vu_password VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户密码',
	vu_status INT (11) NOT NULL DEFAULT -1 COMMENT '用户角色 1 管理员 2普通用户',
	PRIMARY KEY (vu_user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
