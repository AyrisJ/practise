CREATE DATABASE `order0`;
CREATE DATABASE `order1`;

CREATE TABLE `t_order_0`
(
    `id`     varchar(64) NOT NULL DEFAULT '',
    `seq_no` varchar(64) NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE `t_order_1`
(
    `id`     varchar(64) NOT NULL DEFAULT '',
    `seq_no` varchar(64) NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
CREATE TABLE `t_order_2`
(
    `id`     varchar(64) NOT NULL DEFAULT '',
    `seq_no` varchar(64) NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;