package com.szatc.cdm.common.pojo.acdm.flydyn;
import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班上轮档时间更新
 *
 * @author liuweijian
 * @version 2017/12/14.
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Fsldinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar eibt;
    private Calendar tibt;
    private Calendar cibt;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getEibt() {
        return eibt;
    }

    public void setEibt(Calendar eibt) {
        this.eibt = eibt;
    }

    public Calendar getTibt() {
        return tibt;
    }

    public void setTibt(Calendar tibt) {
        this.tibt = tibt;
    }

    public Calendar getCibt() {
        return cibt;
    }

    public void setCibt(Calendar cibt) {
        this.cibt = cibt;
    }
}
