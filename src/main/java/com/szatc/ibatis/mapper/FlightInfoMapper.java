package com.szatc.ibatis.mapper;

import com.szatc.ibatis.entity.DlFlightInfo;
import com.szatc.ibatis.entity.FlightInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * CDM 航班数据
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@Mapper
public interface FlightInfoMapper {

    /**
     *  读取航班动态
     * @param flightDate
     * @return 待读取CDM报文总数
     */
    List<FlightInfo> getList(Timestamp flightDate) ;

    /**
     * 更新航班信息
     * @param entity
     * @return
     */
    int update(DlFlightInfo entity);



    /**
     * 根据bizkey里的内容查询航班FID
     * @param :FFLIGHTNUMBER 、 FENTRANCETYPE、FFLIGHTORIGINDATE
     * @return
     */
    String searchUuid(Map hashMap);
}
