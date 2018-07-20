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
public class BlockDownTime {

    private String  id;

    /**
     * 航班业务主键
     */
    private String bizkey;



    /**
     * 实际登机时间
     */
    private Calendar blockDownTime;

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



    @XmlElement(name = "BLOCKDOWNTIME")
    public Calendar getBlockDownTime() {
        return blockDownTime;
    }

    @XmlJavaTypeAdapter(value = CalendarAdapterXML.class)
    public void setBlockDownTime(Calendar blockDownTime) {
        this.blockDownTime = blockDownTime;
    }




}
