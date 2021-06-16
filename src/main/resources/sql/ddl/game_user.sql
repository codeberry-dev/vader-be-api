CREATE TABLE `game_user`
(
    `user_id`         BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT  COMMENT 'ユーザーID',
    `user_name`       VARCHAR(50)       NOT NULL COMMENT 'ユーザー名',
    `google_id`       VARCHAR(50)       NULL     COMMENT 'googleID',
    `last_usage_date` DATETIME          NOT NULL COMMENT '最終利用日',
    `create_date`     DATETIME          NOT NULL COMMENT '作成日',
    `update_date`     DATETIME          NOT NULL COMMENT '更新日',
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'ユーザー情報'
  AUTO_INCREMENT = 1000;