package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameModel {

    @ApiModelProperty(value = "ゲームID", example = "10000")
    private long gameId;

    @ApiModelProperty(value = "ゲーム名", example = "○×ゲーム")
    private String gameName;

    @ApiModelProperty(value = "ゲーム種別（00:○×ゲーム, 01:五目並べ）", example = "00")
    private String gameType;

    @ApiModelProperty(value = "最低参加人数", example = "2")
    private int minParticipants;

    @ApiModelProperty(value = "最高参加人数", example = "2")
    private int maxParticipants;

}
