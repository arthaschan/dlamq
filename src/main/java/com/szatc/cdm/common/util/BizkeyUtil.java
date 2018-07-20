package com.szatc.cdm.common.util;

import com.szatc.cdm.common.pojo.dlcdm.Bizkey;
import com.szatc.ibatis.entity.DlAirline;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供bizkey的转换，将航班号里的2字码转成3字码
 * I/O 转换成in/out
 */
public class BizkeyUtil {

    private static Logger logger = Logger.getLogger(BizkeyUtil.class);

    public  static String transferIO(String io){
        return io.equals("I")?"in":"out";
    }

    /**
     * 转换2字码的航班号为3字码的
     * @param flightNumber
     * @return
     */
    public static String transferFlightNumber(List<DlAirline> dlAirlineList, String flightNumber){

        String iata=flightNumber.substring(0,2);
        if (iata.equals("ZZ")){
            return flightNumber.replace(iata, "");
        }
        String icao=get3CodeBy2(dlAirlineList,iata);
        if (!icao.equals("")) {
            flightNumber=flightNumber.replace(iata,icao);
        }
        return flightNumber;
    }



    public  static  String get3CodeBy2(List<DlAirline> list, String iata){

        String icao="";
        if(list==null||list.size()<=0)
            return icao;

        for(DlAirline entity :list){
            if(entity.getIata().equals(iata))
                return entity.getIcao();
        }
        return icao;
    }

    /**
     * 根据消息里的bizkey 字符串转换成bizkey 对象。
     * @param biz  20150116-ZH9694-0-W/Z-201501162005
     * @return
     */
    public static Bizkey buildEntity(List<DlAirline> airlineList, String biz){
        Bizkey bizkey=new Bizkey();
        bizkey.setNode(biz);
        if(biz==null||biz.isEmpty())
            return bizkey;

        //获取航班日期
        String date=biz.substring(0,"20150116".length());
        try {
            bizkey.setFlightDate(DateUtil.parseShortDate(date));
        }catch (Exception ex){
            bizkey.setFlightDate(DateUtil.defaultDate() );
        }
        List<String> list=getContent(biz,"-");
        if(list==null||list.size()<=1)
            return bizkey;
        String flightNumber=list.get(0);
        String io=list.get(1);

        io= transferIO(io);
        flightNumber= transferFlightNumber(airlineList,flightNumber);
        bizkey.setFlightNumber(flightNumber);
        bizkey.setInOut(io);

        return bizkey;

    }



    public static void main(String[] args){
        String abc= "20150116-ZH9694-0-W/Z-201501162005";//"123-234-5-8-9-6";
        String ch="-";
        List<String > list=getContent(abc,ch);

    }


    /**
     * 识别出 2个ch 字符之间的字符串
     * @param str
     * @param ch
     * @return
     */
    private static List<String> getContent(String str, String ch){

        List<String> list=new ArrayList<String>();
        List<Integer> index=new ArrayList<Integer>();
        int lastIndex=str.lastIndexOf(ch);
        try {
            for (int i = -1; i <=lastIndex ; i++) {
                i = str.indexOf(ch,i);
                index.add(i);
            }
            for (int j = 0; j < index.size() - 1; j++) {
                list.add(str.substring(index.get(j) + 1, index.get(j + 1)));
            }
        }catch(Exception ex){
            logger.error(ex.toString());
        }
        return list;
    }
}
