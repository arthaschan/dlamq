package com.szatc.ibatis.service;

import com.szatc.ibatis.entity.DepOrder;

import java.sql.Timestamp;

/**
 * ACDM报文数据访问对象
 *
 * @author liuweijian
 * @date 2018/1/4
 */
public interface DepOrderService    {
    /**
     * 获取创建之间之后的最新的一条排序信息
     * @param createTime
     * @return
     */
    DepOrder getDepOrder(Timestamp createTime) ;

}
