package com.cb.berryz.vaderbeapi.application.service;

import com.cb.berryz.vaderbeapi.application.repository.GameProgressRepository;
import com.cb.berryz.vaderbeapi.application.repository.GameRepository;
import com.cb.berryz.vaderbeapi.application.request.GameMatchProgressRequest;
import com.cb.berryz.vaderbeapi.domain.model.GameMatchProgressModel;
import com.cb.berryz.vaderbeapi.domain.model.GameModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameProgressRepository gameProgressRepository;

    public List<GameModel> getAllGames() {
        return gameRepository.getAllGames();
    }

    public GameMatchProgressModel createGameProgress(@NonNull final GameMatchProgressRequest request) {
        GameMatchProgressModel model = new GameMatchProgressModel()
                .setGameProgressId(request.getGameProgressId())
                .setRoomId(request.getRoomId())
                .setGameProgressInfo(request.getGameProgressInfo());
        return gameProgressRepository.createGameProgress(model);
    }

    public GameMatchProgressModel getGameProgress(@NonNull final Long gameProgressId) {
        return gameProgressRepository.getGameProgress(gameProgressId);
    }

    public GameMatchProgressModel updateGameProgress(@NonNull final GameMatchProgressRequest request) {
        gameProgressRepository.updateGameProgress(request.getGameProgressId(), request.getGameProgressInfo());
        return new GameMatchProgressModel()
                .setGameProgressId(request.getGameProgressId())
                .setRoomId(request.getRoomId())
                .setGameProgressInfo(request.getGameProgressInfo());
    }

}
