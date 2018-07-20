package com.szatc.cdm.common.pojo.dlcdm.gos;

import com.szatc.cdm.common.adapter.CalendarAdapterXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;

/**
 * 航班开始登机信息更新
 *
 * @author liuweijian
 * @date 2017/12/25
 */
@XmlRootElement(name = "MSG")
public class Pok {


//    @NotNull
//    @Length(max = 10)
//    private String code;
//    @Length(max = 10)
//    private String soapStatus = "0";
//    @Length(max = 50)
//    @Pattern(regexp = "(1|2)", message = "非有效取值范围")


    private String  id;

    /**
     * 航班业务主键
     */
    private String bizkey;

    /**
     * 航班发布状态ID
     */
    private Integer statusId ;

    /**
     * 实际登机结束时间
     */
    private Calendar realPokTime;

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "BIZKEY")
    public String getBizkey() {
        return bizkey;
    }

    public void setBizkey(String bizkey) {
        this.bizkey = bizkey;
    }

    @XmlElement(name = "STATUSID")
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @XmlElement(name = "REALPOKTIME")
    public Calendar getRealPokTime() {
        return realPokTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setRealPokTime(Calendar realPokTime) {
        this.realPokTime = realPokTime;
    }




}
