package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.GameMatchProgressRequest;
import com.cb.berryz.vaderbeapi.application.service.GameService;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/game")
public class GameController {

    private final GameService gameService;

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
    public List<GameModel> getAllGames() {
        return this.gameService.getAllGames();
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
    @PostMapping("/post")
    @MessageMapping("/postgame")
    @SendTo("/game/match")
    @ResponseBody
    public GameMatchProgressModel postGame(@RequestBody @NonNull final GameMatchProgressRequest request) {
        return this.gameService.updateGameProgress(request);

    }

    /**
     * ゲーム進行取得API
     *
     * @return ゲーム進行情報
     */
    @ApiOperation(value = "ゲーム進行取得API",
            notes = "ゲーム進行情報を取得する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/progress/{gameProgressId}")
    @ResponseBody
    public GameMatchProgressModel getGameProgress(
            @PathVariable(name = "gameProgressId", required = true) @NonNull final Long gameProgressId) {
        return this.gameService.getGameProgress(gameProgressId);
    }

    /**
     * ゲーム進行登録API
     *
     * @return ゲーム進行情報
     */
    @ApiOperation(value = "ゲーム進行登録API",
            notes = "ゲーム進行情報を登録する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("/progress")
    @ResponseBody
    public GameMatchProgressModel createGameProgress(@RequestBody @NonNull final GameMatchProgressRequest request) {
        return this.gameService.createGameProgress(request);
    }

}
