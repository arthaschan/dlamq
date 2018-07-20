package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.DelayCodeType;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班延误信息更新
 *
 * @author liuweijian
 * @date 2017/12/26
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Fltdelinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private DelayCodeType delayReason;
    private Calendar delayTime;
    private String delayDesc;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public DelayCodeType getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(DelayCodeType delayReason) {
        this.delayReason = delayReason;
    }

    public Calendar getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Calendar delayTime) {
        this.delayTime = delayTime;
    }

    public String getDelayDesc() {
        return delayDesc;
    }

    public void setDelayDesc(String delayDesc) {
        this.delayDesc = delayDesc;
    }
}
