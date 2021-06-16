package com.cb.berryz.vaderbeapi.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ChatDynamicSqlSupport {
    public static final Chat chat = new Chat();

    public static final SqlColumn<Long> chatId = chat.chatId;

    public static final SqlColumn<Long> roomId = chat.roomId;

    public static final SqlColumn<Long> userId = chat.userId;

    public static final SqlColumn<String> text = chat.text;

    public static final SqlColumn<Date> createDate = chat.createDate;

    public static final class Chat extends SqlTable {
        public final SqlColumn<Long> chatId = column("chat_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roomId = column("room_id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> text = column("`text`", JDBCType.VARCHAR);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.TIMESTAMP);

        public Chat() {
            super("chat");
        }
    }
}