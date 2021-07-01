package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class CreateRoomRequest {

    @ApiModelProperty(value = "ゲームID", example = "10001")
    private long gameId;

    @NotBlank
    @ApiModelProperty(value = "公開フラグ", example = "true")
    private boolean publicFlag;

    @NotBlank
    @ApiModelProperty(value = "チャット表示区分（00:全プレーヤー, 01:プレーヤー以外に表示）", example = "00")
    private String chatDisplayType;

    @ApiModelProperty(value = "ユーザーID", example = "100")
    private Long userId;

}
