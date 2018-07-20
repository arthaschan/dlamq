package com.szatc.cdm.common.constant;

import java.util.regex.Pattern;

/**
 * 正则模式
 *
 * @author liuweijian
 * @date 2018/1/6
 */
public interface RegxPattern {
    /**
     * UTC时间格式模式
     */
    Pattern UTC_DATETIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}");


    /**
     *  普通的长格式日期yyyyMMdd HH:MM:SS
     */
    Pattern LONG_DATETIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");


    /**
     * 普通的短格式日期yyyyMMdd
     */
    Pattern SHORT_DATE= Pattern.compile("\\d{4}\\d{2}\\d{2}");

     /**
     * 大连使用的北京时间格式：yyyyMMDD HH:mm:ss
     */
    Pattern DL_PKT_DATETIME_PATTERN=Pattern.compile("\\d{4}\\d{2}\\d{2}T\\d{2}:\\d{2}:\\d{2}");


    /**
     * 大连使用的北京时间格式：yyyyMMDD HH:mm:ss
     */
    Pattern DL_DATETIME_PATTERN=Pattern.compile("\\d{4}\\d{2}\\d{2} \\d{2}:\\d{2}:\\d{2}");


    /**
     * 日期匹配
     */
    Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    /**
     * 大连日期匹配
     */
    Pattern DL_DATE_PATTERN = Pattern.compile("^\\d{4}\\d{2}\\d{2}$");
}
