package com.zxf.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/5/4 9:14
 */
public class BaseEntity {
    /**
     *  是否可用
     */
    protected String isEnable;
    /**
     *  创建人
     */
    protected String creator;
    /**
     *  创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected Date createdDate;
    /**
     * 最后更新人员
     */
    protected String modifier;
    /**
     *  最后更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected Date lastUpdatedDate;
    /**
     * SDP用户ID
     */
    protected String sdpUserId;
    /**
     * 并发控制字段
     */
    protected String updateControlId;

    public String getIsEnable() {
        return isEnable;
    }
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModifier() {
        return modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    public String getSdpUserId() {
        return sdpUserId;
    }
    public void setSdpUserId(String sdpUserId) {
        this.sdpUserId = sdpUserId;
    }
    public String getUpdateControlId() {
        return updateControlId;
    }
    public void setUpdateControlId(String updateControlId) {
        this.updateControlId = updateControlId;
    }

}
