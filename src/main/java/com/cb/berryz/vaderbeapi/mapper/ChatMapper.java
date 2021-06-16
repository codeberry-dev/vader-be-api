package com.cb.berryz.vaderbeapi.mapper;

import com.cb.berryz.vaderbeapi.entity.Chat;
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

import static com.cb.berryz.vaderbeapi.mapper.ChatDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public interface ChatMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(chatId, roomId, userId, text, createDate);

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
    int insert(InsertStatementProvider<Chat> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Chat> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ChatResult", value = {
        @Result(column="chat_id", property="chatId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="room_id", property="roomId", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Chat> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ChatResult")
    Optional<Chat> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(Long chatId_) {
        return delete(c -> 
            c.where(chatId, isEqualTo(chatId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(Chat record) {
        return MyBatis3Utils.insert(this::insert, record, chat, c ->
            c.map(chatId).toProperty("chatId")
            .map(roomId).toProperty("roomId")
            .map(userId).toProperty("userId")
            .map(text).toProperty("text")
            .map(createDate).toProperty("createDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Chat> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, chat, c ->
            c.map(chatId).toProperty("chatId")
            .map(roomId).toProperty("roomId")
            .map(userId).toProperty("userId")
            .map(text).toProperty("text")
            .map(createDate).toProperty("createDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Chat record) {
        return MyBatis3Utils.insert(this::insert, record, chat, c ->
            c.map(chatId).toPropertyWhenPresent("chatId", record::getChatId)
            .map(roomId).toPropertyWhenPresent("roomId", record::getRoomId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(text).toPropertyWhenPresent("text", record::getText)
            .map(createDate).toPropertyWhenPresent("createDate", record::getCreateDate)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Chat> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Chat> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Chat> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Chat> selectByPrimaryKey(Long chatId_) {
        return selectOne(c ->
            c.where(chatId, isEqualTo(chatId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, chat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Chat record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(chatId).equalTo(record::getChatId)
                .set(roomId).equalTo(record::getRoomId)
                .set(userId).equalTo(record::getUserId)
                .set(text).equalTo(record::getText)
                .set(createDate).equalTo(record::getCreateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Chat record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(chatId).equalToWhenPresent(record::getChatId)
                .set(roomId).equalToWhenPresent(record::getRoomId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(text).equalToWhenPresent(record::getText)
                .set(createDate).equalToWhenPresent(record::getCreateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Chat record) {
        return update(c ->
            c.set(roomId).equalTo(record::getRoomId)
            .set(userId).equalTo(record::getUserId)
            .set(text).equalTo(record::getText)
            .set(createDate).equalTo(record::getCreateDate)
            .where(chatId, isEqualTo(record::getChatId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Chat record) {
        return update(c ->
            c.set(roomId).equalToWhenPresent(record::getRoomId)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(text).equalToWhenPresent(record::getText)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .where(chatId, isEqualTo(record::getChatId))
        );
    }
}