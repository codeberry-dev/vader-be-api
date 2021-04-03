package com.cb.berryz.vaderbeapi.application.service;

import com.cb.berryz.vaderbeapi.application.repository.RoomRepository;
import com.cb.berryz.vaderbeapi.application.request.CreateRoomRequest;
import com.cb.berryz.vaderbeapi.application.request.RoomStatusUpdateRequest;
import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Value("${app.vader.room.baseurl}")
    private String baseRoomUrl;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getAllRoom(@NonNull final Integer gameId) {
        return roomRepository.getAllRoom(gameId);
    }

    public RoomModel createRoom(@NonNull final CreateRoomRequest request) {
        return roomRepository.createRoom(this.mappingRoomModel(request));
    }

    public RoomModel updateRoom(@NonNull final RoomStatusUpdateRequest request) {
        roomRepository.updateRoom(request.getRoomId(), request.getStatus());
        return roomRepository.getRoom(request.getRoomId());
    }

    private RoomModel mappingRoomModel(CreateRoomRequest request) {
        return new RoomModel()
                .setRoomUrl(this.generateGameUrl()) // ハッシュ値を生成する
                .setGameId(request.getGameId())
                .setPublicFlag(request.isPublicFlag())
                .setChatDisplayType(request.getChatDisplayType());
    }

    private String generateGameUrl() {
        UUID id = UUID.randomUUID();
        return baseRoomUrl + id.toString();
    }
}
