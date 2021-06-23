package com.cb.berryz.vaderbeapi.mapper.custom;

import com.cb.berryz.vaderbeapi.entity.Chat;
import com.cb.berryz.vaderbeapi.mapper.ChatMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import static com.cb.berryz.vaderbeapi.mapper.GameProgressDynamicSqlSupport.roomId;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ChatCustomMapper extends ChatMapper {

    // Mybatis3のinsertを使うと、
    // なぜかオートインクリメントされたIDを設定できなかったので仕方なくinsertベタがき。
    @Insert("insert into chat (" +
            "  chat_id," +
            "  room_id," +
            "  user_id," +
            "  text," +
            "  create_date" +
            ") values (" +
            "  #{chat.chatId}," +
            "  #{chat.roomId}," +
            "  #{chat.userId}," +
            "  #{chat.text}," +
            "  #{chat.createDate})")
    @Options(useGeneratedKeys=true, keyColumn="chat_id", keyProperty="chatId")
    int customInsert(@Param("chat") Chat chat);

    default List<Chat> selectChatByRoomId(Long roomId_) {
        return select(c ->
                c.where(roomId, isEqualTo(roomId_)));
    }

}
