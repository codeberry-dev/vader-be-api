package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.CreateRoomRequest;
import com.cb.berryz.vaderbeapi.application.request.RoomStatusUpdateRequest;
import com.cb.berryz.vaderbeapi.application.service.RoomService;
import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1")
public class RoomController {

    private final RoomService roomService;

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
    @GetMapping("/{gameId}/rooms")
    @ResponseBody
    public List<RoomModel> getAllRooms(
            @PathVariable(name = "gameId", required = true) Integer gameId) {

        return roomService.getAllRoom(gameId);
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
    @PostMapping("/room")
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

    /**
     * 部屋ステータス更新API
     * @param request 更新用リクエスト
     * @return 部屋情報
     */
    @ApiOperation(value = "部屋ステータス更新API",
            notes = "部屋のステータスを更新しフロントへ返却する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping("/room")
    @MessageMapping("/status")
    @SendTo("/game/match")
    @ResponseBody
    public RoomModel updateStatus(@RequestBody @NonNull final RoomStatusUpdateRequest request) {

        // FIXME 一旦、固定値を返している
        RoomModel roomModel = new RoomModel()
                .setGameId(1000)
                .setRoomId(1000)
                .setRoomUrl("http://www.vader/room1234567890")
                .setStatus("00")
                .setPublicFlag(true)
                .setChatDisplayType("01");

        return roomModel;

    }
}
