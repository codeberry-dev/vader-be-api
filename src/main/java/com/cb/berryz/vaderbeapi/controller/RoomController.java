package com.cb.berryz.vaderbeapi.controller;

import com.cb.berryz.vaderbeapi.controller.model.RoomModel;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/room")
public class RoomController {

    /**
     * 部屋検索
     *
     * @return 部屋情報一覧
     */
    @ApiResponses({
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    @ResponseBody
    public List<RoomModel> getAllRoom() {

        // FIXME 一旦、固定値を返している
        RoomModel roomModel = new RoomModel()
                .setGameId(1000)
                .setRoomId(1000)
                .setRoomUrl("http://www.vader/room1234567890")
                .setStatus("01");

        return Collections.singletonList(roomModel);
    }

}
