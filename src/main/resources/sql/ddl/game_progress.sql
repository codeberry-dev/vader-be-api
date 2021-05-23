CREATE TABLE `game_progress`
(
    `game_progress_id`   BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT  COMMENT 'ゲーム進行ID',
    `room_id`            BIGINT UNSIGNED   NOT NULL                 COMMENT '部屋ID',
    `game_progress_info` VARCHAR(3000)     NULL     COMMENT 'ゲーム進行情報',
    `create_date`        DATETIME          NOT NULL COMMENT '作成日',
    `update_date`        DATETIME          NOT NULL COMMENT '更新日',
    PRIMARY KEY (`game_progress_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'ゲーム進行情報'
  AUTO_INCREMENT = 1000;