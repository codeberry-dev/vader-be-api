package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatModel {

    @ApiModelProperty(value = "部屋ID", example = "5000")
    private long roomId;

    @ApiModelProperty(value = "ユーザー名", example = "ユーザーA")
    private String userName;

    @ApiModelProperty(value = "メッセージ", example = "こんにちは！")
    private String message;

    @ApiModelProperty(value = "ユーザーID", example = "1000")
    private long userId;

    public ChatModel() {
    }

}
