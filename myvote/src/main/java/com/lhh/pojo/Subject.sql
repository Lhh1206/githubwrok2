-- auto Generated on 2020-10-16
-- DROP TABLE IF EXISTS subject;
CREATE TABLE subject(
	vs_id INT (11) UNIQUE AUTO_INCREMENT COMMENT '自己id',
	vs_title VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主题内容',
	vs_type INT (11) NOT NULL DEFAULT -1 COMMENT '选项型 1单选 2多选',
	vo_idd INT (11) NOT NULL DEFAULT -1 COMMENT '选项id数',
	vi_idd INT (11) NOT NULL DEFAULT -1 COMMENT '投票总数',
	PRIMARY KEY (vs_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'subject';
