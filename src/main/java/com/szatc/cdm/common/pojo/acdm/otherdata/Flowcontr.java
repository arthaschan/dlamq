package com.szatc.cdm.common.pojo.acdm.otherdata;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.List;

/**
 * @author liuweijian
 * 流量控制信息更新
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Flowcontr {
    private String flowId;
    @NotNull(message = "必须有值")
    @Pattern(regexp = "(Y|N)", message = "非有效取值范围")
    private String enabledFlag = "Y";
    private String message;
    @NotNull(message = "必须有值")
    private String controlPoint;
    @NotNull(message = "必须有值")
    private String interval;
    @NotNull(message = "必须有值")
    private Calendar startTime;
    @NotNull(message = "必须有值")
    private Calendar endTime;
    @Valid
    private List<FlightKeyType> flightKeyList;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(String enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(String controlPoint) {
        this.controlPoint = controlPoint;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public List<FlightKeyType> getFlightKeyList() {
        return flightKeyList;
    }

    public void setFlightKeyList(List<FlightKeyType> flightKeyList) {
        this.flightKeyList = flightKeyList;
    }
}
