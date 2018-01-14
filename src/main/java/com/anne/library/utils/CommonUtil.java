package com.anne.library.utils;

import com.alibaba.fastjson.JSON;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class CommonUtil {

    public static <T> T stringToObj(String valueStr, Class<T> clazz) {
        if (valueStr == null || valueStr.length()<=0 || clazz == null) {
            return  null;
        }
        if (clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(valueStr);
        } else if (clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(valueStr);
        } else if (clazz == String.class){
            return (T)valueStr;
        }
        return JSON.toJavaObject(JSON.parseObject(valueStr), clazz);

    }

    public static <T> String objToString(T value){
        Class<?> clazz = value.getClass();
        if (value == null || clazz == null) {
            return  null;
        }
        if (clazz == int.class || clazz == Integer.class){
            return ""+value;
        } else if (clazz == long.class || clazz == Long.class){
            return ""+value;
        } else if (clazz == String.class){
            return (String)value;
        }
        return JSON.toJSONString(value);


    }
}
