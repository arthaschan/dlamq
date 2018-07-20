package com.szatc.ibatis.mapper;

import com.szatc.ibatis.entity.DlMsg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CDM 航班数据
 *
 * @author liuweijian
 * @date 2018/1/2
 */
//public  interface  DlMsgDao{
@Mapper
public interface DlMsgMapper {

//    /**
//     * 插入从大连获取到的消息数据到T_CDM_DL_MSG 表
//     * @param sql
//     * @param params
//     * @return
//     */
  //  @InsertProvider(type= DlMsgDaoImpl.class,method = "insert")
   // int  insert(String sql, Object[] params) ;


    int insert(DlMsg dlmsg);

    /**
     * 获取T_CDM_DL_MSG表的数据
     * @return
     */
    List<DlMsg> getList();

    /**
     * 获取T_CDM_DL_MSG表中待处理的停机位的数据
     * @return
     */
    List<DlMsg>  getSeatTodo();
    /**
     * 更新T_CDM_DL_MSG表的数据，只处理：ftype,fsubtype,fstate,fexception 字段
     * @param dlmsg
     * @return
     */
   // @UpdateProvider(type = DlMsgDaoImpl.class,method = "update")
    int update(DlMsg dlmsg) ;

}
