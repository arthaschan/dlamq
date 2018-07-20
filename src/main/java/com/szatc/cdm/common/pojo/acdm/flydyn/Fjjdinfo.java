package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班过交接点时间更新
 *
 * @author liuweijian
 * @version 2017/12/14.
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Fjjdinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private String boundary;
    private Calendar boundaryTime;
    private Calendar boundaryeTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public Calendar getBoundaryTime() {
        return boundaryTime;
    }

    public void setBoundaryTime(Calendar boundaryTime) {
        this.boundaryTime = boundaryTime;
    }

    public Calendar getBoundaryeTime() {
        return boundaryeTime;
    }

    public void setBoundaryeTime(Calendar boundaryeTime) {
        this.boundaryeTime = boundaryeTime;
    }
}
