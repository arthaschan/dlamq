package com.szatc.cdm.common.pojo.acdm.otherdata;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import java.util.Calendar;

/**
 * TOBT协调（快速过站）信息
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Cobtcohere {
    @NotNest
    @Valid
    private FlightKeyType flightKey;
    private Calendar tobt;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getTobt() {
        return tobt;
    }

    public void setTobt(Calendar tobt) {
        this.tobt = tobt;
    }
}
