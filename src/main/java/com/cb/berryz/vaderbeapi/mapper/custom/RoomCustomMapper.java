package com.cb.berryz.vaderbeapi.mapper.custom;

import com.cb.berryz.vaderbeapi.entity.Room;
import com.cb.berryz.vaderbeapi.mapper.RoomMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.gameId;
import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.publicFlag;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface RoomCustomMapper extends RoomMapper {

    default List<Room> selectPublicRoomList(Long gameId_) {
        return select(c ->
                c.where(gameId, isEqualTo(gameId_))
                        .and(publicFlag, isEqualTo(true))
        );
    }

}
