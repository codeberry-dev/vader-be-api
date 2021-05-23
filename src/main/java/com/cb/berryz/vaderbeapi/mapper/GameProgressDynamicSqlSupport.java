package com.cb.berryz.vaderbeapi.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class GameProgressDynamicSqlSupport {
    public static final GameProgress gameProgress = new GameProgress();

    public static final SqlColumn<Long> gameProgressId = gameProgress.gameProgressId;

    public static final SqlColumn<Long> roomId = gameProgress.roomId;

    public static final SqlColumn<String> gameProgressInfo = gameProgress.gameProgressInfo;

    public static final SqlColumn<Date> createDate = gameProgress.createDate;

    public static final SqlColumn<Date> updateDate = gameProgress.updateDate;

    public static final class GameProgress extends SqlTable {
        public final SqlColumn<Long> gameProgressId = column("game_progress_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roomId = column("room_id", JDBCType.BIGINT);

        public final SqlColumn<String> gameProgressInfo = column("game_progress_info", JDBCType.VARCHAR);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public GameProgress() {
            super("game_progress");
        }
    }
}