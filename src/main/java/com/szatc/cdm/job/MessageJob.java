package com.szatc.cdm.job;

import com.google.gson.Gson;
import com.szatc.cdm.amq.AmqProducer;
import com.szatc.cdm.amq.AmqConfig;
import com.szatc.cdm.common.constant.Global;
import com.szatc.cdm.common.pojo.acdm.AcdmMessage;
import com.szatc.cdm.common.util.DateUtil;
import com.szatc.ibatis.entity.DepOrder;
import com.szatc.ibatis.entity.DlMsg;
import com.szatc.cdm.resolver.DepOrderResolver;
import com.szatc.cdm.resolver.DlMsgResolver;
import com.szatc.ibatis.service.DepOrderService;
import com.szatc.ibatis.service.DlMsgService;
import com.szatc.ibatis.service.FlightInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tempuri.IParkingBayService;
import org.tempuri.ParkingBayService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/***
 * 
 * Quartz设置项目全局的定时任务  一定要启动定时器(@EnableScheduling)
 * @Component注解的意义        泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。一般公共的方法我会用上这个注解
 * @author WQ
 */
@Component
public class MessageJob {

    protected static final Logger logger = LoggerFactory.getLogger(MessageJob.class);

    private static String lastUuid = "";



    @Autowired
    private Gson gson2;

    @Autowired
    private FlightInfoService flightInfoService;

    @Autowired
    private DlMsgService dlMsgService;

    @Autowired
    private DlMsgResolver dlMsgResolver;

    @Autowired
    private DepOrderService depOrderService;

    @Resource(name = "depOrderResolver")
    private DepOrderResolver depOrderResolver;


    @Resource
    private AmqProducer amqProducer;

    private IParkingBayService parkingBayService;
    private ParkingBayService facoty;

    public void buildAtrs() {
        if (facoty == null) {
            facoty = new ParkingBayService();
        }
        if (parkingBayService == null) {
            parkingBayService = facoty.getBasicHttpBindingIParkingBayService();
        }

    }


    /**
     * 解析t_cdm_dl_msg 表的数据，识别出 消息类型。停机位消息的JOB 依赖此JOB。
     * 并且识别出异常的XML。
     * @throws Exception
     */
    @Scheduled(fixedRate = 5000)//每20秒执行一次
    public void play() throws Exception {
        logger.info("play Quartz task:" + new Date());

        try {
            List<DlMsg> list = dlMsgService.getTodoList();
            for (DlMsg msg : list) {
                dlMsgResolver.Resolver(msg);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }




    /**
     * 从T_CDM_DL_MSG 里取 ADD  MODIFY CRRAFTSEAT 类型的消息，往ATRS转发送数据
     */
//    @Scheduled(cron = "0/10 0 * * * ?") // 每分钟执行一次
    @Scheduled(fixedRate = 5000)
    public void execute() {
        logger.info("send data to atrs: job.MessageJob.execute");
        List<DlMsg> msgs = dlMsgService.getSeatTodo();
        if (msgs == null || msgs.size() <= 0)
            logger.info("no data");


        for (DlMsg dlMsg : msgs) {
            // 发送到ATRS
            String returnValue = "0";
            if (dlMsg.getXmlContent() == null || dlMsg.getXmlContent().isEmpty())
                continue;

            try {
                logger.info("send parkingbay data,id=" + dlMsg.getId());
                Timestamp ts= DateUtil.currentTime();
                Global.sendAtrs=DateUtil.format(ts);
                buildAtrs();
                returnValue = parkingBayService.receiveParkingBayFromCdm(dlMsg.getXmlContent());

            } catch (Exception ex) {
                logger.error(ex.getMessage());
                logger.error("send to atrs failure");
                return;
            }

            // 修改数据中状态
            if ("1".equals(returnValue)) {
                logger.info("send to atrs successfully,result is : " + returnValue);
                //T_CDM_DL_MSG 的列 SEATSTATE 只对停机位有效。
                dlMsg.setSeatState("1");
                dlMsgService.updateTodoMsg(dlMsg);
            }
        }
    }




    //    @Scheduled(cron = "0/10 0 * * * ?") // 每分钟执行一次
    @Scheduled(fixedRate = 5000)
    public void executeSendMsg() {
        logger.info("executeSendMsg:begin~");
        try {
            List<AcdmMessage> list = getDepOrderAcdmMessageList();

            if (list == null || list.size() <= 0)
                return;
            for (AcdmMessage m : list) {
                String result = gson2.toJson(m);
                amqProducer.send(AmqConfig.AMQ_SND_QUEUE, result);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }


    public List<AcdmMessage> getDepOrderAcdmMessageList() {
        ArrayList<AcdmMessage> acdmMessageList = new ArrayList<AcdmMessage>();
        Timestamp ts = null;
        try {
            DepOrder order = this.depOrderService.getDepOrder(ts);
            if (order == null)
                return acdmMessageList;
            String id = order.getFid();
            if (id == null || id.isEmpty())
                return acdmMessageList;
            //每分钟从数据库查询一次，如果当前查询到的最新的消息和上次一样，就不需要重新发送了。

            if (id.equals(lastUuid))
                return acdmMessageList;
            AcdmMessage msg = depOrderResolver.transferCdmToAcdm(order);
            acdmMessageList.add(msg);
            lastUuid = id;
            logger.info("dep order:id="+id);

        } catch (Exception e) {
            // throw new ProcessSqlParamException("处理航班排序信息时出现异常");
            logger.error(e.toString());
        }
        return acdmMessageList;
    }
}

