package com.szatc.cdm.common.pojo.dlcdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

@XmlRootElement(name = "META")
public  class DlHeader {
    /**
     * 发送人S{1-20}    [0-9][a-z][A-Z][CH]
     */
    private String sndr;

    /**
     * 接收人S{1-20}EMPTY   [0-9][a-z][A-Z][CH]
     */
    private String rcvr;

    /**
     * 消息序号N{1-20} [0-9]
     */
    private String seqn;

    /**
     * 消息类型S{1-8} [0-9][a-z][A-Z]
     */
    private String type;



    /**
     * 消息子类型S{1-8} [0-9][a-z][A-Z]
     */
    private String subType;

    /**发送时间
     * DTF(yyyyMMdd HH:mm:ss)
     */
    private Calendar sendTime;

    @XmlElement(name = "RCVR")
    public String getRcvr() {
        return rcvr;
    }

    public void setRcvr(String rcvr) {
        this.rcvr = rcvr;
    }

    @XmlElement(name = "SEQN")
    public String getSeqn() {
        return seqn;
    }

    public void setSeqn(String seqn) {
        this.seqn = seqn;
    }

    @XmlElement(name = "SENDTIME")
    public Calendar getSendTime() {
        return sendTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setSendTime(Calendar sendTime) {
        this.sendTime = sendTime;
    }


    @XmlElement(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @XmlElement(name = "SNDR")
    public String getSndr() {
        return sndr;
    }

    public void setSndr(String sndr) {
        this.sndr = sndr;
    }

    @XmlElement(name = "SUBTYPE")
    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

}