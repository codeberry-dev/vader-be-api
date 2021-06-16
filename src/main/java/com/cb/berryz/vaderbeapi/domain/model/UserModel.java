package com.cb.berryz.vaderbeapi.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserModel {

    @ApiModelProperty(value = "ユーザーID", example = "10001")
    private long userId;

    @ApiModelProperty(value = "ユーザー名", example = "太郎")
    private String userName;

    @ApiModelProperty(value = "GoogleId", example = "google123")
    private String googleId;

}
