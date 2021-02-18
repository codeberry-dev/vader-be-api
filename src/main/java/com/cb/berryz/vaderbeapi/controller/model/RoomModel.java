package com.cb.berryz.vaderbeapi.controller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoomModel {

    @ApiModelProperty(value = "部屋ID", example = "10000")
    private int roomId;

    @ApiModelProperty(value = "部屋URL", example = "http://www.vader/room1234567890")
    private String roomUrl;

    @ApiModelProperty(value = "ゲームID", example = "10000")
    private int gameId;

    @ApiModelProperty(value = "ステータス", example = "00: 作成済、01: 対戦中、02:対戦終了")
    private String status;

}
