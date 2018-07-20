package com.szatc.ibatis.service.impl;


import com.szatc.ibatis.entity.DlFlightInfo;
import com.szatc.ibatis.entity.FlightInfo;
import com.szatc.ibatis.mapper.FlightInfoMapper;
import com.szatc.ibatis.service.FlightInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;


/**
 * @author liuweijian
 * @date 2018/1/4
 */
@Service
public class FlightInfoServiceImpl   implements FlightInfoService {

    private static Logger logger = Logger.getLogger(FlightInfoServiceImpl.class);

    @Autowired
    private FlightInfoMapper  flightInfoMapper;


    /**
     *
     * @param flightDate
     * @return
     */
    @Override
    public List<FlightInfo>getList(Timestamp flightDate)  {
        List<FlightInfo> list=new    ArrayList<FlightInfo>();
        try {
            list = flightInfoMapper.getList(flightDate);

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return list;
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public int  update(DlFlightInfo entity) {

        if(entity==null||entity.getUuid()==null||entity.getUuid().isEmpty())
            return 0;
        try {
            return flightInfoMapper.update(entity);

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return 0;
    }


    /**
     * 根据bizkey里的内容查询航班FID
     * @param  flightNumber 、 inOut、flightDate
     * @return
     */
    @Override
    public String searchUuid(String flightNumber,String inOut,Timestamp flightDate){
        Map  map=new HashMap ();
        try {

            map.put("flightNumber",flightNumber);
            map.put("inOut",inOut);
            map.put("flightDate",flightDate);
            return flightInfoMapper.searchUuid(map);
        }
        catch (Exception ex){
            logger.error(ex.toString());
            //此处报异常，就是出现了查询出多个航班的情况
            logger.error("查出多个航班，"+map);
        }
        return "";
    }

}
