package com.cb.berryz.vaderbeapi.mapper.custom;

import com.cb.berryz.vaderbeapi.entity.GameUser;
import com.cb.berryz.vaderbeapi.mapper.GameUserMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;

import java.util.List;

@Mapper
public interface GameUserCustomMapper extends GameUserMapper {

    // Mybatis3のinsertを使うと、
    // なぜかオートインクリメントされたIDを設定できなかったので仕方なくinsertベタがき。
    @Insert("insert into game_user (" +
            "  user_id," +
            "  user_name," +
            "  google_id," +
            "  last_usage_date," +
            "  create_date," +
            "  update_date" +
            ") values (" +
            "  #{gameUser.userId}," +
            "  #{gameUser.userName}," +
            "  #{gameUser.googleId}," +
            "  #{gameUser.lastUsageDate}," +
            "  #{gameUser.createDate}," +
            "  #{gameUser.updateDate})")
    @Options(useGeneratedKeys=true, keyColumn="user_id", keyProperty="userId")
    int customInsert(@Param("gameUser") GameUser gameUser);

    default List<GameUser> selectGameUser() {
        // TODO 一旦全件取得しているが、ゆくゆくはjoinで取得したい
        return select(QueryExpressionDSL::where);
    }
}
