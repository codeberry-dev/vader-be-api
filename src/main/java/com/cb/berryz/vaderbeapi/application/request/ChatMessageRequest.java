package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChatMessageRequest {

    @ApiModelProperty(value = "部屋ID", example = "5000")
    private Long roomId;

    @ApiModelProperty(value = "メッセージ", example = "こんにちは！")
    private String message;

    @ApiModelProperty(value = "ユーザーID", example = "1000")
    private Long userId;

    public ChatMessageRequest() {
    }

    public ChatMessageRequest(Long roomId, String message, Long userId) {
        this.roomId = roomId;
        this.message = message;
        this.userId = userId;
    }

}
