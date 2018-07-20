package com.szatc.cdm.common.util;

import com.szatc.cdm.common.constant.RegxPattern;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author liuweijian
 * @date 2018/1/3
 */
public class DateUtil {
    private static SimpleDateFormat formater =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    private static SimpleDateFormat formaterDl =  new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    /**
     * 日期格式化输出
     * @param calendar
     * @return
     */
    public synchronized static String format(Calendar calendar) {
        Date date = calendar.getTime();
        return DateUtil.formater.format(date);
    }

    /**
     * 日期格式化输出
     * @param time
     * @return
     */
    public synchronized static String format(Timestamp time) {
        return formater.format(time);
    }


    /**
     * 日期格式化输出
     * @param date
     * @return
     */
    public synchronized static String format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return DateUtil.formater.format(date);
    }

    /**
     * 日期格式化输出
     * @param date
     * @return
     */
    public synchronized static String deleteT(String date) {

        String result= date.replace('T',' ');
        return result;
    }


    /**
     * Date转Calendar
     * @return
     */
    public synchronized static Calendar parseCalendar(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 时间字符串转Calendar
     * @return
     */
    public synchronized static Calendar parseCalendar(String strDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        strDate=strDate.trim();
        Date date=null;
        int pattern=-1;//0:普通格式，1：大连格式。 大连格式是：yyyyMMDD，普通格式是：yyyy-MM-dd
        if (RegxPattern.UTC_DATETIME_PATTERN.matcher(strDate).find()) {
            strDate = strDate.replace("T", " ");
            pattern=0;
            date= DateUtil.formater.parse(strDate);
        } else if (RegxPattern.DATE_PATTERN.matcher(strDate).find()) {
            strDate += " 00:00:00";
            pattern=0;
            date= DateUtil.formater.parse(strDate);
        }
        else if (RegxPattern.DL_PKT_DATETIME_PATTERN.matcher(strDate).find()) {
            strDate = strDate.replace("T", " ");
            pattern=1;
            date = DateUtil.formaterDl.parse(strDate);
        } else if (RegxPattern.DL_DATE_PATTERN.matcher(strDate).find()) {
            strDate += " 00:00:00";
            pattern=1;
            date = DateUtil.formaterDl.parse(strDate);
        }
        else if(RegxPattern.DL_DATETIME_PATTERN.matcher(strDate).find()){
            pattern=1;
            date = DateUtil.formaterDl.parse(strDate);
        }
        else if(RegxPattern.LONG_DATETIME_PATTERN.matcher(strDate).find()){
            date=DateUtil.formater.parse(strDate);
        }
        else {
            return null;
        }
        if(date!=null)
            calendar.setTime(date);

        return calendar;
    }

    /**
     * 时间字符串转Calendar
     * @return
     */
    public synchronized static Calendar parseDlCalendar(String strDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        //处理UTC格式为普通格式

        Date date = DateUtil.formaterDl.parse(strDate);
        calendar.setTime(date);
        return calendar;
    }


    /**
     * 获取默认日历
     * @return
     */
    public synchronized static Calendar defaultDlCal(){
        Calendar calendar = Calendar.getInstance();
       try{
           Date date = DateUtil.formaterDl.parse("19000101 00:00:00");
           calendar.setTime(date);
       }
       catch (Exception ex){

       }

        return calendar;
    }

    /**
     * 获取默认日历
     * @return
     */
    public synchronized static Date defaultDate(){

        return  new Date(1990,1,1);
    }


    /**
     * 时间字符串转Date
     * @return
     */
    public synchronized static Date parseDate(String strDate) throws ParseException {

        //处理UTC格式为普通格式
        if (RegxPattern.UTC_DATETIME_PATTERN.matcher(strDate).find()) {
            strDate = strDate.replace("T", " ");
        }
        return DateUtil.formater.parse(strDate);
    }


    /**
     * 获取当前时间
     * @return
     */
    public synchronized  static Timestamp currentTime(){
        Timestamp d=new Timestamp(System.currentTimeMillis());
        return d;
    }

    public synchronized static Calendar parseTimestampToCalendar(Timestamp ts){
        if(ts==null)
            return null;
        try {
            return DateUtil.parseCalendar(format(ts));
        }catch (Exception ex){
            return null;
        }

    }

    public synchronized static Timestamp parseCalendarToTimestamp(Calendar cal)  {
        if(cal==null)
            return null;
        return Timestamp.valueOf(DateUtil.format(cal));
    }
    public synchronized static Timestamp parseDateToTimestamp(Date date)  {
        if(date==null)
            return null;
        return Timestamp.valueOf(DateUtil.format(date));
    }

    /**
     * yyyyMMdd
     * 时间字符串转Date
     * @return
     */
    public synchronized static Date parseShortDate(String strDate) throws ParseException {

        if(strDate==null||strDate.isEmpty())
            return  null;
        return DateUtil.formaterDl.parse(strDate+" 00:00:00");
    }

    /**
     * 获取昨天16:00的时间
     * @return
     */
    public synchronized static Calendar getYesterday16_00() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date date = calendar.getTime();
        SimpleDateFormat formater =  new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = formater.format(date) + " 16:00:00";
        try {
            return parseCalendar(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取1个小时前的时间
     * @return
     */
    public synchronized static Calendar getOneHourBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        return calendar;
    }
}
