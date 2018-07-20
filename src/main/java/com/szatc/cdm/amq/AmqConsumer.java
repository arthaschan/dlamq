package com.szatc.cdm.amq;

import com.szatc.cdm.common.constant.Global;
import com.szatc.cdm.common.util.DateUtil;
import com.szatc.ibatis.service.DlMsgService;
import org.apache.activemq.command.ActiveMQDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Kuhn Wei, email@kuhnwei.com
 * @version 2018/4/28 11:22
 **/
@Service
public class AmqConsumer implements  Serializable {

    private static final Logger logger = LoggerFactory.getLogger(AmqConsumer.class);
    
    @Autowired
    private DlMsgService dlMsgService;


    @JmsListener(destination = AmqConfig.AMQ_REV_QUEUE)
    public void onAmqRevQueue(Message message) throws Exception {

        try {
            ActiveMQDestination queue = (ActiveMQDestination) message.getJMSDestination();

            logger.info("listen queue");
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                try {
                    String result = tm.getText();
                    logger.info("receive the msg" + result);
                    Global.receiveTime=DateUtil.format(DateUtil.currentTime());
                    dlMsgService.initInsert(result);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    logger.error(ex.toString());
                }
            } else if (message instanceof ObjectMessage) {
                ObjectMessage om = (ObjectMessage) message;
                logger.info("get Object Message");

            } else if (message instanceof BytesMessage) {
                BytesMessage bm = (BytesMessage) message;

                logger.info("get BytesMessage ");
            } else if (message instanceof StreamMessage) {
                StreamMessage sm = (StreamMessage) message;

                logger.info("get StreamMessage ");
            } else {

                logger.info("get other class Message ");
            }

        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
}
