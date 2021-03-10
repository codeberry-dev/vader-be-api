package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatMessageRequest {

    @ApiModelProperty(value = "部屋ID", example = "5000")
    private Integer roomId;

    @ApiModelProperty(value = "メッセージ", example = "こんにちは！")
    private String message;

    @ApiModelProperty(value = "ユーザーID", example = "1000")
    private Integer userId;

    public ChatMessageRequest() {
    }

    public ChatMessageRequest(Integer roomId, String message, Integer userId) {
        this.roomId = roomId;
        this.message = message;
        this.userId = userId;
    }

}
