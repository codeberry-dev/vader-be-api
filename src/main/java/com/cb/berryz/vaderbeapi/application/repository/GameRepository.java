package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.GameModel;
import com.cb.berryz.vaderbeapi.entity.Game;
import com.cb.berryz.vaderbeapi.mapper.custom.GameCustomMapper;
import lombok.NonNull;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GameRepository {

    private final GameCustomMapper gameCustomMapper;

    public GameRepository(GameCustomMapper gameCustomMapper) {
        this.gameCustomMapper = gameCustomMapper;
    }

    public List<GameModel> getAllGames() {
        return this.gameCustomMapper.select(QueryExpressionDSL::where)
                .stream()
                .map(this::mappingGameModel)
                .collect(Collectors.toList());
    }

    private GameModel mappingGameModel(@NonNull final Game game) {
        return new GameModel()
                .setGameId(game.getGameId())
                .setGameName(game.getGameName())
                .setGameType(game.getGameType())
                .setMaxParticipants(game.getMaxParticipants().intValue())
                .setMinParticipants(game.getMinParticipants().intValue());
    }
}
