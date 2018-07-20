package com.szatc.cdm.common.pojo.dlcdm.gos;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

/**
 * 航班开始登机信息更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@XmlRootElement(name = "MSG")
public class Bor {
//    <?xml version="1.0" encoding="UTF-8"?>
//<MSG>
//<META>
//<SNDR>GOS</SNDR>
//<RCVR>RGL</RCVR>
//<SEQN>1</SEQN>
//<SENDTIME>20140101 00:00:00</SENDTIME>
//<TYPE>GOS</TYPE>
//<SUBTYPE>BOR</SUBTYPE>
//</META>
//<DFLT>
//<ID>657422</ID>
//<BIZKEY>20150116-ZH9694-O-W/Z-201501162005</BIZKEY>
//<STATUSID>100205</STATUSID>
//<REALBORTIME></REALBORTIME>
//</DFLT>
//</MSG>



    private String  id;

    /**
     * 航班业务主键
     */
    private String bizkey;

    /**
     * 航班发布状态ID
     */
    private Integer statusId ;

    /**
     * 实际登机时间
     */
    private Calendar realBorTime;


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

    @XmlElement(name = "STATUSID")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @XmlElement(name = "REALBORTIME")
    public Calendar getRealBorTime() {
        return realBorTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setRealBorTime(Calendar realBorTime) {
        this.realBorTime = realBorTime;
    }




}
