package com.cb.berryz.vaderbeapi.application.service;

import com.cb.berryz.vaderbeapi.application.repository.RoomRepository;
import com.cb.berryz.vaderbeapi.domain.model.RoomModel;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getAllRoom(@NonNull final Integer gameId) {
        return roomRepository.getAllRoom(gameId);
    }

}
