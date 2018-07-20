package com.szatc.ibatis.service;

import com.szatc.ibatis.entity.DlFlightInfo;
import com.szatc.ibatis.entity.FlightInfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * ACDM报文数据访问对象
 *
 * @author liuweijian
 * @date 2018/1/4
 */
public interface FlightInfoService   {
    /**
     * 获得航班动态相关数据
     * @return
     * @throws Exception
     */
    List<FlightInfo> getList(Timestamp flightDate) ;


    int update(DlFlightInfo entity);


    /**
     * 获取航班在T_CDM_FLIGHTINFO的主键值。
     * @param flightNumber 3字码格式的航班号
     * @param inOut in/out
     * @param flightDate yyyy-MM-dd HH24:mi:ss 格式
     * @return 如果查询不到，返回“”；
     */
     String searchUuid(String flightNumber, String inOut, Timestamp flightDate);
}
