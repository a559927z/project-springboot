CREATE TABLE `sb_message` (
  `id`      INT(11) NOT NULL,
  `text`    VARCHAR(255) DEFAULT ''
  COMMENT '标题',
  `summary` VARCHAR(255) DEFAULT ''
  COMMENT '概要，摘要，总结',
  `created` DATETIME     DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;


ALTER TABLE `sb_user`
  ADD COLUMN `age` VARCHAR(255) NOT NULL
COMMENT '年龄'
  AFTER `user_name`;

ALTER TABLE `sb_user`
  ALTER `pass_word` DROP DEFAULT;
ALTER TABLE `sb_user`
  CHANGE COLUMN `pass_word` `password` VARCHAR(255) NOT NULL
COMMENT '密码'
  AFTER `nick_name`;