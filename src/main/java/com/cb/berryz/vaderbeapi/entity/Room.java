package com.cb.berryz.vaderbeapi.entity;

import java.util.Date;

/**
 * Table: room
 */
public class Room {
    /**
     * Column: room_id
     * Remark: 部屋ID
     */
    private Long roomId;

    /**
     * Column: room_URL
     * Remark: 部屋URL
     */
    private String roomUrl;

    /**
     * Column: game_id
     * Remark: ゲームID
     */
    private Long gameId;

    /**
     * Column: status
     * Remark: ステータス
     */
    private String status;

    /**
     * Column: public_flag
     * Remark: 公開フラグ
     */
    private Boolean publicFlag;

    /**
     * Column: chat_display_type
     * Remark: チャット表示区分
     */
    private String chatDisplayType;

    /**
     * Column: user_id
     * Remark: ユーザーID
     */
    private Long userId;

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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl == null ? null : roomUrl.trim();
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(Boolean publicFlag) {
        this.publicFlag = publicFlag;
    }

    public String getChatDisplayType() {
        return chatDisplayType;
    }

    public void setChatDisplayType(String chatDisplayType) {
        this.chatDisplayType = chatDisplayType == null ? null : chatDisplayType.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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