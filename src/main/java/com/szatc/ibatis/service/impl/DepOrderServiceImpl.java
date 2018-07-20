package com.szatc.ibatis.service.impl;

import com.szatc.ibatis.entity.DepOrder;
import com.szatc.ibatis.mapper.DepOrderMapper;
import com.szatc.ibatis.service.DepOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @author liuweijian
 * @date 2018/1/4
 */
@Service
public class DepOrderServiceImpl   implements DepOrderService {

    private static Logger logger = Logger.getLogger(DepOrderServiceImpl.class);

    @Autowired
    private DepOrderMapper  depOrderMapper;

    @Override
    /**
     * 获取创建之间之后的最新的一条排序信息
     * @param createTime
     * @return
     */
    public  DepOrder getDepOrder(Timestamp createTime)  {
        DepOrder entity=new DepOrder();
        try {
            entity = this.depOrderMapper.getDepOrder(createTime);

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return entity;
    }





}
