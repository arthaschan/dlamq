package com.szatc.cdm.common.pojo.acdm.otherdata;

import com.google.gson.annotations.JsonAdapter;
import com.szatc.cdm.common.adapter.AcdmMessageBodyAdapter;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * 跑道容量信息
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@JsonAdapter(AcdmMessageBodyAdapter.class)
public class Trackcapa {
    @NotNull(message = "必须有值")
    private String airport;
    @NotNull(message = "必须有值")
    private String runway;
    private String interval;
    @NotNull(message = "必须有值")
    private Calendar startTime;
    private String heading;
    private Calendar endTime;
    private String inCapacity;
    private String outCapacity;
    private String totalCapacity;
    private String runMode;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getRunway() {
        return runway;
    }

    public void setRunway(String runway) {
        this.runway = runway;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public String getInCapacity() {
        return inCapacity;
    }

    public void setInCapacity(String inCapacity) {
        this.inCapacity = inCapacity;
    }

    public String getOutCapacity() {
        return outCapacity;
    }

    public void setOutCapacity(String outCapacity) {
        this.outCapacity = outCapacity;
    }

    public String getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(String totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getRunMode() {
        return runMode;
    }

    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }
}
