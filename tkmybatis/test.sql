CREATE TABLE `t_order`
(
    `id`     int NOT NULL AUTO_INCREMENT,
    `ai`     varchar(128) DEFAULT NULL,
    `bi`     varchar(128) DEFAULT NULL,
    `ci`     varchar(128) DEFAULT NULL,
    `remark` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `t_user`
(
    `id`     int NOT NULL AUTO_INCREMENT,
    `name`   varchar(128) DEFAULT NULL,
    `age`    int          DEFAULT '0',
    `job`    varchar(128) DEFAULT NULL,
    `remark` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;