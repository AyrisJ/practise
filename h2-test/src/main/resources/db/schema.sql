/*
 * Copyright 2023 OPPO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT COMMENT '用户记录id',
    `user_id`        int(11) NOT NULL DEFAULT '0' COMMENT '用户id,跟其他系统保持一致',
    `username`       varchar(64)      DEFAULT NULL COMMENT '用户名',
    `password`       varchar(256)     DEFAULT NULL COMMENT '用户密码',
    `is_admin`       int(1)           DEFAULT '0' COMMENT '是否为管理员',
    `icon`           varchar(500)     DEFAULT NULL COMMENT '头像',
    `email`          varchar(100)     DEFAULT NULL COMMENT '邮箱',
    `phone`          varchar(64)      DEFAULT NULL COMMENT '电话',
    `create_time`    datetime         DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime         DEFAULT NULL COMMENT '更新时间',
    `login_time`     datetime         DEFAULT NULL COMMENT '最后登录时间',
    `status`         int(1)           DEFAULT '1' COMMENT '账号启用状态: 0->禁用; 1->启用',
    `scheduler_type` varchar(64)      DEFAULT NULL COMMENT '调度器类型',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_user_username` (`username`, `scheduler_type`) USING BTREE
);

-- ----------------------------
-- 诊断记录
-- ----------------------------
CREATE TABLE `diagnose_record`
(
    `id`             int(11)          NOT NULL AUTO_INCREMENT COMMENT 'id',
    `application_id` varchar(128)              DEFAULT NULL COMMENT '应用ID',
    `message`        text             NULL COMMENT '错误信息',
    `process_info`   text                      DEFAULT NULL COMMENT '诊断进度',
    `status`         TINYINT UNSIGNED not null COMMENT '诊断作业的状态，0表示进行中，1表示成功，2表示失败',
    `heartbeat`      datetime         not null DEFAULT CURRENT_TIMESTAMP COMMENT '心跳时间',
    `created_time`   datetime         not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time`   datetime         not null DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`     int(11)          NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY unique_index_name (application_id, is_deleted)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='诊断记录表';

-- ----------------------------
--单个诊断步骤的结果
-- ----------------------------
CREATE TABLE `diagnose_result`
(
    `id`           int(11)          NOT NULL AUTO_INCREMENT COMMENT 'id',
    `record_id`    int(11)          NOT NULL COMMENT '诊断记录ID',
    `status`       TINYINT UNSIGNED not null COMMENT '诊断作业的状态，0表示进行中，1表示成功，2表示失败',
    `step`         varchar(128)     NOT NULL COMMENT '诊断步骤',
    `message`      text             NULL COMMENT '错误信息',
    `result`       text                      DEFAULT NULL COMMENT '诊断结果',
    `created_time` datetime         not null DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_time` datetime         not null DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`   int(11)          NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='诊断结果表';


-- ----------------------------
-- Table structure for task_syncer_init
-- ----------------------------
CREATE TABLE `task_syncer_init`
(
    is_init int(11) NOT NULL DEFAULT '0' COMMENT 'task_syncer应用是否已初始化： 0 -> 否, 1 -> 是',
    UNIQUE KEY `idx_is_init` (`is_init`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT 'task-syncer应用初始化表';


-- ----------------------------
-- Table structure for task_diagnose_advice
-- ----------------------------
CREATE TABLE `task_diagnosis_advice`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `log_type`        varchar(64)  DEFAULT NULL COMMENT '日志类型',
    `parent_action`   varchar(64)  DEFAULT NULL COMMENT '父节点异常事件',
    `action`          varchar(64)  DEFAULT NULL COMMENT '异常事件',
    `description`     varchar(255) DEFAULT NULL COMMENT '异常事件描述',
    `abnormal_advice` text COMMENT '建议（其中的变量用 {变量名} 表示）',
    `rule`            text COMMENT '匹配规则',
    `variables`       varchar(255) DEFAULT NULL COMMENT '变量名列表( , 为分割符)',
    `category`        varchar(255) DEFAULT NULL COMMENT '异常类型',
    `deleted`         int(11)      DEFAULT '0' COMMENT '是否删除',
    `normal_advice`   varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_logType_action` (`log_type`, `action`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='诊断建议';

-- ----------------------------
-- Table structure for task_datum
-- ----------------------------
CREATE TABLE `task_datum`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT COMMENT '任务执行id',
    `project_name`   varchar(64)  DEFAULT NULL COMMENT '区域',
    `flow_name`      varchar(180) DEFAULT NULL,
    `task_name`      varchar(180) DEFAULT NULL,
    `execution_date` datetime     DEFAULT NULL COMMENT '执行周期',
    `baseline`       text COMMENT '基线树',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT COMMENT ='任务基线运行表';

INSERT INTO `user` (`username`, `password`)
values ('compass', ';7/YkW<6O#6jH#;|Vl%');

INSERT INTO `task_diagnosis_advice`
VALUES (1, 'executor', NULL, 'containerFailed', 'Container失败',
        '{container}失败，诊断信息为{diagnostics}，退出码为{exitStatus}', NULL, 'container,diagnostic,exitCode', 'otherException', 0,
        NULL);
INSERT INTO `task_diagnosis_advice`
VALUES (2, 'executor', '', 'stageFailed', 'Stage失败',
        'Stage{stage}连续{failedNum}次失败，此job彻底失败', NULL, 'stage,failedNum', 'otherException', 0, NULL);
INSERT INTO `task_diagnosis_advice`
VALUES (3, 'executor', '', 'jobFailedOrAbortedException', '任务失败或退出异常', '', NULL, NULL,
        'otherException', 0, NULL);
