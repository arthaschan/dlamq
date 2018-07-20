package com.szatc.cdm.resolver;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.szatc.cdm.common.pojo.dlcdm.Bizkey;
import com.szatc.cdm.common.pojo.dlcdm.DlHeader;
import com.szatc.cdm.common.pojo.dlcdm.DlXml;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.Add;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.CraftSeatL;
import com.szatc.cdm.common.pojo.dlcdm.dynFlight.Modify;
import com.szatc.cdm.common.pojo.dlcdm.gos.*;
import com.szatc.cdm.common.util.BizkeyUtil;
import com.szatc.cdm.common.util.DateUtil;
import com.szatc.cdm.common.util.XmlUtil;
import com.szatc.ibatis.entity.*;
import com.szatc.ibatis.service.*;
import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.*;

public class DlMsgResolver {


    private static Logger logger = Logger.getLogger(DlMsgResolver.class);

    private final SAXReader reader = new SAXReader();


    @Autowired
    private FlightInfoService flightInfoService;

    @Autowired
    private DlFlightInfoService dlFlightInfoService;

    @Autowired
    private DlMsgService dlMsgService;

    @Autowired
    private DlAirlineService dlAirlineService;

    private static List<DlAirline> dlAirlineList;


    public List<DlMsg> getDlmsgList() {
        return dlmsgList;
    }

    public void setDlmsgList(List<DlMsg> dlmsgList) {
        this.dlmsgList = dlmsgList;
    }

    private List<DlMsg> dlmsgList;

