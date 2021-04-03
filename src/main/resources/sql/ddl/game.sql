CREATE TABLE `game`
(
    `game_id`            BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT  COMMENT 'ゲームID',
    `game_name`          VARCHAR(20)       NOT NULL                 COMMENT 'ゲーム名',
    `game_type`          VARCHAR(2)        NOT NULL                 COMMENT 'ゲーム種別',
    `min_participants`   BIGINT UNSIGNED   NOT NULL COMMENT '最低参加人数',
    `max_participants`   BIGINT UNSIGNED   NOT NULL COMMENT '最高参加人数',
    `create_date`        DATETIME          NOT NULL COMMENT '作成日',
    `update_date`        DATETIME          NOT NULL COMMENT '更新日',
    PRIMARY KEY (`game_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'ゲーム情報'
  AUTO_INCREMENT = 1000;