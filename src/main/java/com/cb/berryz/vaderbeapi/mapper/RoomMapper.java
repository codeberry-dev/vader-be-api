package com.cb.berryz.vaderbeapi.mapper;

import com.cb.berryz.vaderbeapi.entity.Room;
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
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.cb.berryz.vaderbeapi.mapper.RoomDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public interface RoomMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(roomId, roomUrl, gameId, status, publicFlag, chatDisplayType, userId, createDate, updateDate);

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
    int insert(InsertStatementProvider<Room> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Room> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RoomResult", value = {
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_URL", property="roomUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="public_flag", property="publicFlag", jdbcType=JdbcType.BIT),
        @Result(column="chat_display_type", property="chatDisplayType", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Room> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RoomResult")
    Optional<Room> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(Long roomId_) {
        return delete(c -> 
            c.where(roomId, isEqualTo(roomId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(Room record) {
        return MyBatis3Utils.insert(this::insert, record, room, c ->
            c.map(roomId).toProperty("roomId")
            .map(roomUrl).toProperty("roomUrl")
            .map(gameId).toProperty("gameId")
            .map(status).toProperty("status")
            .map(publicFlag).toProperty("publicFlag")
            .map(chatDisplayType).toProperty("chatDisplayType")
            .map(userId).toProperty("userId")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Room> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, room, c ->
            c.map(roomId).toProperty("roomId")
            .map(roomUrl).toProperty("roomUrl")
            .map(gameId).toProperty("gameId")
            .map(status).toProperty("status")
            .map(publicFlag).toProperty("publicFlag")
            .map(chatDisplayType).toProperty("chatDisplayType")
            .map(userId).toProperty("userId")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Room record) {
        return MyBatis3Utils.insert(this::insert, record, room, c ->
            c.map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
            .map(roomUrl).toPropertyWhenPresent("roomUrl", record::getRoomUrl)
            .map(gameId).toPropertyWhenPresent("gameId", record::getGameId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(publicFlag).toPropertyWhenPresent("publicFlag", record::getPublicFlag)
            .map(chatDisplayType).toPropertyWhenPresent("chatDisplayType", record::getChatDisplayType)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(createDate).toPropertyWhenPresent("createDate", record::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", record::getUpdateDate)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Room> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Room> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Room> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Room> selectByPrimaryKey(Long roomId_) {
        return selectOne(c ->
            c.where(roomId, isEqualTo(roomId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, room, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Room record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomId).equalTo(record::getRoomId)
                .set(roomUrl).equalTo(record::getRoomUrl)
                .set(gameId).equalTo(record::getGameId)
                .set(status).equalTo(record::getStatus)
                .set(publicFlag).equalTo(record::getPublicFlag)
                .set(chatDisplayType).equalTo(record::getChatDisplayType)
                .set(userId).equalTo(record::getUserId)
                .set(createDate).equalTo(record::getCreateDate)
                .set(updateDate).equalTo(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Room record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(roomId).equalToWhenPresent(record::getRoomId)
                .set(roomUrl).equalToWhenPresent(record::getRoomUrl)
                .set(gameId).equalToWhenPresent(record::getGameId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(publicFlag).equalToWhenPresent(record::getPublicFlag)
                .set(chatDisplayType).equalToWhenPresent(record::getChatDisplayType)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(createDate).equalToWhenPresent(record::getCreateDate)
                .set(updateDate).equalToWhenPresent(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Room record) {
        return update(c ->
            c.set(roomUrl).equalTo(record::getRoomUrl)
            .set(gameId).equalTo(record::getGameId)
            .set(status).equalTo(record::getStatus)
            .set(publicFlag).equalTo(record::getPublicFlag)
            .set(chatDisplayType).equalTo(record::getChatDisplayType)
            .set(userId).equalTo(record::getUserId)
            .set(createDate).equalTo(record::getCreateDate)
            .set(updateDate).equalTo(record::getUpdateDate)
            .where(roomId, isEqualTo(record::getRoomId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Room record) {
        return update(c ->
            c.set(roomUrl).equalToWhenPresent(record::getRoomUrl)
            .set(gameId).equalToWhenPresent(record::getGameId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(publicFlag).equalToWhenPresent(record::getPublicFlag)
            .set(chatDisplayType).equalToWhenPresent(record::getChatDisplayType)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(roomId, isEqualTo(record::getRoomId))
        );
    }


}