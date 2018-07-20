package com.szatc.ibatis.service;

import com.szatc.ibatis.entity.DlMsg;

import java.io.Serializable;
import java.util.List;

/**
 * ACDM报文数据访问对象
 *
 * @author liuweijian
 * @date 2018/1/4
 */
public interface DlMsgService   {



    int insert(DlMsg entity);
    /**
     * 初始化插入数据，提供xmlContent,其余的系统自己补全
     * @param xmlContent
     * @return
     */
    int initInsert(String xmlContent);

    /**
     * 获取T_CDM_DL_MSG表的数据
     * @param sql
     * @return
     */
    List<DlMsg> getList(String sql);

    /**
     * 更新T_CDM_DL_MSG表的数据，只处理：ftype,fsubtype,fstate,fexception 字段
     * @param entity
     * @return
     */
    int   updateTodoMsg(DlMsg entity) ;


    /**
     * 获取T_CDM_DL_MSG表中待处理的停机位的数据
     * @return
     */
    List<DlMsg>  getSeatTodo();

    /**
     * xmlContent 解析时候，发现错误，异常到数据库,更新状态为1，更新exception 列数据
     * @param id
     * @param erroContent
     * @return
     */
    int updateMsgXmlError(String id, String erroContent);


    /**
     * 获取T_CDM_DL_MSG表的数据
     * 只获取fstate为空的消息
     * @return
     */
    List<DlMsg> getTodoList();

}
