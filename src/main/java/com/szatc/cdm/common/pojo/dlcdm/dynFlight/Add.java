package com.szatc.cdm.common.pojo.dlcdm.dynFlight;

import com.szatc.cdm.common.pojo.dlcdm.ConnectFlight;
import com.szatc.cdm.common.pojo.dlcdm.CraftSeat;
import com.szatc.cdm.common.pojo.dlcdm.Seat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 航班新增信息
 * @author liuweijian
 * @date 2017/12/25
 */
@XmlRootElement(name = "MSG")
public class Add {
    //    @XmlElementWrapper(name="CRAFTSEATLST")
//    @XmlElement(name="CRAFTSEAT")
//      <BIZKEY>20150116-ZH9694-O-W/Z-201501162005
//        </BIZKEY>
//
//        <AIRLINE>CA</AIRLINE>
//        <FLIGHTNO>1570</FLIGHTNO>
//        <FLIGHTDATE>20140120</FLIGHTDATE>
//
//        <SEATLST>
//            <SEAT>
//                <SEATID>456</SEATID>
//                <SEATNAME>32</SEATNAME>
//            </SEAT>
//        </SEATLST>

    private String  id;

    /**
     * 航班业务主键 日期 公司二字码 航班号 I/O 航班任务 计划起飞时间/计划降落时间
     */
    private String bizkey;


    private String airline;

    private String flightNo;

    private String flightDate;

    private List<Seat> seatList;

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "BIZKEY")
    public String getBizkey() {
        return bizkey;
    }

    public void setBizkey(String bizkey) {
        this.bizkey = bizkey;
    }

    @XmlElement(name = "AIRLINE")
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @XmlElement(name = "FLIGHTNO")
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    @XmlElement(name = "FLIGHTDATE")
    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    @XmlElementWrapper(name="SEATLST")
    @XmlElement(name="SEAT")
    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }



}
