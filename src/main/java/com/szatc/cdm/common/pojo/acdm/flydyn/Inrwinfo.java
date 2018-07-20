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
 * 航班进入跑道信息更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Inrwinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar inRunwayTime;
    @Pattern(regexp = "(15跑道|33跑道)", message = "非有效取值范围")
    private String runwayInfo;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getInRunwayTime() {
        return inRunwayTime;
    }

    public void setInRunwayTime(Calendar inRunwayTime) {
        this.inRunwayTime = inRunwayTime;
    }

    public String getRunwayInfo() {
        return runwayInfo;
    }

    public void setRunwayInfo(String runwayInfo) {
        this.runwayInfo = runwayInfo;
    }
}
