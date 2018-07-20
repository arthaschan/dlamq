package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班机场调度登机
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Disinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private String airportLounge;
    private String boardingGate;
    private Calendar fBordingTime;
    private Calendar lBordingTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public String getAirportLounge() {
        return airportLounge;
    }

    public void setAirportLounge(String airportLounge) {
        this.airportLounge = airportLounge;
    }

    public String getBoardingGate() {
        return boardingGate;
    }

    public void setBoardingGate(String boardingGate) {
        this.boardingGate = boardingGate;
    }

    public Calendar getfBordingTime() {
        return fBordingTime;
    }

    public void setfBordingTime(Calendar fBordingTime) {
        this.fBordingTime = fBordingTime;
    }

    public Calendar getlBordingTime() {
        return lBordingTime;
    }

    public void setlBordingTime(Calendar lBordingTime) {
        this.lBordingTime = lBordingTime;
    }
}
