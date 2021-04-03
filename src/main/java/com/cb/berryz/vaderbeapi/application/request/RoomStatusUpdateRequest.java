package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class RoomStatusUpdateRequest {

    @NotBlank
    @ApiModelProperty(value = "部屋ID", example = "10000")
    private long roomId;

    @NotBlank
    @ApiModelProperty(value = "ステータス", example = "01")
    private String status;

}
