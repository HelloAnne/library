package com.anne.library.configuration;

import com.anne.library.listener.ConfigListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
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
    @Bean
    public ServletListenerRegistrationBean<ConfigListener> configListenerRegistration() {
        return new ServletListenerRegistrationBean<>(new ConfigListener());
    }
}

