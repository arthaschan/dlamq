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
 * 航班机务放行信息更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Locrelinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    private Calendar groundDeliveryTime;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public Calendar getGroundDeliveryTime() {
        return groundDeliveryTime;
    }

    public void setGroundDeliveryTime(Calendar groundDeliveryTime) {
        this.groundDeliveryTime = groundDeliveryTime;
    }
}
