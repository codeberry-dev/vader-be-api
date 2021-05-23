package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.GameMatchProgressModel;
import com.cb.berryz.vaderbeapi.entity.GameProgress;
import com.cb.berryz.vaderbeapi.mapper.custom.GameProgressCustomMapper;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class GameProgressRepository {

    private final GameProgressCustomMapper gameProgressCustomMapper;

    public GameProgressRepository(GameProgressCustomMapper gameProgressCustomMapper) {
        this.gameProgressCustomMapper = gameProgressCustomMapper;
    }

    public int updateGameProgress(
            @NonNull final long gameProgressId, @NonNull final String gameProgressInfo) {
        return this.gameProgressCustomMapper.updateGameProgressInfo(gameProgressId, gameProgressInfo);
    }

    public GameMatchProgressModel createGameProgress(@NonNull final GameMatchProgressModel model) {
        final GameProgress entity = this.mappingEntity(model);
        this.gameProgressCustomMapper.customInsert(entity);
        return this.mappingRoomModel(entity);

    }

    public GameMatchProgressModel getGameProgress(@NonNull final Long gameProgressId) {
        return this.mappingRoomModel(this.gameProgressCustomMapper.selectGameProgressByGameProgressId(gameProgressId));
    }

    private GameMatchProgressModel mappingRoomModel(@NonNull final GameProgress entity) {
        return new GameMatchProgressModel()
                .setGameProgressId(entity.getGameProgressId().intValue())
                .setRoomId(entity.getRoomId().intValue())
                .setGameProgressInfo(entity.getGameProgressInfo());

    }

    private GameProgress mappingEntity(@NonNull final GameMatchProgressModel model) {
        GameProgress entity = new GameProgress();
        entity.setGameProgressId((long) model.getGameProgressId());
        entity.setRoomId((long) model.getRoomId());
        entity.setGameProgressInfo(model.getGameProgressInfo());
        entity.setUpdateDate(new Date());
        return entity;

    }


}
