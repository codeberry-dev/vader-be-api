package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import com.cb.berryz.vaderbeapi.entity.Room;
import com.cb.berryz.vaderbeapi.mapper.custom.RoomCustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomRepository {

    private final RoomCustomMapper roomMapper;

    private static final String GAME_STATUS_CREATED = "00";

    public List<RoomModel> getAllRooms(@NonNull final Integer gameId) {
        return this.roomMapper.selectPublicRoomList(gameId.longValue())
                .stream()
                .map(this::mappingRoomModel)
                .collect(Collectors.toList());

    }

    public RoomModel getRoom(@NonNull final Long roomId) {
        return this.mappingRoomModel(this.roomMapper.selectRoomByRoomId(roomId));

    }

    public RoomModel createRoom(@NonNull final RoomModel roomModel) {
        final Room roomEntity = this.mappingInitialRoomEntity(roomModel);
        this.roomMapper.customInsert(roomEntity);
        return this.mappingRoomModel(roomEntity);

    }

    public int updateRoom(@NonNull final Long roomId, @NonNull final String status) {
        return this.roomMapper.updateRoom(roomId, status);

    }

    private RoomModel mappingRoomModel(@NonNull final Room room) {
        return new RoomModel()
                .setRoomId(room.getRoomId().intValue())
                .setRoomUrl(room.getRoomUrl())
                .setGameId(room.getGameId().intValue())
                .setStatus(room.getStatus())
                .setPublicFlag(room.getPublicFlag())
                .setUserId(room.getUserId())
                .setChatDisplayType(room.getChatDisplayType());

    }

    private Room mappingInitialRoomEntity(@NonNull final RoomModel roomModel) {
        Room room = new Room();
        room.setRoomId(roomModel.getRoomId());
        room.setRoomUrl(roomModel.getRoomUrl());
        room.setGameId(roomModel.getGameId());
        room.setUserId(roomModel.getUserId());
        room.setStatus(GAME_STATUS_CREATED);
        room.setPublicFlag(roomModel.isPublicFlag());
        room.setChatDisplayType(roomModel.getChatDisplayType());
        room.setCreateDate(new Date());
        room.setUpdateDate(new Date());
        return room;

    }
}
