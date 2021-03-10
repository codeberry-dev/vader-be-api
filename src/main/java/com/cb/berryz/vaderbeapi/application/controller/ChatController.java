package com.cb.berryz.vaderbeapi.application.controller;

import com.cb.berryz.vaderbeapi.application.request.ChatMessageRequest;
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
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/v1/chat")
public class ChatController {

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
    @PostMapping
    @MessageMapping("/postmessage")
    @SendTo("/game/match")
    @ResponseBody
    public ChatModel postMessage(@RequestBody @NonNull final ChatMessageRequest request) {

        ChatModel chatModel = new ChatModel();
        chatModel.setRoomId(1000);
        chatModel.setMessage("こんにちは！");
        chatModel.setUserId(1000);
        chatModel.setUserName("ユーザーA");
        return chatModel;

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
    @GetMapping
    @ResponseBody
    public List<ChatModel> getChatInfo(
            @RequestParam(name = "roomId", required = false) Integer roomId) {

        ChatModel chatModel1 = new ChatModel();
        chatModel1.setMessage("こんにちは！");
        chatModel1.setUserId(1000);
        chatModel1.setUserName("ユーザーA");

        ChatModel chatModel2 = new ChatModel();
        chatModel2.setMessage("はじめまして！");
        chatModel2.setUserId(2000);
        chatModel2.setUserName("ユーザーB");

        return Arrays.asList(chatModel1, chatModel2);

    }

}
