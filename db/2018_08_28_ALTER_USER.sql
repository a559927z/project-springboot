ALTER TABLE `sb_user`
	ADD COLUMN `user_sex` VARCHAR(10) NULL COMMENT '性别' AFTER `age`;

UPDATE `sb_user` SET `age` = 0;