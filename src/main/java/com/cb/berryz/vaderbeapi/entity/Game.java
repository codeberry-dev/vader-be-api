package com.cb.berryz.vaderbeapi.entity;

import java.util.Date;

/**
 * Table: game
 */
public class Game {
    /**
     * Column: game_id
     * Remark: ゲームID
     */
    private Long gameId;

    /**
     * Column: game_name
     * Remark: ゲーム名
     */
    private String gameName;

    /**
     * Column: game_type
     * Remark: ゲーム種別
     */
    private String gameType;

    /**
     * Column: min_participants
     * Remark: 最低参加人数
     */
    private Long minParticipants;

    /**
     * Column: max_participants
     * Remark: 最高参加人数
     */
    private Long maxParticipants;

    /**
     * Column: create_date
     * Remark: 作成日
     */
    private Date createDate;

    /**
     * Column: update_date
     * Remark: 更新日
     */
    private Date updateDate;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType == null ? null : gameType.trim();
    }

    public Long getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(Long minParticipants) {
        this.minParticipants = minParticipants;
    }

    public Long getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Long maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}