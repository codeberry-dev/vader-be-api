package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserParticipantModel {

    @ApiModelProperty(value = "部屋参加ID", example = "10001")
    private int roomParticipantId;

    @ApiModelProperty(value = "部屋ID", example = "10001")
    private int roomId;

    @ApiModelProperty(value = "ユーザーID", example = "10001")
    private Integer userId;





}
