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
 * 航班降落更新
 *
 * @author liuweijian
 * @date 2017
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Laninfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar eldt;
    private Calendar atrseta;
    private Calendar aldt;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getEldt() {
        return eldt;
    }

    public void setEldt(Calendar eldt) {
        this.eldt = eldt;
    }

    public Calendar getAtrseta() {
        return atrseta;
    }

    public void setAtrseta(Calendar atrseta) {
        this.atrseta = atrseta;
    }

    public Calendar getAldt() {
        return aldt;
    }

    public void setAldt(Calendar aldt) {
        this.aldt = aldt;
    }
}
