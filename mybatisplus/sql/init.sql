CREATE TABLE `user`
(
    `id`    bigint(20) NOT NULL AUTO_INCREMENT,
    `name`  varchar(128) DEFAULT NULL,
    `age`   int(11)      DEFAULT '0',
    `label` varchar(512) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
