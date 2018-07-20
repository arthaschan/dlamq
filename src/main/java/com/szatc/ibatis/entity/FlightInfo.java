package com.szatc.ibatis.entity;

import com.szatc.cdm.common.pojo.dlcdm.Bizkey;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.CraftSeatL;
import com.szatc.cdm.common.pojo.dlcdm.gos.BlockDownTime;
import com.szatc.cdm.common.pojo.dlcdm.gos.BlockUpTime;
import com.szatc.cdm.common.pojo.dlcdm.gos.Bor;
import com.szatc.cdm.common.pojo.dlcdm.gos.Pok;
import com.szatc.cdm.common.util.DateUtil;

import java.io.Serializable;
import java.sql.Timestamp;

public class FlightInfo implements Serializable {


    /**
     * T_CDM_FLIGHTINFO的FFlightId 列，对应的是ATRS里的航班表的主键
     */
    private String flightId;
    private String fuid;
    private String flightNo;
    private String adep;
    private String ades;
    private Timestamp sobt;
    private Timestamp sibt;
    private String regNo;
    private String aircraftType;
    private Timestamp aobt;
    private Timestamp aibt;
    private Timestamp atot;
    private String position;
    private String ssr;
    private Timestamp loadTime;
    private Timestamp loadStartTime;
    private Timestamp cldt;
    private Timestamp ctot;
    private Timestamp cobt;
    private Timestamp pushtime;
    private Timestamp asat;
    private String taxiwayCode;
    private Timestamp startTaxi;
    private String runwayInfo;
    private String taxiwayTime;
    private Timestamp tobt;
    private Timestamp artd;
    private Timestamp codt;

    public Timestamp getEtd() {
        return etd;
    }

    public void setEtd(Timestamp etd) {
        this.etd = etd;
    }

    private Timestamp etd;



    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAdep() {
        return adep;
    }

    public void setAdep(String adep) {
        this.adep = adep;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public Timestamp getSobt() {
        return sobt;
    }

    public void setSobt(Timestamp sobt) {
        this.sobt = sobt;
    }

    public Timestamp getSibt() {
        return sibt;
    }

    public void setSibt(Timestamp sibt) {
        this.sibt = sibt;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Timestamp getAobt() {
        return aobt;
    }

    public void setAobt(Timestamp aobt) {
        this.aobt = aobt;
    }

    public Timestamp getAibt() {
        return aibt;
    }

    public void setAibt(Timestamp aibt) {
        this.aibt = aibt;
    }

    public Timestamp getAtot() {
        return atot;
    }

    public void setAtot(Timestamp atot) {
        this.atot = atot;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSsr() {
        return ssr;
    }

    public void setSsr(String ssr) {
        this.ssr = ssr;
    }

    public Timestamp getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Timestamp loadTime) {
        this.loadTime = loadTime;
    }

    public Timestamp getLoadStartTime() {
        return loadStartTime;
    }

    public void setLoadStartTime(Timestamp loadStartTime) {
        this.loadStartTime = loadStartTime;
    }

    public Timestamp getCldt() {
        return cldt;
    }

    public void setCldt(Timestamp cldt) {
        this.cldt = cldt;
    }

    public Timestamp getCtot() {
        return ctot;
    }

    public void setCtot(Timestamp ctot) {
        this.ctot = ctot;
    }

    public Timestamp getCobt() {
        return cobt;
    }

    public void setCobt(Timestamp cobt) {
        this.cobt = cobt;
    }

    public Timestamp getPushtime() {
        return pushtime;
    }

    public void setPushtime(Timestamp pushtime) {
        this.pushtime = pushtime;
    }

    public Timestamp getAsat() {
        return asat;
    }

    public void setAsat(Timestamp asat) {
        this.asat = asat;
    }

    public String getTaxiwayCode() {
        return taxiwayCode;
    }

    public void setTaxiwayCode(String taxiwayCode) {
        this.taxiwayCode = taxiwayCode;
    }

    public Timestamp getStartTaxi() {
        return startTaxi;
    }

    public void setStartTaxi(Timestamp startTaxi) {
        this.startTaxi = startTaxi;
    }

    public String getRunwayInfo() {
        return runwayInfo;
    }

    public void setRunwayInfo(String runwayInfo) {
        this.runwayInfo = runwayInfo;
    }

    public String getTaxiwayTime() {
        return taxiwayTime;
    }

    public void setTaxiwayTime(String taxiwayTime) {
        this.taxiwayTime = taxiwayTime;
    }

    public Timestamp getTobt() {
        return tobt;
    }

    public void setTobt(Timestamp tobt) {
        this.tobt = tobt;
    }

    public Timestamp getArtd() {
        return artd;
    }

    public void setArtd(Timestamp artd) {
        this.artd = artd;
    }

    public Timestamp getCodt() {
        return codt;
    }

    public void setCodt(Timestamp codt) {
        this.codt = codt;
    }



    public  FlightInfo(){

    }


    public  FlightInfo(CraftSeatL entity, Bizkey bizkey){
        this.fuid=bizkey.getUuid();
        if(entity.getCraftSeatList().size()<=0)
            this.position="";
        else {
            this.position = entity.getCraftSeatList().get(0).getCraft();
        }

    }
    public  FlightInfo(BlockDownTime entity, Bizkey bizkey){
        this.fuid=bizkey.getUuid();
        this.aobt= DateUtil.parseCalendarToTimestamp( entity.getBlockDownTime());
    }

    public  FlightInfo(BlockUpTime entity, Bizkey bizkey){
        this.fuid=bizkey.getUuid();
        this.sibt = DateUtil.parseCalendarToTimestamp( entity.getBlockUpTime());
    }

    public  FlightInfo(Bor entity, Bizkey bizkey){
        this.fuid=bizkey.getUuid();
        this.loadStartTime= DateUtil.parseCalendarToTimestamp( entity.getRealBorTime());
    }

    public  FlightInfo(Pok entity, Bizkey bizkey){
        this.fuid=bizkey.getUuid();
        this.loadTime= DateUtil.parseCalendarToTimestamp( entity.getRealPokTime());

    }


    @Override
    public String toString() {
        return "FlightInfo{" +
                "fuid='" + fuid + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", adep='" + adep + '\'' +
                ", sobt='" + sobt + '\'' +
                '}';
    }

}

