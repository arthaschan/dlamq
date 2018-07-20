package com.szatc.ibatis.service.impl;

import com.szatc.ibatis.entity.DlAirline;
import com.szatc.ibatis.mapper.DlAirlineMapper;
import com.szatc.ibatis.service.DlAirlineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


/**
 * @author liuweijian
 * @date 2018/1/4
 */
@Service
public class DlAirlineServiceImpl implements DlAirlineService {

    private static Logger logger = Logger.getLogger(DlAirlineServiceImpl.class);

    @Autowired
    private DlAirlineMapper dlAirlineMapper;

    /**
     * 获取T_CDM_DL_MSG表的数据
     * 只获取fstate为空的消息
     * @return
     */
    @Override
    public List<DlAirline> getList() {
        return dlAirlineMapper.getList();

    }



}
