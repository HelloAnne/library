package com.anne.library.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Author: Anne Zhang
 * Date: 2018/1/15 0015
 * Description:
 */

@Configuration
@ImportResource(locations = {"classpath:spring/*.xml"})
public class MybatisConfig {

}
