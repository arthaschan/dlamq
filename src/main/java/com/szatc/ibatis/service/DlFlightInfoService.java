package com.szatc.ibatis.service;

import com.szatc.ibatis.entity.DlFlightInfo;

import java.sql.Timestamp;
import java.util.List;

/**
 * ACDM报文数据访问对象
 *
 * @author liuweijian
 * @date 2018/1/4
 */
public interface DlFlightInfoService  {



    /**
     * 更新T_CDM_DL_Flight表的数据
     * @param entity
     * @return
     */
    int update(DlFlightInfo entity) ;

    /**
     * 获取T_CDM_DL_FLIGHT表的数据
     * @param flightDate
     * @return
     */
    List<DlFlightInfo> getList(Timestamp flightDate);

    /**
     * @return
     * @throws Exception
     */
    int  insert(DlFlightInfo entity) ;


    /**
     * 航班信息是否存在
     * @param id
     * @return
     */
    boolean isExist(String id);

}
