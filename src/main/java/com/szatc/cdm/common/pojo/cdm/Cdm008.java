package com.szatc.cdm.common.pojo.cdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Calendar;
import java.util.List;

/**
 * 离港排序结果t_cem_orderlog
 */
@XmlRootElement(name = "CDMMessage")
public class Cdm008 {
    private List<Cdm008Flight> message;

    @XmlElementWrapper(name="message")
    @XmlElement(name="flight")
    public List<Cdm008Flight> getMessage() {
        return message;
    }

    public void setMessage(List<Cdm008Flight> message) {
        this.message = message;
    }


    @XmlRootElement(name = "flight")
    public  static class Cdm008Flight {
        private String flightID;
        private String flightNumber;
        private transient String FlightSortState;
        private transient Calendar flightOriginDate;
        private transient Calendar tobt;
        private transient Calendar etot;
        private Calendar intendCloseTime;
        private Calendar pdcflying;
        private transient Calendar startuptime;
        private transient Calendar rdy;
        private transient Calendar codt;
        private transient Calendar c2gTime;
        private transient Calendar eto;
        private transient Calendar taxiStartTime;
        private transient  String pod;
        private transient String points;
        private transient String limitPoints;
        private transient String controlPoint;
        private transient String heading;
        private transient String fix;
        private transient Integer leaveNumber;
        private transient String taxiInterval;
        private transient String islockcobt;
        private transient String unpassFltFlg;
        private transient String taxiWay;


        @XmlAttribute(name = "flightID")
        public String getFlightID() {
            return flightID;
        }

        public void setFlightID(String flightID) {
            this.flightID = flightID;
        }


        @XmlAttribute(name = "flightNumber")
        public String getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        @XmlAttribute(name = "FlightSortState")
        public String getFlightSortState() {
            return FlightSortState;
        }

        public void setFlightSortState(String flightSortState) {
            FlightSortState = flightSortState;
        }

        @XmlAttribute(name = "flightOriginDate")
        public Calendar getFlightOriginDate() {
            return flightOriginDate;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setFlightOriginDate(Calendar flightOriginDate) {
            this.flightOriginDate = flightOriginDate;
        }

        @XmlAttribute(name = "tobt")
        public Calendar getTobt() {
            return tobt;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setTobt(Calendar tobt) {
            this.tobt = tobt;
        }

        @XmlAttribute(name = "etot")
        public Calendar getEtot() {
            return etot;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setEtot(Calendar etot) {
            this.etot = etot;
        }

        @XmlAttribute(name = "intendCloseTime")
        public Calendar getIntendCloseTime() {
            return intendCloseTime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setIntendCloseTime(Calendar intendCloseTime) {
            this.intendCloseTime = intendCloseTime;
        }

        @XmlAttribute(name = "pdcflying")
        public Calendar getPdcflying() {
            return pdcflying;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setPdcflying(Calendar pdcflying) {
            this.pdcflying = pdcflying;
        }

        @XmlAttribute(name = "startuptime")
        public Calendar getStartuptime() {
            return startuptime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setStartuptime(Calendar startuptime) {
            this.startuptime = startuptime;
        }

        @XmlAttribute(name = "rdy")
        public Calendar getRdy() {
            return rdy;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setRdy(Calendar rdy) {
            this.rdy = rdy;
        }

        @XmlAttribute(name = "codt")
        public Calendar getCodt() {
            return codt;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setCodt(Calendar codt) {
            this.codt = codt;
        }

        @XmlAttribute(name = "c2gTime")
        public Calendar getC2gTime() {
            return c2gTime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setC2gTime(Calendar c2gTime) {
            this.c2gTime = c2gTime;
        }

        @XmlAttribute(name = "eto")
        public Calendar getEto() {
            return eto;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setEto(Calendar eto) {
            this.eto = eto;
        }

        @XmlAttribute(name = "taxiStartTime")
        public Calendar getTaxiStartTime() {
            return taxiStartTime;
        }

        @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
        public void setTaxiStartTime(Calendar taxiStartTime) {
            this.taxiStartTime = taxiStartTime;
        }

        @XmlAttribute(name = "pod")
        public String getPod() {
            return pod;
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

        @XmlAttribute(name = "points")
        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        @XmlAttribute(name = "limitPoints")
        public String getLimitPoints() {
            return limitPoints;
        }

        public void setLimitPoints(String limitPoints) {
            this.limitPoints = limitPoints;
        }

        @XmlAttribute(name = "controlPoint")
        public String getControlPoint() {
            return controlPoint;
        }

        public void setControlPoint(String controlPoint) {
            this.controlPoint = controlPoint;
        }

        @XmlAttribute(name = "heading")
        public String getHeading() {
            return heading;
        }

        public void setHeading(String heading) {
            this.heading = heading;
        }

        @XmlAttribute(name = "fix")
        public String getFix() {
            return fix;
        }

        public void setFix(String fix) {
            this.fix = fix;
        }

        @XmlAttribute(name = "leaveNumber")
        public Integer getLeaveNumber() {
            return leaveNumber;
        }

        public void setLeaveNumber(Integer leaveNumber) {
            this.leaveNumber = leaveNumber;
        }

        @XmlAttribute(name = "taxiInterval")
        public String getTaxiInterval() {
            return taxiInterval;
        }

        public void setTaxiInterval(String taxiInterval) {
            this.taxiInterval = taxiInterval;
        }

        @XmlAttribute(name = "islockcobt")
        public String getIslockcobt() {
            return islockcobt;
        }

        public void setIslockcobt(String islockcobt) {
            this.islockcobt = islockcobt;
        }

        @XmlAttribute(name = "unpassFltFlg")
        public String getUnpassFltFlg() {
            return unpassFltFlg;
        }

        public void setUnpassFltFlg(String unpassFltFlg) {
            this.unpassFltFlg = unpassFltFlg;
        }

        @XmlAttribute(name = "taxiWay")
        public String getTaxiWay() {
            return taxiWay;
        }

        public void setTaxiWay(String taxiWay) {
            this.taxiWay = taxiWay;
        }

    }
}
