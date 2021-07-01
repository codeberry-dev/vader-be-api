package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.GameMatchProgressModel;
import com.cb.berryz.vaderbeapi.entity.GameProgress;
import com.cb.berryz.vaderbeapi.mapper.custom.GameProgressCustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class GameProgressRepository {

    private final GameProgressCustomMapper gameProgressCustomMapper;

    public int updateGameProgress(
            final long gameProgressId, @NonNull final String gameProgressInfo) {
        return this.gameProgressCustomMapper.updateGameProgressInfo(gameProgressId, gameProgressInfo);
    }

    public GameMatchProgressModel createGameProgress(@NonNull final GameMatchProgressModel model) {
        final GameProgress entity = this.mappingEntityForCreate(model);
        this.gameProgressCustomMapper.customInsert(entity);
        return this.mappingRoomModel(entity);

    }

    public GameMatchProgressModel getGameProgress(@NonNull final Long gameProgressId) {
        return this.mappingRoomModel(this.gameProgressCustomMapper.selectGameProgressByGameProgressId(gameProgressId));
    }

    private GameMatchProgressModel mappingRoomModel(@NonNull final GameProgress entity) {
        return new GameMatchProgressModel()
                .setGameProgressId(entity.getGameProgressId())
                .setRoomId(entity.getRoomId())
                .setGameProgressInfo(entity.getGameProgressInfo());

    }

    private GameProgress mappingEntityForCreate(@NonNull final GameMatchProgressModel model) {
        GameProgress entity = new GameProgress();
        entity.setRoomId(model.getRoomId());
        entity.setGameProgressInfo(model.getGameProgressInfo());
        entity.setUpdateDate(new Date());
        entity.setCreateDate(new Date());
        return entity;

    }


}
