package com.szatc.cdm.amq;

import com.szatc.cdm.common.constant.Global;
import com.szatc.cdm.common.util.DateUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * @author Kuhn Wei, email@kuhnwei.com
 * @version 2018/4/28 11:23
 **/
@Service
public class AmqProducer {
    private static final Logger logger = LoggerFactory.getLogger(AmqProducer.class);


    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String destination, String message) {
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(destination), message);
        Timestamp ts= DateUtil.currentTime();
        Global.sendTime=DateUtil.format(ts);

        logger.info("produce：" );
    }
}
