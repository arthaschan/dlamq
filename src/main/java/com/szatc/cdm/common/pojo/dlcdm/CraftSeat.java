package com.szatc.cdm.common.pojo.dlcdm;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

@XmlRootElement(name = "CRAFTSEAT")
public class CraftSeat {

    /**
     * 机位占用ID
     */
    private  String id;

    /**
     * 机位ID
     */
    private  String seatId;

    /**
     * 机位
     */
    private  String seat;


    private  String craftId;

    /**
    飞机
     */
    private  String craft;

    /**
     * 计划进机位时间
     */
    private Calendar planArvTime;

    /**
     * 实际进机位时间
     */
    private Calendar realArvTime;


    /**
     * 计划出机位
     */
    private Calendar planDepTime;


    /**
     * 实际出机位
     */
    private Calendar realDepTime;


    private String occupyTypeId;

    /**
     * 占用类型
     * PR：主锁右机位
     * P:主机位
     * PL：主锁左机位
     */
    private String occupyType;

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "SEATID")
    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @XmlElement(name = "SEAT")
    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @XmlElement(name = "CRAFTID")
    public String getCraftId() {
        return craftId;
    }

    public void setCraftId(String craftId) {
        this.craftId = craftId;
    }

    @XmlElement(name = "CRAFT")
    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }


    @XmlElement(name = "PLANARVTIME")
    public Calendar getPlanArvTime() {
        return planArvTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setPlanArvTime(Calendar planArvTime) {
        this.planArvTime = planArvTime;
    }

    @XmlElement(name = "REALARVTIME")
    public Calendar getRealArvTime() {
        return realArvTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setRealArvTime(Calendar realArvTime) {
        this.realArvTime = realArvTime;
    }

    @XmlElement(name = "PLANDEPTIME")
    public Calendar getPlanDepTime() {
        return planDepTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setPlanDepTime(Calendar planDepTime) {
        this.planDepTime = planDepTime;
    }

    @XmlElement(name = "REALDEPTIME")
    public Calendar getRealDepTime() {
        return realDepTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setRealDepTime(Calendar realDepTime) {
        this.realDepTime = realDepTime;
    }

    @XmlElement(name = "OCCUPYTYPEID")
    public String getOccupyTypeId() {
        return occupyTypeId;
    }

    public void setOccupyTypeId(String occupyTypeId) {
        this.occupyTypeId = occupyTypeId;
    }

    @XmlElement(name = "OCCUPYTYPE")
    public String getOccupyType() {
        return occupyType;
    }

    public void setOccupyType(String occupyType) {
        this.occupyType = occupyType;
    }
}
