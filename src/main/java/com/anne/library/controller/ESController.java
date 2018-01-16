package com.anne.library.controller;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Anne Zhang
 * Date: 2018/1/15
 * Description:
 */
@RestController
public class ESController {

    @Autowired
    private TransportClient transportClient;
}
