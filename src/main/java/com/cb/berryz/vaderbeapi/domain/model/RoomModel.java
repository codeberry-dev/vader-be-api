package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoomModel {

    @ApiModelProperty(value = "部屋ID", example = "10000")
    private long roomId;

    @ApiModelProperty(value = "部屋URL", example = "http://www.vader/room1234567890")
    private String roomUrl;

    @ApiModelProperty(value = "ゲームID", example = "10000")
    private long gameId;

    @ApiModelProperty(value = "ステータス(00: 作成済、01: 対戦中、02:対戦終了)",
            example = "00")
    private String status;

    @ApiModelProperty(value = "公開フラグ", example = "true")
    private boolean publicFlag;

    @ApiModelProperty(value = "チャット表示区分(00: 全プレーヤーへ表示、01:プレーヤー以外に表示)",
            example = "00")
    private String chatDisplayType;

    @ApiModelProperty(value = "ユーザーID", example = "100")
    private Long userId;

}
