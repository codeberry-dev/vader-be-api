package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.CreateRoomRequest;
import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/room")
public class RoomController {

    /**
     * ルーム検索
     * @param gameId ゲームID
     * @return 部屋情報一覧
     */
    @ApiOperation(value = "ルーム一覧取得API",
            notes = "部屋情報の一覧を取得する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    @ResponseBody
    public List<RoomModel> getAllRoom(
            @RequestParam(name = "gameId", required = false) Integer gameId) {

        // 公開フラグが立っているものだけを返す
        // FIXME 一旦、固定値を返している
        RoomModel roomModel = new RoomModel()
                .setGameId(1000)
                .setRoomId(1000)
                .setRoomUrl("http://www.vader/room1234567890")
                .setStatus("00")
                .setPublicFlag(true)
                .setChatDisplayType("00");

        return Collections.singletonList(roomModel);
    }

    /**
     * ルーム作成
     * @param request ルーム作成リクエスト
     * @return ルーム作成情報
     */
    @ApiOperation(value = "ルーム作成API",
            notes = "部屋情報の一覧を取得する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping
    @ResponseBody
    public RoomModel createRoom(@RequestBody @NonNull final CreateRoomRequest request) {

        // FIXME 一旦、固定値を返している
        return new RoomModel()
                .setGameId(1000)
                .setRoomId(1000)
                .setRoomUrl("http://www.vader/room1234567890") // ハッシュ値でBEで生成
                .setStatus("00")
                .setPublicFlag(true)
                .setChatDisplayType("00");

    }
}
