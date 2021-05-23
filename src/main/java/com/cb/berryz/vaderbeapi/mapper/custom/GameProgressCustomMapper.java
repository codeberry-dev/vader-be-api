package com.cb.berryz.vaderbeapi.mapper.custom;

import com.cb.berryz.vaderbeapi.entity.GameProgress;
import com.cb.berryz.vaderbeapi.mapper.GameProgressMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

import static com.cb.berryz.vaderbeapi.mapper.GameProgressDynamicSqlSupport.gameProgressId;
import static com.cb.berryz.vaderbeapi.mapper.GameProgressDynamicSqlSupport.gameProgressInfo;
import static com.cb.berryz.vaderbeapi.mapper.GameProgressDynamicSqlSupport.updateDate;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface GameProgressCustomMapper extends GameProgressMapper {

    // Mybatis3のinsertを使うと、
    // なぜかオートインクリメントされたIDを設定できなかったので仕方なくinsertベタがき。
    @Insert("insert into game_progress (" +
            "  room_id," +
            "  game_progress_info," +
            "  create_date," +
            "  update_date" +
            ") values (" +
            "  #{gameProgress.roomId}," +
            "  #{gameProgress.gameProgressInfo}," +
            "  #{gameProgress.createDate}," +
            "  #{gameProgress.updateDate})")
    @Options(useGeneratedKeys=true, keyColumn="game_progress_id", keyProperty="gameProgressId")
    int customInsert(@Param("gameProgress") GameProgress gameProgress);

    default int updateGameProgressInfo(Long gameProgressId_, String gameProgressInfo_) {
        return update(c ->
                c.set(gameProgressInfo).equalTo(gameProgressInfo_)
                        .set(updateDate).equalTo(new Date())
                        .where(gameProgressId, isEqualTo(gameProgressId_))
        );
    }

    default GameProgress selectGameProgressByGameProgressId(Long gameProgressId_) {
        return select(c ->
                c.where(gameProgressId, isEqualTo(gameProgressId_))).get(0);
    }

}
