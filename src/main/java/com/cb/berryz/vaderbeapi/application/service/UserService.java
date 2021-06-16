package com.cb.berryz.vaderbeapi.application.service;

import com.cb.berryz.vaderbeapi.application.repository.GameUserRepository;
import com.cb.berryz.vaderbeapi.application.request.UserRequest;
import com.cb.berryz.vaderbeapi.domain.model.UserModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final GameUserRepository gameUserRepository;

    public UserModel createGameUser(@NonNull final UserRequest request) {
        UserModel model = new UserModel()
                .setGoogleId(request.getGoogleId())
                .setUserName(request.getUserName());
        return gameUserRepository.createGameUser(model);
    }

}
