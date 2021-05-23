package com.cb.berryz.vaderbeapi.entity;

import java.util.Date;

/**
 * Table: game_progress
 */
public class GameProgress {
    /**
     * Column: game_progress_id
     * Remark: ゲーム進行ID
     */
    private Long gameProgressId;

    /**
     * Column: room_id
     * Remark: 部屋ID
     */
    private Long roomId;

    /**
     * Column: game_progress_info
     * Remark: ゲーム進行情報
     */
    private String gameProgressInfo;

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

    public Long getGameProgressId() {
        return gameProgressId;
    }

    public void setGameProgressId(Long gameProgressId) {
        this.gameProgressId = gameProgressId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getGameProgressInfo() {
        return gameProgressInfo;
    }

    public void setGameProgressInfo(String gameProgressInfo) {
        this.gameProgressInfo = gameProgressInfo == null ? null : gameProgressInfo.trim();
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