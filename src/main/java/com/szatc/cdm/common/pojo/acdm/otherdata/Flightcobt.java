package com.szatc.cdm.common.pojo.acdm.otherdata;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import java.util.Calendar;

/**
 * 航班COBT信息
 *
 * @author liuweijian
 * @date 2017/1/2
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Flightcobt {
    @NotNest
    @Valid
    private FlightKeyType flightKey;
    private Calendar cobt;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getCobt() {
        return cobt;
    }

    public void setCobt(Calendar cobt) {
        this.cobt = cobt;
    }
}
