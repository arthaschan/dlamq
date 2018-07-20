package com.szatc.cdm.common.pojo.acdm.selfdefine;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Calendar;

/**
 * @author liuweijian
 * @version 2017/12/23.
 */
public class FlightKeyType {
    private String fuid;
    @NotBlank(message = "必须有值")
    private String flightNo;
    private String adep;
    private Calendar sobt;
    private String ades;
    private Calendar sibt;

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep;
    }

    public Calendar getSobt() {
        return sobt;
    }

    public void setSobt(Calendar sobt) {
        this.sobt = sobt;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public Calendar getSibt() {
        return sibt;
    }

    public void setSibt(Calendar sibt) {
        this.sibt = sibt;
    }
}
