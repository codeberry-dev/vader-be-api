package com.cb.berryz.vaderbeapi.application.service;

import com.cb.berryz.vaderbeapi.application.repository.ChatRepository;
import com.cb.berryz.vaderbeapi.application.repository.GameUserRepository;
import com.cb.berryz.vaderbeapi.application.request.ChatMessageRequest;
import com.cb.berryz.vaderbeapi.domain.model.ChatModel;
import com.cb.berryz.vaderbeapi.domain.model.UserModel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final GameUserRepository gameUserRepository;

    public List<ChatModel> getChat(final long roomId) {
        final Map<Long, String> usersMap = this.gameUserRepository.getGameUser().stream()
                .collect(Collectors.toMap(
                        UserModel::getUserId,
                        UserModel::getUserName));

        return chatRepository.getChat(roomId).stream()
                .map(chat -> chat.setUserName(usersMap.get(chat.getUserId())))
                .collect(Collectors.toList());

    }

    public ChatModel createChat(@NonNull final ChatMessageRequest request) {
        ChatModel model = new ChatModel()
                .setRoomId(request.getRoomId())
                .setMessage(request.getMessage())
                .setUserId(request.getUserId());
        return this.chatRepository.createChat(model);
    }

}
