package com.cb.berryz.vaderbeapi.entity;

import java.util.Date;

/**
 * Table: game_user
 */
public class GameUser {
    /**
     * Column: user_id
     * Remark: ユーザーID
     */
    private Long userId;

    /**
     * Column: user_name
     * Remark: ユーザー名
     */
    private String userName;

    /**
     * Column: google_id
     * Remark: googleID
     */
    private String googleId;

    /**
     * Column: last_usage_date
     * Remark: 最終利用日
     */
    private Date lastUsageDate;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId == null ? null : googleId.trim();
    }

    public Date getLastUsageDate() {
        return lastUsageDate;
    }

    public void setLastUsageDate(Date lastUsageDate) {
        this.lastUsageDate = lastUsageDate;
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