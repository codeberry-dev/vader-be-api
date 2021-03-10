package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameMatchProgressRequest {

    @ApiModelProperty(value = "ゲーム進行ID", example = "10001")
    private int gameProgressId;

    @ApiModelProperty(value = "部屋ID", example = "10001")
    private int roomId;

    @ApiModelProperty(value = "ゲーム進行情報", example = "\"{\"user\":\"A\", \"maruBatsu\":\"maru\"}\"")
    private String gameProgressInfo;

    public GameMatchProgressRequest() {
    }

    public GameMatchProgressRequest(int gameProgressId, int roomId, String gameProgressInfo) {
        this.gameProgressId = gameProgressId;
        this.roomId = roomId;
        this.gameProgressInfo = gameProgressInfo;
    }
}
