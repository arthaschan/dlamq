package com.szatc.cdm.common.pojo.acdm.flydyn;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
/**
 * 航班开始滑行信息更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Taxinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private String taxiwayCode;
    private Calendar startTaxi;
    private String taxiwayTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public String getTaxiwayCode() {
        return taxiwayCode;
    }

    public void setTaxiwayCode(String taxiwayCode) {
        this.taxiwayCode = taxiwayCode;
    }

    public Calendar getStartTaxi() {
        return startTaxi;
    }

    public void setStartTaxi(Calendar startTaxi) {
        this.startTaxi = startTaxi;
    }

    public String getTaxiwayTime() {
        return taxiwayTime;
    }

    public void setTaxiwayTime(String taxiwayTime) {
        this.taxiwayTime = taxiwayTime;
    }
}
