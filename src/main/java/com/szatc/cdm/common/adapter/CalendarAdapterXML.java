package com.szatc.cdm.common.adapter;

import com.szatc.cdm.common.util.DateUtil;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Calendar;

public class CalendarAdapterXML extends XmlAdapter<String,Calendar> {

    /**
     * 字符串变成日历类
     * @param v
     * 由于用的是大连的时间字符串：yyyyMMDD HH:mm:ss
     * @return
     * @throws Exception
     */
    @Override
    public Calendar unmarshal(String v) throws Exception {
        if(v==null||v.isEmpty())
        return null;
        Calendar c=DateUtil.parseCalendar(v);
        return c;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        if(v ==null)
            return null;
        String s= DateUtil.format(v);
        return s;
    }
}
