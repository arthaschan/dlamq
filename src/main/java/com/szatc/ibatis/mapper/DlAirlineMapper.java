package com.szatc.ibatis.mapper;

import com.szatc.ibatis.entity.DlAirline;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CDM 航班数据
 *
 * @author liuweijian
 * @date 2018/1/2
 */
@Mapper
public interface DlAirlineMapper {



    /**
     * 获取T_CDM_DL_AIRLINE表的数据
     * @return
     */
    List<DlAirline> getList();


}
