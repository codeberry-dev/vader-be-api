package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChatModel {

    @ApiModelProperty(value = "部屋ID", example = "5000")
    private Integer roomId;

    @ApiModelProperty(value = "ユーザー名", example = "ユーザーA")
    private String userName;

    @ApiModelProperty(value = "メッセージ", example = "こんにちは！")
    private String message;

    @ApiModelProperty(value = "ユーザーID", example = "1000")
    private Integer userId;

    public ChatModel() {
    }

}
