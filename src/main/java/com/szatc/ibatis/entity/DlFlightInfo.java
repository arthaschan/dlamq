package com.szatc.ibatis.entity;

import com.szatc.cdm.common.pojo.dlcdm.Bizkey;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.Add;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.CraftSeatL;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.Modify;
import com.szatc.cdm.common.pojo.dlcdm.gos.BlockDownTime;
import com.szatc.cdm.common.pojo.dlcdm.gos.BlockUpTime;
import com.szatc.cdm.common.pojo.dlcdm.gos.Bor;
import com.szatc.cdm.common.pojo.dlcdm.gos.Pok;
import com.szatc.cdm.common.util.DateUtil;

import java.io.Serializable;
import java.sql.Timestamp;

public class DlFlightInfo implements Serializable {


    private String id;
    private String uuid;
    private String flightNumber;
    private String inOut;
    private String airline;
    private Timestamp pok;


    // 此处不写bor，而写fbor，是因为在写MYBATIS的SQL 语句时候，bor 是 | 的 英文单词。 如同gt 是>的 转义词一样。
//         <if test="bor!=null">    fbor=#{bor},                </if> bor!=null  会识别成 |!=null，就有语法错误了。
    private Timestamp fbor;
    private Timestamp blockDownTime;
    private Timestamp blockUpTime;
    private String seat;
    private Timestamp flightDate;

    public Timestamp getFbor() {
        return fbor;
    }

    public void setFbor(Timestamp fbor) {
        this.fbor = fbor;
    }


    public Timestamp getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Timestamp flightDate) {
        this.flightDate = flightDate;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }



    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Timestamp getPok() {
        return pok;
    }

    public void setPok(Timestamp pok) {
        this.pok = pok;
    }



    public Timestamp getBlockDownTime() {
        return blockDownTime;
    }

    public void setBlockDownTime(Timestamp blockDownTime) {
        this.blockDownTime = blockDownTime;
    }

    public Timestamp getBlockUpTime() {
        return blockUpTime;
    }

    public void setBlockUpTime(Timestamp blockUpTime) {
        this.blockUpTime = blockUpTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }



    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public  DlFlightInfo(){

    }

    public  DlFlightInfo(CraftSeatL entity, Bizkey bizkey){
        this.id=entity.getFlightId();
        this.uuid=bizkey.getUuid();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.inOut=bizkey.getInOut();
        if(entity.getCraftSeatList()==null||entity.getCraftSeatList().size()<=0)
            this.seat="";
        else {
         //   this.seat = entity.getCraftSeatList().get(0).getCraft(); 机型
            this.seat = entity.getCraftSeatList().get(0).getSeat();
        }

    }
    public  DlFlightInfo(BlockDownTime entity, Bizkey bizkey){
        this.id=entity.getId();
        this.uuid=bizkey.getUuid();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.inOut=bizkey.getInOut();
        this.blockDownTime= DateUtil.parseCalendarToTimestamp( entity.getBlockDownTime());


    }

    public  DlFlightInfo(BlockUpTime entity, Bizkey bizkey){
        this.id=entity.getId();
        this.uuid=bizkey.getUuid();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.inOut=bizkey.getInOut();
        this.blockUpTime= DateUtil.parseCalendarToTimestamp( entity.getBlockUpTime());
    }


    public  DlFlightInfo(Add entity,Bizkey bizkey){
        this.id=entity.getId();
        this.airline=entity.getAirline();
        this.inOut=bizkey.getInOut();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.uuid=bizkey.getUuid();
        if(entity.getSeatList()==null||entity.getSeatList().size()<=0){
            this.seat="";
        }else {
            this.seat = entity.getSeatList().get(0).getSeatName();
        }

    }

    public  DlFlightInfo(Modify entity, Bizkey bizkey){
        this.id=entity.getId();
        this.airline=entity.getAirline();
        this.inOut=bizkey.getInOut();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.uuid=bizkey.getUuid();
        if(entity.getSeatList()==null||entity.getSeatList().size()<=0){
            this.seat="";
        }else {
            this.seat = entity.getSeatList().get(0).getSeatName();
        }

    }

    public  DlFlightInfo(Bor entity, Bizkey bizkey){

        this.id=entity.getId();
        this.uuid=bizkey.getUuid();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.inOut=bizkey.getInOut();
        this.fbor= DateUtil.parseCalendarToTimestamp( entity.getRealBorTime());
    }

    public  DlFlightInfo(Pok entity, Bizkey bizkey){
        this.id=entity.getId();
        this.uuid=bizkey.getUuid();
        this.flightDate=DateUtil.parseDateToTimestamp(bizkey.getFlightDate());
        this.flightNumber=bizkey.getFlightNumber();
        this.inOut=bizkey.getInOut();
        this.pok= DateUtil.parseCalendarToTimestamp( entity.getRealPokTime());

    }

    @Override
    public String toString() {
        return "DlFlightInfo{" +
                "fid='" + id + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }

}

