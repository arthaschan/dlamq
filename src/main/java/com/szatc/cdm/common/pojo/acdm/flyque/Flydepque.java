package com.szatc.cdm.common.pojo.acdm.flyque;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;
import com.szatc.cdm.common.annotation.NotNest;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 航班出港排队序列更新
 *
 * @author liuweijian
 * @date 2017/12/31
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Flydepque {
    @NotNest
    @Valid
    @NotNull(message = "必须有值")
    private FlightKeyType flightKey;
//    protected   String controlPoint;
//    protected   Integer leaveNo;
    private Calendar ctot;
    private Calendar cobt;
//    protected   Calendar codt;
//    protected   String sortStatus;
//    protected   String limitPoint;

    public FlightKeyType getFlightKey() {
        return flightKey;
    }

    public void setFlightKey(FlightKeyType flightKey) {
        this.flightKey = flightKey;
    }

//    public String getControlPoint() {
//        return controlPoint;
//    }
//
//    public void setControlPoint(String controlPoint) {
//        this.controlPoint = controlPoint;
//    }
//
//    public Integer getLeaveNo() {
//        return leaveNo;
//    }
//
//    public void setLeaveNo(Integer leaveNo) {
//        this.leaveNo = leaveNo;
//    }

    public Calendar getCtot() {
        return ctot;
    }

    public void setCtot(Calendar ctot) {
        this.ctot = ctot;
    }

    public Calendar getCobt() {
        return cobt;
    }

    public void setCobt(Calendar cobt) {
        this.cobt = cobt;
    }

//    public Calendar getCodt() {
//        return codt;
//    }
//
//    public void setCodt(Calendar codt) {
//        this.codt = codt;
//    }
//
//    public String getSortStatus() {
//        return sortStatus;
//    }
//
//    public void setSortStatus(String sortStatus) {
//        this.sortStatus = sortStatus;
//    }
//
//    public String getLimitPoint() {
//        return limitPoint;
//    }
//0
    
//    public void setLimitPoint(String limitPoint) {
//        this.limitPoint = limitPoint;
//    }
}
