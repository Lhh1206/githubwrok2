-- auto Generated on 2020-10-16
-- DROP TABLE IF EXISTS `option`;
CREATE TABLE `option`(
	vo_id INT (11) UNIQUE AUTO_INCREMENT COMMENT '自己id',
	vs_id INT (11) NOT NULL DEFAULT -1 COMMENT '主题id',
	vo_option VARCHAR (50) NOT NULL DEFAULT '' COMMENT '选项内容',
	vo_order INT (11) NOT NULL DEFAULT -1 COMMENT '该选项获得的投票数',
	piaoshu INT (11) NOT NULL DEFAULT -1 COMMENT '每个选项的投票总数',
	PRIMARY KEY (vo_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'option';
