package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import java.util.Calendar;

/**
 * 保洁开始更新
 *
 * @author liuweijian
 * @version 2017/12/14.
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Bjksinfo {
    @NotNest
    @Valid
    private FlightKeyType flightKey;
    private Calendar cleanStartTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getCleanStartTime() {
        return cleanStartTime;
    }

    public void setCleanStartTime(Calendar cleanStartTime) {
        this.cleanStartTime = cleanStartTime;
    }
}
