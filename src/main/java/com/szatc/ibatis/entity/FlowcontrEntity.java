package com.szatc.ibatis.entity;

import java.sql.Date;

/**
 * 流控数据库模型
 *
 * @author liuweijian
 * @date 2018/3/17
 */
public class FlowcontrEntity {
    private String flowId;
    private String message;
    private Date startTime;
    private Date endTime;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
