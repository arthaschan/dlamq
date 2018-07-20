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
 * 航班计划信息
 *
 * @author liuweijian
 * @version 2017/12/24
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Schinfo {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
    @Pattern(regexp = "(B|G|M|N|S|X|H|Z/P|VIP)", message = "非有效取值范围")
    private String flightType;
    private String aircraftType;
    private String atad;
    private String route;
    private String airlineCode;
    private String regNo;
    @Pattern(regexp = "(00|01|02|03)", message = "非有效取值范围")
    private String flightRange;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAtad(String atad) {
        this.atad = atad;
    }

    public String getAtad() {
        return atad;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(String flightRange) {
        this.flightRange = flightRange;
    }
}
