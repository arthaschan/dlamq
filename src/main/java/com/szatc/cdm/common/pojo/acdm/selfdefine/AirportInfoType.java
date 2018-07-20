package com.szatc.cdm.common.pojo.acdm.selfdefine;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liuweijian
 * @version 2017/12/23.
 */
public class AirportInfoType {
    @NotBlank(message = "必须有值")
    private String airportcode;
    private String Information;

    public String getAirportcode() {
        return airportcode;
    }

    public void setAirportcode(String airportcode) {
        this.airportcode = airportcode;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }
}
