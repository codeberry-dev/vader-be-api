package com.cb.berryz.vaderbeapi.application.repository;

import com.cb.berryz.vaderbeapi.domain.model.ChatModel;
import com.cb.berryz.vaderbeapi.entity.Chat;
import com.cb.berryz.vaderbeapi.mapper.custom.ChatCustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ChatRepository {

    private final ChatCustomMapper chatCustomMapper;

    public List<ChatModel> getChat(@NonNull final long roomId) {
        return this.chatCustomMapper.selectChatByRoomId(roomId)
                .stream()
                .map(this::mappingModel)
                .collect(Collectors.toList());
    }

    public ChatModel createChat(@NonNull final ChatModel model) {
        final Chat entity = this.mappingEntity(model);
        this.chatCustomMapper.customInsert(entity);
        return model;

    }

    private Chat mappingEntity(@NonNull final ChatModel model) {
        Chat entity = new Chat();
        entity.setRoomId(model.getRoomId());
        entity.setUserId(model.getUserId());
        entity.setText(model.getMessage());
        entity.setCreateDate(new Date());
        return entity;

    }

    private ChatModel mappingModel(@NonNull final Chat chat) {
        return new ChatModel()
                .setRoomId(chat.getRoomId())
                .setUserId(chat.getUserId())
                .setMessage(chat.getText());

    }

}
