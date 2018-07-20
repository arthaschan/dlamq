package com.szatc.ibatis.service;

import com.szatc.ibatis.entity.DlAirline;

import java.util.List;

/**
 *
 * @author liuweijian
 * @date 2018/1/4
 */
public interface DlAirlineService {

    /**
     * 获取T_CDM_DL_AIRLINE表的数据
     * @return
     */
    List<DlAirline> getList();



}
