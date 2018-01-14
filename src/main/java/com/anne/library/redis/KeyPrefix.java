package com.anne.library.redis;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public interface KeyPrefix {
    int getExpiredSeconds();
    String getPrefix();
}
