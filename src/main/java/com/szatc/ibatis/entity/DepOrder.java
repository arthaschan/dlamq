package com.szatc.ibatis.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * CDM报文实体类
 *
 * @author liuweijian
 *
 */
public class DepOrder  implements Serializable {

    private String fid;
    private String fversion;
    private String fcdmType;
    private String fxmlContent;
    private String fstate;
    private String fexception;
    private Timestamp fcreateTime;
    private String fcreator;
    private String fsender;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFversion()
    {
        return fversion;
    }

    public void setFversion(String fversion)
    {
        this.fversion = fversion;
    }

    public String getFcdmType()
    {
        return fcdmType;
    }

    public void setFcdmType(String fcdmType){
        this.fcdmType = fcdmType;
    }

    public String getFxmlContent()
    {
        return fxmlContent;
    }

    public void setFxmlContent(String fxmlContent){
        this.fxmlContent = fxmlContent;
    }

    public String getFstate()
    {
        return fstate;
    }

    public void setFstate(String fstate){
        this.fstate = fstate;
    }

    public String getFexception()
    {
        return fexception;
    }

    public void setFexception(String fexception){
        this.fexception = fexception;
    }


    public String getFcreator()
    {
        return fcreator;
    }

    public void setFcreator(String fcreator){
        this.fcreator = fcreator;
    }

    public String getFsender()
    {
        return fsender;
    }

    public void setFsender(String fsender){
        this.fsender = fsender;
    }

    public Timestamp getFcreateTime(){
        return fcreateTime;
    }

    public void setFcreateTime(Timestamp fcreateTime) {
        this.fcreateTime = fcreateTime;
    }
}
