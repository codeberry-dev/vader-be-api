package com.cb.berryz.vaderbeapi.mapper.custom;

import com.cb.berryz.vaderbeapi.entity.Room;
import com.cb.berryz.vaderbeapi.mapper.RoomMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.gameId;
import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.publicFlag;
import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.roomId;
import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.status;
import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.updateDate;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RoomCustomMapper extends RoomMapper {

    default List<Room> selectPublicRoomList(Long gameId_) {
        return select(c ->
                c.where(gameId, isEqualTo(gameId_))
                        .and(publicFlag, isEqualTo(true))
        );
    }

    // Mybatis3のinsertを使うと、
    // なぜかオートインクリメントされたIDを設定できなかったので仕方なくinsertベタがき。
    @Insert("insert into room (" +
            "  room_URL," +
            "  game_id," +
            "  status," +
            "  public_flag," +
            "  chat_display_type," +
            "  user_id," +
            "  create_date," +
            "  update_date" +
            ") values (" +
            "  #{room.roomUrl}," +
            "  #{room.gameId}," +
            "  #{room.status}," +
            "  #{room.publicFlag}," +
            "  #{room.chatDisplayType}," +
            "  #{room.userId}," +
            "  #{room.createDate}," +
            "  #{room.updateDate})")
    @Options(useGeneratedKeys=true, keyColumn="room_id", keyProperty="roomId")
    int customInsert(@Param("room") Room room);

    default int updateRoom(Long roomId_, String status_) {
        return update(c ->
                c.set(status).equalTo(status_)
                        .set(updateDate).equalTo(new Date())
                        .where(roomId, isEqualTo(roomId_))
        );
    }

    default Room selectRoomByRoomId(Long roomId_) {
        return select(c ->
                c.where(roomId, isEqualTo(roomId_))).get(0);
    }

}
