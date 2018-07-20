package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班起飞更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Offinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar ctot;
    private Calendar etot;
    private Calendar atot;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getCtot() {
        return ctot;
    }

    public void setCtot(Calendar ctot) {
        this.ctot = ctot;
    }

    public Calendar getEtot() {
        return etot;
    }

    public void setEtot(Calendar etot) {
        this.etot = etot;
    }

    public Calendar getAtot() {
        return atot;
    }

    public void setAtot(Calendar atot) {
        this.atot = atot;
    }
}
