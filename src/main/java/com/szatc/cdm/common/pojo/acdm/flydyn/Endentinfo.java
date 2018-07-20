package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * @author liuweijian
 * 航班终止上客信息更新
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Endentinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar stoploadTime;
    private String stoploadDesc;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getStoploadTime() {
        return stoploadTime;
    }

    public void setStoploadTime(Calendar stoploadTime) {
        this.stoploadTime = stoploadTime;
    }

    public String getStoploadDesc() {
        return stoploadDesc;
    }

    public void setStoploadDesc(String stoploadDesc) {
        this.stoploadDesc = stoploadDesc;
    }
}