    public void Resolver(DlMsg dlMsg) {
        DlFlightInfo entity = null;
        FlightInfo flightinfo = null;
        DlXml xml = ResolveXML(dlMsg);
        if (xml == null||xml.getHeader()==null)
            return;

        if (dlAirlineList == null || dlAirlineList.size() <= 0) {
            dlAirlineList = dlAirlineService.getList();
        }
        String type = xml.getHeader().getType();
        String subType = xml.getHeader().getSubType();
        Object body = null;
        String flightId = "";
        Bizkey bizkey = new Bizkey();
        String seat = "";
        Calendar time = DateUtil.defaultDlCal();
        try {
            switch (type) {
                case "GOS":
                    switch (subType) {
                        case "BLOCKDOWNTIME":
                            body = (BlockDownTime) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((BlockDownTime) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((BlockDownTime) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("BlockDownTime "+bizkey.getFlightNumber());
                            break;
                        case "BLOCKUPTIME":
                            body = (BlockUpTime) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((BlockUpTime) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((BlockUpTime) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("BLOCKUPTIME "+bizkey.getFlightNumber());
                            break;
                        case "BOR":
                            body = (Bor) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((Bor) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((Bor) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("Bor "+bizkey.getFlightNumber());
                            break;
                        case "POK":
                            body = (Pok) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((Pok) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((Pok) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("Pok "+bizkey.getFlightNumber());
                            break;
                        default:
                            break;
                    }
                    break;
                case "DYNFLIGHT":
                    switch(subType){
                        case "CRAFTSEAT":
                            body = (CraftSeatL) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((CraftSeatL) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((CraftSeatL) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("CraftSeat"+bizkey.getFlightNumber());
                            break;
                        case "ADD":
                            body = (Add) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((Add) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((Add) body, bizkey);
                            // Add 消息会有重发的情况。
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("Add:"+bizkey.getFlightNumber());
                            break;
                        case "MODIFY":
                            body = (Modify) (xml.getBody());
                            bizkey = BizkeyUtil.buildEntity(dlAirlineList, ((Modify) body).getBizkey());
                            bizkey.setUuid(GetUuid(bizkey.getFlightNumber(), bizkey.getInOut(), bizkey.getFlightDate()));
                            entity = new DlFlightInfo((Modify) body, bizkey);
                            dlFlightInfoService.update(entity);
                            flightInfoService.update(entity);
                            logger.info("Modify:"+bizkey.getFlightNumber());
                            break;
                    }
                    break;
                case "BASE":
                    break;
                case "REQUEST":
                    break;
                case "IMSG":
                    break;
                default:
                    break;

            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }


    }

    /**
     * 获取航班在T_CDM_FLIGHTINFO的主键值。
     *
     * @param flightNumber 3字码格式的航班号
     * @param inOut        in/out
     * @param flightDate   yyyy-MM-dd HH24:mi:ss 格式
     * @return 如果查询不到，返回“”；
     */
    public String GetUuid(String flightNumber, String inOut, Date flightDate) {
        Timestamp ts = DateUtil.parseDateToTimestamp(flightDate);
        String uuid = "";
        try {
            uuid = flightInfoService.searchUuid(flightNumber, inOut, ts);
            return uuid;
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return "";
    }


    /**
     * 解析消息头
     *
     * @param dlMsg
     */
    private DlHeader ResolveHead(DlMsg dlMsg)   {
        DlXml entity = new DlXml();
        Object obj=null;
        try{
          obj=XmlUtil.parseXml2Obj(dlMsg.getXmlContent(), DlXml.class);
        if(obj==null)
            return null;
        }
        catch (Exception ex){
            logger.error(ex.toString());
            return null;
        }
        entity = (DlXml)obj;
        DlHeader header = entity.getHeader();
        dlMsg.setType(header.getType());
        dlMsg.setSubType(header.getSubType());
        dlMsg.setSndr(header.getSndr());
        dlMsg.setRcvr(header.getRcvr());
        dlMsg.setSeqn(header.getSeqn());
        dlMsg.setState("1");
        dlMsg.setSendTime(new Timestamp(header.getSendTime().getTimeInMillis()));
        return header;

    }


    /**
     * 解析消息体
     * <p>
     * 解析失败，则保存到消息表，记录失败原因。
     * 解析成功，则更新航班信息表。
     *
     * @param dlMsg
     */
    private Object ResolveBody(DlMsg dlMsg) {
        Object bodys = new Object();
        String type = dlMsg.getType();
        String subType = dlMsg.getSubType();
        Object entity = new Object();
        String xml = dlMsg.getXmlContent();

        switch (type) {
            case "GOS":
                //JAXB 解析XML，此处删除DFLI标签。
                xml = XmlUtil.deleteNode(xml, "DFLT");
                switch (subType) {
                    case "BLOCKDOWNTIME":
                        bodys = XmlUtil.parseXml2Obj(xml, BlockDownTime.class);
                        entity = (BlockDownTime) bodys;
                        break;
                    case "BLOCKUPTIME":
                        bodys = XmlUtil.parseXml2Obj(xml, BlockUpTime.class);
                        entity = (BlockUpTime) bodys;
                        break;
                    case "BOR":
                        bodys = XmlUtil.parseXml2Obj(xml, Bor.class);
                        entity = (Bor) bodys;
                        break;
                    case "POK":
                        bodys = XmlUtil.parseXml2Obj(xml, Pok.class);
                        entity = (Pok) bodys;
                        break;
                    default:
                        entity=null;
                        break;
                }
                break;
            case "DYNFLIGHT":
                switch (subType) {
                    case "CRAFTSEAT":
                        bodys = XmlUtil.parseXml2Obj(xml, CraftSeatL.class);
                        entity = (CraftSeatL) bodys;
                        break;
                    case "ADD":
                        xml = XmlUtil.deleteNode(xml, "DFLT");
                        bodys = XmlUtil.parseXml2Obj(xml, Add.class);
                        entity=(Add)bodys;
                        break;
                    case "MODIFY":
                        xml = XmlUtil.deleteNode(xml, "DFLT");
                        bodys = XmlUtil.parseXml2Obj(xml, Modify.class);
                        entity=(Modify)bodys;
                        break;

                    default:
                        entity=null;
                        break;
                }
                break;
            case "BASE":
                entity=null;
                break;
            case "REQUEST":
                break;
            case "IMSG":
                entity=null;
                break;
            default:
                entity=null;
                break;
        }
        return entity;
    }


    /**
     * 解析收到的DL的xml消息
     *
     * @param dlMsg
     * @return
     */
    public DlXml ResolveXML(DlMsg dlMsg) {
        DlXml dlXml = new DlXml();
        DlHeader header = new DlHeader();
        Object body = null;
        Element root = null;
        try {
            root = XmlUtil.getRoot(dlMsg.getXmlContent());
            if (root == null || root.getName() == "KEEPALIVE") {
                dlMsgService.updateMsgXmlError(dlMsg.getId(), "root 为空或者为KEEPALIVE！");
                return null;
            }

        } catch (Exception ex) {
            dlMsgService.updateMsgXmlError(dlMsg.getId(), "读取xml失败！");
            logger.error(ex.toString());
            return null;
        }
        try {
            header = ResolveHead(dlMsg);
            if(header==null){
                dlMsgService.updateMsgXmlError(dlMsg.getId(), "读取消息头失败");
                logger.error(dlMsg.getId()+"读取消息头失败");
                return null;
            }

        } catch (Exception ex) {
            dlMsgService.updateMsgXmlError(dlMsg.getId(), "读取消息头失败");
            logger.error(ex.toString());
            return null;
        }
        try {
            body = ResolveBody(dlMsg);
        } catch (Exception ex) {
            dlMsgService.updateMsgXmlError(dlMsg.getId(), "读取消息体失败");
            logger.error(ex.toString());
            return null;
        }
        dlMsgService.updateTodoMsg(dlMsg);

        dlXml.setHeader(header);
        dlXml.setBody(body);
        return dlXml;
    }

}
