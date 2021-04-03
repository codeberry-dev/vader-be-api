package com.cb.berryz.vaderbeapi.mapper;

import com.cb.berryz.vaderbeapi.entity.Game;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.cb.berryz.vaderbeapi.mapper.GameDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface GameMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(gameId, gameName, gameType, minParticipants, maxParticipants, createDate, updateDate);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Game> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Game> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GameResult", value = {
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="game_name", property="gameName", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_type", property="gameType", jdbcType=JdbcType.VARCHAR),
        @Result(column="min_participants", property="minParticipants", jdbcType=JdbcType.BIGINT),
        @Result(column="max_participants", property="maxParticipants", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Game> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GameResult")
    Optional<Game> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(Long gameId_) {
        return delete(c -> 
            c.where(gameId, isEqualTo(gameId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(Game record) {
        return MyBatis3Utils.insert(this::insert, record, game, c ->
            c.map(gameId).toProperty("gameId")
            .map(gameName).toProperty("gameName")
            .map(gameType).toProperty("gameType")
            .map(minParticipants).toProperty("minParticipants")
            .map(maxParticipants).toProperty("maxParticipants")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Game> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, game, c ->
            c.map(gameId).toProperty("gameId")
            .map(gameName).toProperty("gameName")
            .map(gameType).toProperty("gameType")
            .map(minParticipants).toProperty("minParticipants")
            .map(maxParticipants).toProperty("maxParticipants")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Game record) {
        return MyBatis3Utils.insert(this::insert, record, game, c ->
            c.map(gameId).toPropertyWhenPresent("gameId", record::getGameId)
            .map(gameName).toPropertyWhenPresent("gameName", record::getGameName)
            .map(gameType).toPropertyWhenPresent("gameType", record::getGameType)
            .map(minParticipants).toPropertyWhenPresent("minParticipants", record::getMinParticipants)
            .map(maxParticipants).toPropertyWhenPresent("maxParticipants", record::getMaxParticipants)
            .map(createDate).toPropertyWhenPresent("createDate", record::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", record::getUpdateDate)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Game> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Game> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Game> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Game> selectByPrimaryKey(Long gameId_) {
        return selectOne(c ->
            c.where(gameId, isEqualTo(gameId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, game, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Game record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gameId).equalTo(record::getGameId)
                .set(gameName).equalTo(record::getGameName)
                .set(gameType).equalTo(record::getGameType)
                .set(minParticipants).equalTo(record::getMinParticipants)
                .set(maxParticipants).equalTo(record::getMaxParticipants)
                .set(createDate).equalTo(record::getCreateDate)
                .set(updateDate).equalTo(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Game record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gameId).equalToWhenPresent(record::getGameId)
                .set(gameName).equalToWhenPresent(record::getGameName)
                .set(gameType).equalToWhenPresent(record::getGameType)
                .set(minParticipants).equalToWhenPresent(record::getMinParticipants)
                .set(maxParticipants).equalToWhenPresent(record::getMaxParticipants)
                .set(createDate).equalToWhenPresent(record::getCreateDate)
                .set(updateDate).equalToWhenPresent(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Game record) {
        return update(c ->
            c.set(gameName).equalTo(record::getGameName)
            .set(gameType).equalTo(record::getGameType)
            .set(minParticipants).equalTo(record::getMinParticipants)
            .set(maxParticipants).equalTo(record::getMaxParticipants)
            .set(createDate).equalTo(record::getCreateDate)
            .set(updateDate).equalTo(record::getUpdateDate)
            .where(gameId, isEqualTo(record::getGameId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Game record) {
        return update(c ->
            c.set(gameName).equalToWhenPresent(record::getGameName)
            .set(gameType).equalToWhenPresent(record::getGameType)
            .set(minParticipants).equalToWhenPresent(record::getMinParticipants)
            .set(maxParticipants).equalToWhenPresent(record::getMaxParticipants)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(gameId, isEqualTo(record::getGameId))
        );
    }
}