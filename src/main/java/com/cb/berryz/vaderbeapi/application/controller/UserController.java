package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.UserRequest;
import com.cb.berryz.vaderbeapi.domain.model.UserModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/user")
public class UserController {

    /**
     * ユーザー登録
     * @param request ユーザー作成情報
     * @return ユーザー情報
     */
    @ApiOperation(value = "ユーザー情報登録API",
            notes = "ユーザー情報を登録する（ホーム画面でユーザー情報を登録する際に利用する）",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    @ResponseBody
    public UserModel createUser(@RequestBody @NonNull final UserRequest request) {

        // 公開フラグが立っているものだけを返す
        // FIXME 一旦、固定値を返している
        UserModel model = new UserModel()
                .setUserId(10001)
                .setUserName("太郎")
                .setGoogleId("Google123");

        return model;
    }

}
