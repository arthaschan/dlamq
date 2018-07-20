package com.szatc.ibatis.service.impl;

import com.szatc.cdm.common.util.DateUtil;
import com.szatc.ibatis.entity.DlMsg;
import com.szatc.ibatis.mapper.DlMsgMapper;
import com.szatc.ibatis.service.DlMsgService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


/**
 * @author liuweijian
 * @date 2018/1/4
 */
@Service
public class DlMsgServiceImpl  implements DlMsgService {

    private static Logger logger = Logger.getLogger(DlMsgServiceImpl.class);

    @Autowired
    private DlMsgMapper  dlMsgMapper;

    @Override
    public int insert(DlMsg entity) {
        try{
            return dlMsgMapper.insert(entity);

        }
        catch (Exception ex){
            logger.error(ex.toString());
        }
        return 0;
    }


    /**
     * 初始化插入数据，提供xmlContent,其余的系统自己补全
     * 用于系统第一次收到消息，还没有解析消息。
     * @param xmlContent
     * @return
     */
    @Override
    public int initInsert(String xmlContent) {
        Object[] params=new Object[12];
        String id= UUID.randomUUID().toString();
        Integer version=1;
        String sender="";
        String receiver="";
        String seqn="0";
        String sendTime= DateUtil.format(Calendar.getInstance().getTime());
        String type="";
        String subType="";
        String fstate="";
        String exception="";
        String createTime="";
        createTime=DateUtil.format(Calendar.getInstance().getTime());

        DlMsg dlMsg=new DlMsg();
        dlMsg.setId(id);
        dlMsg.setVersion(version);

        dlMsg.setSndr(sender);
        dlMsg.setRcvr(receiver);
        dlMsg.setSeqn(seqn);
        dlMsg.setSendTime(Timestamp.valueOf(sendTime));
        dlMsg.setType(type);
        dlMsg.setSubType(subType);
        dlMsg.setXmlContent(xmlContent);
        dlMsg.setState(fstate);
        dlMsg.setException(exception);
        dlMsg.setCreateTime(Timestamp.valueOf(createTime));
        return  dlMsgMapper.insert(dlMsg);
    }

    /**
     *   xmlContent 解析时候，发现错误，异常到数据库,更新状态为1，更新exception 列数据
     * @param id
     * @param erroContent
     * @return
     */
    public int updateMsgXmlError(String id,String erroContent){

        DlMsg dlMsg=new DlMsg();
        dlMsg.setId(id);
        dlMsg.setException(erroContent);
        dlMsg.setState("1");

        try{
            return dlMsgMapper.update(dlMsg);

        }
        catch (Exception ex){
            logger.error(ex.toString());
        }
        return 0;
    }



    /**
     * 获取T_CDM_DL_MSG表的数据
     * 只获取fstate为空的消息
     * @param sql
     * @return
     */
    @Override
    public List<DlMsg> getList(String sql) {
        try{
            return dlMsgMapper.getList();
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }

        return new ArrayList<DlMsg>();
    }

    /**
     * 获取T_CDM_DL_MSG表的数据
     * 只获取fstate为空的消息
     * @return
     */
    @Override
    public List<DlMsg> getTodoList() {
        try{
            return dlMsgMapper.getList();
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }

        return new ArrayList<DlMsg>();
    }

    /**
     * 更新T_CDM_DL_MSG表的数据，只处理：sndr,rcvr,seqn,sendtime,type,subtype,state,exception 字段
     * 查询条件为：fid
     * @param entity
     * @return
     */
    @Override
    public int updateTodoMsg(DlMsg entity) {

        try{
            return dlMsgMapper.update(entity);
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }
        return 0;
    }

    @Override
    public List<DlMsg> getSeatTodo() {
        try{
            return dlMsgMapper.getSeatTodo();
        }
        catch (Exception ex){
            logger.error(ex.toString());
        }

        return new ArrayList<DlMsg>();
    }
}
