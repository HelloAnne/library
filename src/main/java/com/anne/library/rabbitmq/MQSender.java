package com.anne.library.rabbitmq;

import com.anne.library.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

@Service
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    private static Logger log = LoggerFactory.getLogger(MQConfig.class);


    public void sendBorrowMessage(Object message){

        log.info("send borrow message: " + message);

        String messageStr = CommonUtil.objToString(message);
        amqpTemplate.convertAndSend(MQConfig.BORROW_QUEUE, messageStr);
    }
}
