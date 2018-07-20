package com.szatc.ibatis.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * CDM报文实体类
 *
 * @author liuweijian
 *
 */
public class DlMsg implements Serializable {

    private String id;
    private Integer version;
    private String type;
    private String subType;
    private String xmlContent;
    private String state;
    private String exception;
    private Timestamp createTime;
    private Timestamp sendTime;
    private String rcvr;
    private String sndr;
    private String seqn;
    private  String seatState;

    public String getSeatState() {
        return seatState;
    }

    public void setSeatState(String seatState) {
        this.seatState = seatState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getXmlContent() {
        return xmlContent;
    }

    public void setXmlContent(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public String getRcvr() {
        return rcvr;
    }

    public void setRcvr(String rcvr) {
        this.rcvr = rcvr;
    }

    public String getSndr() {
        return sndr;
    }

    public void setSndr(String sndr) {
        this.sndr = sndr;
    }

    public String getSeqn() {
        return seqn;
    }

    public void setSeqn(String seqn) {
        this.seqn = seqn;
    }



}
