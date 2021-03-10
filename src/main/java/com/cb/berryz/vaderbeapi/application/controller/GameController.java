package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.GameMatchProgressRequest;
import com.cb.berryz.vaderbeapi.domain.model.GameMatchProgressModel;
import com.cb.berryz.vaderbeapi.domain.model.GameModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/game")
public class GameController {

    /**
     * ゲーム検索
     *
     * @return ゲーム情報一覧
     */
    @ApiOperation(value = "ゲーム一覧取得API",
            notes = "ゲームの一覧を取得する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    @ResponseBody
    public List<GameModel> getAllGame() {

        // FIXME 一旦、固定値を返している
        GameModel gameModel = new GameModel()
                .setGameId(1000)
                .setGameName("○×ゲーム")
                .setGameType("00")
                .setMinParticipants(2)
                .setMaxParticipants(2);

        return Collections.singletonList(gameModel);
    }

    /**
     * ゲーム進行API
     *
     * @return ゲーム進行情報
     */
    @ApiOperation(value = "ゲーム進行API",
            notes = "ゲーム進行情報をBEで記録しフロントへ返却する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping
    @MessageMapping("/postgame")
    @SendTo("/game/match")
    @ResponseBody
    public GameMatchProgressModel postGame(@RequestBody @NonNull final GameMatchProgressRequest request) {

        GameMatchProgressModel model = new GameMatchProgressModel();
        model.setGameProgressId(100001);
        model.setRoomId(1000);
        model.setGameProgressInfo("{\"user\":\"A\", \"maruBatsu\":\"maru\"}");
        return model;

    }

}
