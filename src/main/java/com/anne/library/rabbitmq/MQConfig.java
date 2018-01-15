package com.anne.library.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

//@Configuration
public class MQConfig {

public static final String BORROW_QUEUE = "borrow.queue";


//    @Bean
//    public Queue queue(){
//        return  new Queue(BORROW_QUEUE, true);
//    }
}
