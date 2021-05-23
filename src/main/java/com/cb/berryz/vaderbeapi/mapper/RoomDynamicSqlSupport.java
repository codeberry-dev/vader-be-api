package com.cb.berryz.vaderbeapi.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoomDynamicSqlSupport {
    public static final Room room = new Room();

    public static final SqlColumn<Long> roomId = room.roomId;

    public static final SqlColumn<String> roomUrl = room.roomUrl;

    public static final SqlColumn<Long> gameId = room.gameId;

    public static final SqlColumn<String> status = room.status;

    public static final SqlColumn<Boolean> publicFlag = room.publicFlag;

    public static final SqlColumn<String> chatDisplayType = room.chatDisplayType;

    public static final SqlColumn<String> userId = room.userId;

    public static final SqlColumn<Date> createDate = room.createDate;

    public static final SqlColumn<Date> updateDate = room.updateDate;

    public static final class Room extends SqlTable {
        public final SqlColumn<Long> roomId = column("room_id", JDBCType.BIGINT);

        public final SqlColumn<String> roomUrl = column("room_URL", JDBCType.VARCHAR);

        public final SqlColumn<Long> gameId = column("game_id", JDBCType.BIGINT);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> publicFlag = column("public_flag", JDBCType.BIT);

        public final SqlColumn<String> chatDisplayType = column("chat_display_type", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public Room() {
            super("room");
        }
    }
}