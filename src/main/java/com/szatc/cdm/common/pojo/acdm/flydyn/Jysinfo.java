package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
/**
 * 加油开始更新
 *
 * @author liuweijian
 * @version 2017/12/14.
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Jysinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar oilStartTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getOilStartTime() {
        return oilStartTime;
    }

    public void setOilStartTime(Calendar oilStartTime) {
        this.oilStartTime = oilStartTime;
    }
}
