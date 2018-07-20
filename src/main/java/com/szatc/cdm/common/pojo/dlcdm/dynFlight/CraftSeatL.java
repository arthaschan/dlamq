package com.szatc.cdm.common.pojo.dlcdm.dynFlight;

import com.szatc.cdm.common.pojo.dlcdm.CraftSeat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 航班停机位变更消息
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@XmlRootElement(name = "MSG")
public class CraftSeatL {
//
//
//    <MSG>
//<META>
//<SNDR>FIMS</SNDR>
//<RCVR></RCVR>
//<SEQN>1</SEQN>
//<SENDTIME>20140101 00:00:00</SENDTIME>
//<TYPE>DYNFLIGHT</TYPE>
//<SUBTYPE>CRAFTSEAT</SUBTYPE>
//</META>
//<FLIGHTID>345</FLIGHTID>
//<BIZKEY>20150116-ZH9694-O-W/Z-201501162005</BIZKEY>
// <CRAFTSEATLST>
//    <CRAFTSEAT>
//    <ID>2396</ID>
//    <SEATID>100101</SEATID>
//    <SEAT>32</SEAT>
//    <CRAFTID>100102</CRAFTID>
//    <CRAFT>B1001</CRAFT>
//    <PLANARVTIME>20140128155700</PLANARVTIME>
//    <REALARVTIME>20140128155700</REALARVTIME>
//    <PLANDEPTIME>20140128155700</PLANDEPTIME>
//    <REALDEPTIME>20140128155700</REALDEPTIME>
//    <OCCUPYTYPEID>56790</OCCUPYTYPEID>
//    <OCCUPYTYPE>L</OCCUPYTYPE>
//    </CRAFTSEAT>
//    </CRAFTSEATLST>
//</MSG>
    /**
     * 动态航班信息
     */
    private String  flightId;

    /**
     * 航班业务主键
     */
    private String bizkey;

    /**
     * 停机位列表
     */
    private List<CraftSeat> craftSeatList;

    @XmlElement(name = "FLIGHTID")
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @XmlElement(name = "BIZKEY")
    public String getBizkey() {
        return bizkey;
    }

    public void setBizkey(String bizkey) {
        this.bizkey = bizkey;
    }

    @XmlElementWrapper(name="CRAFTSEATLST")
    @XmlElement(name="CRAFTSEAT")
    public List<CraftSeat> getCraftSeatList() {
        return craftSeatList;
    }

    public void setCraftSeatList(List<CraftSeat> craftSeatList) {
        this.craftSeatList = craftSeatList;
    }
}
