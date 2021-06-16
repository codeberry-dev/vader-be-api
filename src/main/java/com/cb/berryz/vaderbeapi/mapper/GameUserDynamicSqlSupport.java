package com.cb.berryz.vaderbeapi.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class GameUserDynamicSqlSupport {
    public static final GameUser gameUser = new GameUser();

    public static final SqlColumn<Long> userId = gameUser.userId;

    public static final SqlColumn<String> userName = gameUser.userName;

    public static final SqlColumn<String> googleId = gameUser.googleId;

    public static final SqlColumn<Date> lastUsageDate = gameUser.lastUsageDate;

    public static final SqlColumn<Date> createDate = gameUser.createDate;

    public static final SqlColumn<Date> updateDate = gameUser.updateDate;

    public static final class GameUser extends SqlTable {
        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<String> googleId = column("google_id", JDBCType.VARCHAR);

        public final SqlColumn<Date> lastUsageDate = column("last_usage_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public GameUser() {
            super("game_user");
        }
    }
}