package com.szatc.cdm.common.pojo.acdm.flyque;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班进港排队序列更新
 *
 * @author liuweijian
 * @date 2017/12/31
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Flyarrque {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private String regNo;
    private Integer finNo;
    private Calendar cldt;
    private Calendar flightOriginDate;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Integer getFinNo() {
        return finNo;
    }

    public void setFinNo(Integer finNo) {
        this.finNo = finNo;
    }

    public Calendar getCldt() {
        return cldt;
    }

    public void setCldt(Calendar cldt) {
        this.cldt = cldt;
    }

    public Calendar getFlightOriginDate() {
        return flightOriginDate;
    }

    public void setFlightOriginDate(Calendar flightOriginDate) {
        this.flightOriginDate = flightOriginDate;
    }
}
