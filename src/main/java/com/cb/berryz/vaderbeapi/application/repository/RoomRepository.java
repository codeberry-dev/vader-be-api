package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import com.cb.berryz.vaderbeapi.entity.Room;
import com.cb.berryz.vaderbeapi.mapper.custom.RoomCustomMapper;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomRepository {

    private final RoomCustomMapper roomMapper;

    public RoomRepository(RoomCustomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    public List<RoomModel> getAllRoom(@NonNull final Integer gameId) {

        return roomMapper.selectPublicRoomList(gameId.longValue())
                .stream()
                .map(this::mappingRoomModel)
                .collect(Collectors.toList());

    }

    private RoomModel mappingRoomModel(@NonNull final Room room) {
        return new RoomModel()
                .setRoomId(room.getRoomId().intValue())
                .setRoomUrl(room.getRoomUrl())
                .setGameId(room.getGameId().intValue())
                .setStatus(room.getStatus())
                .setPublicFlag(room.getPublicFlag())
                .setChatDisplayType(room.getChatDisplayType());
    }
}
