package com.cb.berryz.vaderbeapi.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class GameDynamicSqlSupport {
    public static final Game game = new Game();

    public static final SqlColumn<Long> gameId = game.gameId;

    public static final SqlColumn<String> gameName = game.gameName;

    public static final SqlColumn<String> gameType = game.gameType;

    public static final SqlColumn<Long> minParticipants = game.minParticipants;

    public static final SqlColumn<Long> maxParticipants = game.maxParticipants;

    public static final SqlColumn<Date> createDate = game.createDate;

    public static final SqlColumn<Date> updateDate = game.updateDate;

    public static final class Game extends SqlTable {
        public final SqlColumn<Long> gameId = column("game_id", JDBCType.BIGINT);

        public final SqlColumn<String> gameName = column("game_name", JDBCType.VARCHAR);

        public final SqlColumn<String> gameType = column("game_type", JDBCType.VARCHAR);

        public final SqlColumn<Long> minParticipants = column("min_participants", JDBCType.BIGINT);

        public final SqlColumn<Long> maxParticipants = column("max_participants", JDBCType.BIGINT);

        public final SqlColumn<Date> createDate = column("create_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateDate = column("update_date", JDBCType.TIMESTAMP);

        public Game() {
            super("game");
        }
    }
}