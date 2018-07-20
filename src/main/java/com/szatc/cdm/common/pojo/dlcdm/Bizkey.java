package com.szatc.cdm.common.pojo.dlcdm;

import java.util.Date;

public class Bizkey {

    private String id;

    private String uuid;

    private String flightNumber;

    private String inOut;

    private String node;

    private Date flightDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }


    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
