package com.szatc.ibatis.entity;

import java.io.Serializable;

/**
 * 航空公司
 *
 * @author liuweijian
 *
 */
public class DlAirline implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    private String id;
    private String iata;
    private String icao;
    private String cn;


}
