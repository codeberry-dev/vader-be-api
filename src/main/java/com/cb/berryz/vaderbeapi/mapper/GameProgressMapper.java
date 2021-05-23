package com.cb.berryz.vaderbeapi.mapper;

import com.cb.berryz.vaderbeapi.entity.GameProgress;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.cb.berryz.vaderbeapi.mapper.GameProgressDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public interface GameProgressMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(gameProgressId, roomId, gameProgressInfo, createDate, updateDate);

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
    int insert(InsertStatementProvider<GameProgress> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<GameProgress> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GameProgressResult", value = {
        @Result(column="game_progress_id", property="gameProgressId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT),
        @Result(column="game_progress_info", property="gameProgressInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GameProgress> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GameProgressResult")
    Optional<GameProgress> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(Long gameProgressId_) {
        return delete(c -> 
            c.where(gameProgressId, isEqualTo(gameProgressId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(GameProgress record) {
        return MyBatis3Utils.insert(this::insert, record, gameProgress, c ->
            c.map(gameProgressId).toProperty("gameProgressId")
            .map(roomId).toProperty("roomId")
            .map(gameProgressInfo).toProperty("gameProgressInfo")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<GameProgress> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, gameProgress, c ->
            c.map(gameProgressId).toProperty("gameProgressId")
            .map(roomId).toProperty("roomId")
            .map(gameProgressInfo).toProperty("gameProgressInfo")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(GameProgress record) {
        return MyBatis3Utils.insert(this::insert, record, gameProgress, c ->
            c.map(gameProgressId).toPropertyWhenPresent("gameProgressId", record::getGameProgressId)
            .map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
            .map(gameProgressInfo).toPropertyWhenPresent("gameProgressInfo", record::getGameProgressInfo)
            .map(createDate).toPropertyWhenPresent("createDate", record::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", record::getUpdateDate)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<GameProgress> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<GameProgress> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<GameProgress> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<GameProgress> selectByPrimaryKey(Long gameProgressId_) {
        return selectOne(c ->
            c.where(gameProgressId, isEqualTo(gameProgressId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, gameProgress, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(GameProgress record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gameProgressId).equalTo(record::getGameProgressId)
                .set(roomId).equalTo(record::getRoomId)
                .set(gameProgressInfo).equalTo(record::getGameProgressInfo)
                .set(createDate).equalTo(record::getCreateDate)
                .set(updateDate).equalTo(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GameProgress record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(gameProgressId).equalToWhenPresent(record::getGameProgressId)
                .set(roomId).equalToWhenPresent(record::getRoomId)
                .set(gameProgressInfo).equalToWhenPresent(record::getGameProgressInfo)
                .set(createDate).equalToWhenPresent(record::getCreateDate)
                .set(updateDate).equalToWhenPresent(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(GameProgress record) {
        return update(c ->
            c.set(roomId).equalTo(record::getRoomId)
            .set(gameProgressInfo).equalTo(record::getGameProgressInfo)
            .set(createDate).equalTo(record::getCreateDate)
            .set(updateDate).equalTo(record::getUpdateDate)
            .where(gameProgressId, isEqualTo(record::getGameProgressId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(GameProgress record) {
        return update(c ->
            c.set(roomId).equalToWhenPresent(record::getRoomId)
            .set(gameProgressInfo).equalToWhenPresent(record::getGameProgressInfo)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(gameProgressId, isEqualTo(record::getGameProgressId))
        );
    }


    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(GameProgress record) {
        return update(c ->
            c.set(roomId).equalToWhenPresent(record::getRoomId)
            .set(gameProgresInfo).equalToWhenPresent(record::getGameProgresInfo)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(gameProgressId, isEqualTo(record::getGameProgressId))
        );
    }
}