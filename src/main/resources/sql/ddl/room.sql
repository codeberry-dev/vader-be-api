CREATE TABLE `room`
(
    `room_id`            BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT  COMMENT '部屋ID',
    `room_URL`           VARCHAR(255)      NOT NULL                 COMMENT '部屋URL',
    `game_id`            BIGINT UNSIGNED   NOT NULL                 COMMENT 'ゲームID',
    `status`             VARCHAR(2)        NOT NULL COMMENT 'ステータス',
    `public_flag`        BIT(1)            NOT NULL COMMENT '公開フラグ',
    `chat_display_type`  VARCHAR(2)        NOT NULL COMMENT 'チャット表示区分',
    `user_id`            VARCHAR(60)       NOT NULL COMMENT 'ユーザーID',
    `create_date`        DATETIME          NOT NULL COMMENT '作成日',
    `update_date`        DATETIME          NOT NULL COMMENT '更新日',
    PRIMARY KEY (`room_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '部屋情報'
  AUTO_INCREMENT = 1000;