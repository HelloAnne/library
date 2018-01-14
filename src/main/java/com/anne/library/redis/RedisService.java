package com.anne.library.redis;

import com.alibaba.fastjson.JSON;
import com.anne.library.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 放入对象
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String valueStr = CommonUtil.objToString(value);
            if (valueStr == null || valueStr.length()<=0){
                return false;
            }
            String realKey = prefix.getPrefix() + key;
            int expiredSeconds = prefix.getExpiredSeconds();
            if (expiredSeconds<=0){
                jedis.set(realKey, valueStr);
            } else {
                jedis.setex(realKey, expiredSeconds, valueStr);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 获取对象
     */
    public <T> T get(KeyPrefix prefix,String key, Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String valueStr = jedis.get(realKey);
            T t = CommonUtil.stringToObj(valueStr, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 检查是否存在
     */
    public boolean exists(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 增加值
     */
    public <T> long incr(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realkey = prefix.getPrefix() + key;
            return jedis.incr(realkey);
        } finally {
            returnToPool(jedis);
        }

    }

    /**
     * 减少值
     */
    public <T> long decr(KeyPrefix prefix, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realkey = prefix.getPrefix() + key;
            return jedis.decr(realkey);
        } finally {
            returnToPool(jedis);
        }

    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}

