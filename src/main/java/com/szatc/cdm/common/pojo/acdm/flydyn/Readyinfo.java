package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班机组准备完成更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Readyinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar aircrewPreOverTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getAircrewPreOverTime() {
        return aircrewPreOverTime;
    }

    public void setAircrewPreOverTime(Calendar aircrewPreOverTime) {
        this.aircrewPreOverTime = aircrewPreOverTime;
    }
}
