package com.szatc.ibatis.mapper;

import com.szatc.ibatis.entity.DlFlightInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * CDM 航班数据
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@Mapper
public interface DlFlightInfoMapper  {

    /**
     * 插入从大连获取到的数据到T_CDM_DL_FLIGHT表
     * @param entity
     * @return
     */
    int  insert(DlFlightInfo entity) ;

    /**
     * 获取T_CDM_DL_FLIGHT表的数据
     * @param flightDate
     * @return
     */
    List<DlFlightInfo> getList(Timestamp flightDate);

    /**
     * 更新T_CDM_DL_Flight表的数据
     * @param entity
     * @return
     */
    int update(DlFlightInfo entity) ;


    /**
     *
     * @param id
     * @return
     */
    String isExist(String id);

}
