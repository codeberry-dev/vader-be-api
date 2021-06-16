package com.cb.berryz.vaderbeapi.mapper;

import com.cb.berryz.vaderbeapi.entity.GameUser;
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

import static com.cb.berryz.vaderbeapi.mapper.GameUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public interface GameUserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(userId, userName, googleId, lastUsageDate, createDate, updateDate);

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
    int insert(InsertStatementProvider<GameUser> insertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<GameUser> multipleInsertStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="GameUserResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="google_id", property="googleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_usage_date", property="lastUsageDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GameUser> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("GameUserResult")
    Optional<GameUser> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(Long userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(GameUser record) {
        return MyBatis3Utils.insert(this::insert, record, gameUser, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(googleId).toProperty("googleId")
            .map(lastUsageDate).toProperty("lastUsageDate")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<GameUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, gameUser, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(googleId).toProperty("googleId")
            .map(lastUsageDate).toProperty("lastUsageDate")
            .map(createDate).toProperty("createDate")
            .map(updateDate).toProperty("updateDate")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(GameUser record) {
        return MyBatis3Utils.insert(this::insert, record, gameUser, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(googleId).toPropertyWhenPresent("googleId", record::getGoogleId)
            .map(lastUsageDate).toPropertyWhenPresent("lastUsageDate", record::getLastUsageDate)
            .map(createDate).toPropertyWhenPresent("createDate", record::getCreateDate)
            .map(updateDate).toPropertyWhenPresent("updateDate", record::getUpdateDate)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<GameUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<GameUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<GameUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<GameUser> selectByPrimaryKey(Long userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, gameUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(GameUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(googleId).equalTo(record::getGoogleId)
                .set(lastUsageDate).equalTo(record::getLastUsageDate)
                .set(createDate).equalTo(record::getCreateDate)
                .set(updateDate).equalTo(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(GameUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(googleId).equalToWhenPresent(record::getGoogleId)
                .set(lastUsageDate).equalToWhenPresent(record::getLastUsageDate)
                .set(createDate).equalToWhenPresent(record::getCreateDate)
                .set(updateDate).equalToWhenPresent(record::getUpdateDate);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(GameUser record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(googleId).equalTo(record::getGoogleId)
            .set(lastUsageDate).equalTo(record::getLastUsageDate)
            .set(createDate).equalTo(record::getCreateDate)
            .set(updateDate).equalTo(record::getUpdateDate)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(GameUser record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(googleId).equalToWhenPresent(record::getGoogleId)
            .set(lastUsageDate).equalToWhenPresent(record::getLastUsageDate)
            .set(createDate).equalToWhenPresent(record::getCreateDate)
            .set(updateDate).equalToWhenPresent(record::getUpdateDate)
            .where(userId, isEqualTo(record::getUserId))
        );
    }


}