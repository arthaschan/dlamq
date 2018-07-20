package com.szatc.ibatis.entity;

import java.sql.Timestamp;

/**
 * CDM报文实体类
 *
 * @author liuweijian
 * @date 2018/1/2
 */
public class CdmMessage {
    private String fid;
    private String fmsg;
    private Timestamp fcreatetime;
    private String msgName;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFmsg() {
        return fmsg;
    }

    public void setFmsg(String fmsg) {
        this.fmsg = fmsg;
    }

    public Timestamp getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Timestamp fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }
}
