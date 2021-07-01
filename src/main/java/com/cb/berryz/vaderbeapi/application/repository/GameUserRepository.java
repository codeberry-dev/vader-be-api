package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.UserModel;
import com.cb.berryz.vaderbeapi.entity.GameUser;
import com.cb.berryz.vaderbeapi.mapper.custom.GameUserCustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class GameUserRepository {

    private final GameUserCustomMapper gameUserCustomMapper;

    public UserModel createGameUser(@NonNull final UserModel model) {
        final GameUser entity = this.mappingEntity(model);
        this.gameUserCustomMapper.customInsert(entity);
        return this.mappingModel(entity);

    }

    public List<UserModel> getGameUser() {
        return this.gameUserCustomMapper.selectGameUser()
                .stream()
                .map(this::mappingModel)
                .collect(Collectors.toList());

    }

    private GameUser mappingEntity(@NonNull final UserModel model) {
        GameUser entity = new GameUser();
        entity.setGoogleId(model.getGoogleId());
        entity.setUserId(model.getUserId());
        entity.setUserName(model.getUserName());
        entity.setLastUsageDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setCreateDate(new Date());
        return entity;

    }

    private UserModel mappingModel(@NonNull final GameUser entity) {
        return new UserModel()
                .setGoogleId(entity.getGoogleId())
                .setUserId(entity.getUserId().intValue())
                .setUserName(entity.getUserName());

    }

}
