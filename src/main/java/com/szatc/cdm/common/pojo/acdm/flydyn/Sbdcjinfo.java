package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
 /* 第二辆摆渡车机位到达更新
 *
 * @author liuweijian
 * @version 2017/12/14.
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Sbdcjinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar secondShuttlebusTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getSecondShuttlebusTime() {
        return secondShuttlebusTime;
    }

    public void setSecondShuttlebusTime(Calendar secondShuttlebusTime) {
        this.secondShuttlebusTime = secondShuttlebusTime;
    }
}
