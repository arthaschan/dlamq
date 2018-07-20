package com.szatc.cdm.convert;

import com.szatc.cdm.common.pojo.acdm.AcdmMessage;
import com.szatc.cdm.common.pojo.acdm.flyque.Flydepque;
import com.szatc.cdm.common.pojo.acdm.otherdata.Flowcontr;
import com.szatc.cdm.common.pojo.acdm.selfdefine.FlightKeyType;
import com.szatc.cdm.common.pojo.cdm.Cdm008;
import com.szatc.cdm.common.pojo.cdm.Cdm039;
import com.szatc.cdm.common.pojo.cdm.CdmXml;
import com.szatc.cdm.common.util.DateUtil;
import com.szatc.ibatis.entity.FlightInfo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * CDM报文转换器：向ACDM报文转换
 *
 * @author liuweijian
 * @date 2018/1/5
 */
public class Cdm2AcdmConvertor {
    private Logger logger = Logger.getLogger(Cdm2AcdmConvertor.class);

    public static   AcdmMessage buildAcdmMsg(CdmXml xml, List<FlightInfo> flightInfoList){

        AcdmMessage acdmMessage = null;
        if(xml==null)
            return acdmMessage;
        Object body = null;
        AcdmMessage.Header header = new AcdmMessage.Header();
        switch (xml.getHeader().getMsgName()) {
            case "CDM001":
                break;
            case "CDM002":
                break;
            case "CDM003":
                break;
            case "CDM004":
                break;
            case "CDM005":
                break;
            case "CDM006":
                break;
            case "CDM007":

                break;
            case "CDM008":
                header.setSndr("ZYTL_ATC");
                header.setType("flyque");
                header.setStype("flydepque");
                header.setDdtm(xml.getHeader().getTimestamp());
                body = (Cdm008) (xml.getBody());
                acdmMessage = new AcdmMessage(header, body);
                List<Flydepque> flydepques=buildAcdmBodys(((Cdm008)body).getMessage(),flightInfoList);
                acdmMessage.setBodys(flydepques);
                break;
            case "CDM009":
                break;
            case "CDM010":
                break;
            case "CDM011":
                break;
            case "CDM012":
                break;
            case "CDM013":
                break;
            case "CDM014":
                break;
            case "CDM015":
                break;
            case "CDM016":
                break;
            case "CDM017":
                break;
            case "CDM018":
                break;
            case "CDM019":
                break;
            case "CDM020":
                break;
            case "CDM021":
                break;
            case "CDM022":
                break;
            case "CDM023":
                break;
            case "CDM024":
                break;
            case "CDM025":
                break;
            case "CDM026":
                break;
            case "CDM027":
                break;
            case "CDM028":
                break;
            case "CDM029":
                break;
            case "CDM030":
                break;
            case "CDM031":
                break;
            case "CDM032":
                break;
            case "CDM033":
                break;
            case "CDM034":
                break;
            case "CDM035":
                break;
            case "CDM036":
                break;
            case "CDM037":
                //ACDM缺少航班排队交换顺序信息（预留）
                break;
            case "CDM038":
                break;
            case "CDM039":
                break;
            case "CDM040":
                break;
            case "FlowControl":

                header.setSndr("ZYTL_ATC");
                header.setType("otherdata");
                header.setStype("flowcontr");
                header.setDdtm(xml.getHeader().getTimestamp());
                body = (Cdm039) (xml.getBody());
                acdmMessage = new AcdmMessage(header, body);
                List<Flowcontr> list=buildAcdmBodys(((Cdm039)body).getMessage());
                acdmMessage.setBodys(list);
                break;
            case "RunwayChange":
                //跑道容量不规范的报文解析
                break;
            default:
                break;

        }
        return acdmMessage;
    }

    public static Flydepque build(FlightInfo flightInfo, Cdm008.Cdm008Flight f){

        if(f==null)
            return null;
        Flydepque entity=new Flydepque();
        entity.setCobt(  f.getIntendCloseTime());
        entity.setCtot(f.getPdcflying());

//        entity.setCodt(f.getCodt());
//        entity.setControlPoint(f.getControlPoint());
//        entity.setLeaveNo(f.getLeaveNumber());
//        entity.setLimitPoint(f.getLimitPoints());
//        entity.setSortStatus(f.getFlightSortState());
        FlightKeyType flightkey=buildFlightKey(flightInfo);
        entity.setFlightKey(flightkey);
        return entity;
    }

    public  static FlightKeyType buildFlightKey(FlightInfo flightInfo){
        FlightKeyType flightkey=new FlightKeyType();
        if(flightInfo==null)
            return null;
        flightkey.setAdep(flightInfo.getAdep());
        flightkey.setAdes(flightInfo.getAdes());
        flightkey.setFlightNo(flightInfo.getFlightNo());
        flightkey.setSobt(DateUtil.parseTimestampToCalendar(flightInfo.getSobt()));
        flightkey.setFuid(flightInfo.getFuid());//传给大连的FUID 是本场航班的主键ID。
        return flightkey;
    }
    /**
     * 把CDM008等的对象补充 SOBT ADEP ADES的信息
     */
    public static List<Flydepque> buildAcdmBodys( List<Cdm008.Cdm008Flight> cdm008Flights,List<FlightInfo> flightInfoList){

        List<Flydepque> list=new ArrayList<Flydepque>();

        if(cdm008Flights==null)
            return list;
     //   List<Cdm008.Cdm008Flight> cdm008FlightList=((Cdm008)body).getMessage();
        for (Cdm008.Cdm008Flight flight : cdm008Flights){
            //CDM008 里的flightId 对应CDM里的 FLIGHT_ID，而不是对应的主键ID。
            //CDM008 里的flightId 是ATRS 的主键ID
            FlightInfo flightInfo=searchFlight(flight.getFlightID(),flightInfoList);
            if(flightInfo==null)
                continue;
            Flydepque dep= build(flightInfo,flight);
            list.add(dep);
        }
        return  list;
    }

   public static List<Flowcontr> buildAcdmBodys(List<Cdm039.FlowControl> flowControls){
       List<Flowcontr> list=new ArrayList<Flowcontr>();

       if(flowControls==null)
           return list;
       //   List<Cdm008.Cdm008Flight> cdm008FlightList=((Cdm008)body).getMessage();
       for (Cdm039.FlowControl control : flowControls){
           //
           Flowcontr flowcontr= new Flowcontr();
           flowcontr.setControlPoint(control.getControlPoint());
           flowcontr.setEnabledFlag(control.getEnabledFlag());
           flowcontr.setEndTime(control.getEndTime());
           flowcontr.setFlightKeyList(null);
           flowcontr.setFlowId(control.getFlowId());
           flowcontr.setInterval(control.getInterval());
           flowcontr.setStartTime(control.getStartTime());

           list.add(flowcontr);
       }
       return  list;
   }

    public static FlightInfo searchFlight(String flightId,List<FlightInfo> list){
        if(flightId==null||flightId.isEmpty()||list==null|| list.size()<=0)
            return null;
        for(FlightInfo f :list){
            if(flightId.equals(f.getFlightId()))
                return f;
        }
        return null;
    }

}