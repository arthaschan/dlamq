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
 * 地面席状态更新
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Gmatinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar aircraftentryTime;
    private Calendar Rdy;
    private Calendar handgroundTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getAircraftentryTime() {
        return aircraftentryTime;
    }

    public void setAircraftentryTime(Calendar aircraftentryTime) {
        this.aircraftentryTime = aircraftentryTime;
    }

    public Calendar getRdy() {
        return Rdy;
    }

    public void setRdy(Calendar rdy) {
        Rdy = rdy;
    }

    public Calendar getHandgroundTime() {
        return handgroundTime;
    }

    public void setHandgroundTime(Calendar handgroundTime) {
        this.handgroundTime = handgroundTime;
    }
}
