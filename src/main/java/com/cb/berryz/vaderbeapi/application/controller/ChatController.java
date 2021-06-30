package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.ChatMessageRequest;
import com.cb.berryz.vaderbeapi.application.service.ChatService;
import com.cb.berryz.vaderbeapi.domain.model.ChatModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/v1/chat")
public class ChatController {

    private final ChatService chatService;

    /**
     * チャットAPI
     *
     * @return チャットメッセージ内容
     */
    @ApiOperation(value = "チャットAPI",
            notes = "チャットメッセージをBEで記録しフロントへ返却する",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @MessageMapping("/postmessage")
    @SendTo("/game/match")
    @ResponseBody
    public ChatModel postMessage(@RequestBody @NonNull final ChatMessageRequest request) {

        return this.chatService.createChat(request);

    }

    /**
     * チャット取得API
     *
     * @return チャットメッセージ一覧情報
     */
    @ApiOperation(value = "チャット取得API",
            notes = "チャットメッセージ一覧情報を返却する（チャットの初期表示時に利用する）",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{roomId}")
    @ResponseBody
    public List<ChatModel> getChatInfo(
            @PathVariable(name = "roomId", required = true) @NonNull final Integer roomId) {

        return this.chatService.getChat(roomId);

    }

}
