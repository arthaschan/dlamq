package com.szatc.ibatis.service.impl;

import com.szatc.ibatis.entity.DlFlightInfo;
import com.szatc.ibatis.mapper.DlFlightInfoMapper;
import com.szatc.ibatis.service.DlFlightInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author liuweijian
 * @date 2018/1/4
 */
@Service
public class DlFlightInfoServiceImpl  implements DlFlightInfoService  {

    private static Logger logger = Logger.getLogger(DlFlightInfoServiceImpl.class);

    @Autowired
    private DlFlightInfoMapper  dlFlightInfoMapper;


    @Override
    public List<DlFlightInfo>getList(Timestamp flightDate)  {
        List<DlFlightInfo> list=new    ArrayList<DlFlightInfo>();
        try {
            list = this.dlFlightInfoMapper.getList(flightDate);

        } catch (Exception ex) {

            logger.error(ex.toString());
        }
        return list;
    }

    @Override
    public int insert(DlFlightInfo entity) {

        try{
            return dlFlightInfoMapper.insert(entity);
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }
        return 0;
    }

    @Override
    public boolean isExist(String id){

        String isExist="";
        try {
            isExist= dlFlightInfoMapper.isExist(id);
            return isExist==null||isExist.isEmpty()?false:true;

        }catch (Exception ex){
            logger.error(ex.toString());
        }

        return  false;
    }

    public int update(DlFlightInfo entity) {
        String isExist="";

        try{
           if( isExist(entity.getId())){
               return dlFlightInfoMapper.update(entity);
           }else{
               return dlFlightInfoMapper.insert(entity);
            }
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }
        return 0;
    }






}
