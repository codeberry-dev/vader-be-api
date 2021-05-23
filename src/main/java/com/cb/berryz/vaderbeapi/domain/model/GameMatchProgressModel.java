package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameMatchProgressModel {

    @ApiModelProperty(value = "ゲーム進行ID", example = "10001")
    private int gameProgressId;

    @ApiModelProperty(value = "部屋ID", example = "10001")
    private Integer roomId;

    @ApiModelProperty(value = "ゲーム進行情報", example = "\"{\"user\":\"A\", \"maruBatsu\":\"maru\"}\"")
    private String gameProgressInfo;

    public GameMatchProgressModel() {
    }

}
