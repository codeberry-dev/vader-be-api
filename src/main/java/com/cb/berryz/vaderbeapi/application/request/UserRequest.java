package com.cb.berryz.vaderbeapi.application.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class UserRequest {

    @NotBlank
    @ApiModelProperty(value = "ユーザー名", example = "太郎")
    private String userName;

    @ApiModelProperty(value = "GoogleId", example = "google123")
    private String googleId;

}
