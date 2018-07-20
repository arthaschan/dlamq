package com.szatc.cdm.common.pojo.cdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

@XmlRootElement(name = "header")
public  class CdmHeader {

//    <CDMMessage xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
//  <header>
//    <trackingId>802e76e4-a603-4ffd-8d30-4979fc87e24f</trackingId>
//    <msgClass>PUBLISH</msgClass>
//    <msgName>CDM008</msgName>
//    <owner>CDM</owner>
//    <sender>ATRS_DEV</sender>
//    <version>2.0</version>
//    <timestamp>2018-04-14T11:16:12</timestamp>
//  </header>

    /**
     *
     */
    private String msgClass;

    /**
     *
     */
    private String msgName;

    /**
     *
     */
    private String owner;

    /**
     *
     */
    private String sender;

    private String version;

    /**发送时间
     * D
     */
    private Calendar timestamp;

    /**
     *
     */
    private String trackingId;

    @XmlElement(name = "trackingId")
    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @XmlElement(name = "msgClass")
    public String getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(String msgClass) {
        this.msgClass = msgClass;
    }

    @XmlElement(name = "msgName")
    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }
    @XmlElement(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @XmlElement(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @XmlElement(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name = "timestamp")
    public Calendar getTimestamp() {
        return timestamp;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

}