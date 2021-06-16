package com.cb.berryz.vaderbeapi.entity;

import java.util.Date;

/**
 * Table: chat
 */
public class Chat {
    /**
     * Column: chat_id
     * Remark: チャットID
     */
    private Long chatId;

    /**
     * Column: room_id
     * Remark: 部屋ID
     */
    private Long roomId;

    /**
     * Column: user_id
     * Remark: ユーザーID
     */
    private Long userId;

    /**
     * Column: text
     * Remark: 文章
     */
    private String text;

    /**
     * Column: create_date
     * Remark: 作成日
     */
    private Date createDate;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}