package com.szatc.ibatis.mapper;

import com.szatc.ibatis.entity.DepOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * CDM 航班数据
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@Mapper
public interface DepOrderMapper   {

    /**
     * 获取创建之间之后的最新的一条排序信息
     * @param createTime
     * @return
     */
   DepOrder getDepOrder(Timestamp createTime) ;


}
