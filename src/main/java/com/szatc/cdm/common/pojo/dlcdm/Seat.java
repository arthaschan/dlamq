package com.szatc.cdm.common.pojo.dlcdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

@XmlRootElement(name = "SEAT")
public class Seat {

    /**
     * 机位ID
     */
    private  String seatId;

    /**
     * 机位
     */
    private  String seatName;

    @XmlElement(name = "SEATID")
    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @XmlElement(name = "SEATNAME")
    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

}
