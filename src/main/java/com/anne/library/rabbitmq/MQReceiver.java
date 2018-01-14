package com.anne.library.rabbitmq;

import com.anne.library.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQConfig.class);

    @RabbitListener(queues = MQConfig.BORROW_QUEUE)
    public void receive(String message){
        log.info("receive borrow message: " + message);
        BorrowMessage borrowMessage = CommonUtil.stringToObj(message, BorrowMessage.class);
        Long userId = borrowMessage.getUserId();
        Long bookId = borrowMessage.getBookId();



    }
}
