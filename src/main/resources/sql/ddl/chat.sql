CREATE TABLE `chat`
(
    `chat_id`       BIGINT UNSIGNED   NOT NULL AUTO_INCREMENT  COMMENT 'チャットID',
    `room_id`       BIGINT UNSIGNED   NOT NULL                 COMMENT '部屋ID',
    `user_id`       BIGINT UNSIGNED   NOT NULL COMMENT 'ユーザーID',
    `text`          VARCHAR(300)      NOT NULL COMMENT '文章',
    `create_date`   DATETIME          NOT NULL COMMENT '作成日',
    PRIMARY KEY (`chat_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'チャット情報'
  AUTO_INCREMENT = 1000;