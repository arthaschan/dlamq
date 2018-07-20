package com.szatc.cdm.resolver;

import com.szatc.cdm.common.pojo.acdm.AcdmMessage;
import com.szatc.cdm.common.pojo.cdm.Cdm008;
import com.szatc.cdm.common.pojo.cdm.Cdm039;
import com.szatc.cdm.common.pojo.cdm.CdmHeader;
import com.szatc.cdm.common.pojo.cdm.CdmXml;
import com.szatc.cdm.common.util.DateUtil;
import com.szatc.cdm.common.util.FileUtil;
import com.szatc.cdm.common.util.XmlUtil;
import com.szatc.cdm.convert.Cdm2AcdmConvertor;
import com.szatc.ibatis.entity.*;
import com.szatc.ibatis.service.FlightInfoService;
import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepOrderResolver {

    private static Logger logger = Logger.getLogger(DepOrderResolver.class);

    @Autowired
    private FlightInfoService flightInfoService;

    private List<FlightInfo> flightInfoList;


    /**
     * 解析消息头
     *
     * @param depOrder
     */
    private CdmHeader ResolveHead(DepOrder depOrder) {
        CdmXml entity = new CdmXml();
        entity = (CdmXml) XmlUtil.parseXml2Obj(depOrder.getFxmlContent(), CdmXml.class);
        CdmHeader header = entity.getHeader();

        return header;

    }



    public AcdmMessage transferCdmToAcdm(DepOrder depOrder) {

        AcdmMessage acdmMessage=new AcdmMessage();
        try {
            CdmXml cdmXml = ResolveXML(depOrder);
            if (cdmXml == null)
                return null;
            if(flightInfoList==null ||flightInfoList.size()<=0)
                flightInfoList=flightInfoService.getList(DateUtil.currentTime());
            acdmMessage=Cdm2AcdmConvertor.buildAcdmMsg(cdmXml,  flightInfoList);

        } catch (Exception ex) {
            logger.error(ex.toString());
        }

        return acdmMessage;
    }


    /**
     * 解析消息体
     * <p>
     * 解析失败，则保存到消息表，记录失败原因。
     * 解析成功，则更新航班信息表。
     *
     * @param depOrder
     */
    private Object ResolveBody(DepOrder depOrder) {
        Object bodys = new Object();
        String type = depOrder.getFcdmType();
        String xml = depOrder.getFxmlContent();
        switch (type) {
            case "CDM008":
                //JAXB 解析XML，此处删除DFLI标签。
                xml = XmlUtil.deleteNode(xml, "flights");
                bodys = XmlUtil.parseXml2Obj(xml, Cdm008.class);
                break;
            case "FlowControl":
                xml = XmlUtil.deleteNode(xml, "flowControls");
                bodys = XmlUtil.parseXml2Obj(xml, Cdm039.class);
                break;
            case "REQUEST":
                break;
            case "IMSG":
                break;
            default:
                break;
        }
        return bodys;
    }

    public static void main(String[] args) {
        try{
            DepOrderResolver resolver = new DepOrderResolver();
            String file = "G:\\cdm008.xml";
            String xml = FileUtil.readToString(file);
         //   xml=resolver.deleteNode(xml,"flights");
            Object bodys = XmlUtil.parseXml2Obj(xml, Cdm008.class);
            System.out.println(bodys);
        }catch (Exception ex){

        }
    }

    /**
     * 解析收到的DL的xml消息
     *
     * @param depOrder
     * @return
     */
    public  CdmXml ResolveXML(DepOrder depOrder) {
        CdmXml cdmXml=new CdmXml();
        CdmHeader header=new CdmHeader();
        Object body=null;
        Element root = null;
        try {
            root = XmlUtil.getRoot(depOrder.getFxmlContent());
        } catch (Exception ex) {
            logger.error(ex.toString());
            return null;
        }
        try {
            header= ResolveHead(depOrder);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return null;
        }
        try{
            body=ResolveBody(depOrder);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return null;
        }
        cdmXml.setHeader(header);
        cdmXml.setBody(body);
        return  cdmXml;
    }

}
