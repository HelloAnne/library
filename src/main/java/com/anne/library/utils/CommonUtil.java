package com.anne.library.utils;

import com.alibaba.fastjson.JSON;
import com.anne.library.exception.GlobelExceptionHandler;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

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

    public static<T> T initBean(T t) throws InvocationTargetException, IllegalAccessException {
        Method[] mds = t.getClass().getMethods();
        for (Method m : mds) {
            String mName = m.getName();
            if ("setDeletedFlag".equalsIgnoreCase(mName)) {
                m.invoke(t, "0");
            }else if("setModificationNum".equalsIgnoreCase(mName)) {
                m.invoke(t, 0);
            }else if("setOriginApp".equalsIgnoreCase(mName)) {
                m.invoke(t, "-1");
            }else if("setOriginFlag".equalsIgnoreCase(mName)) {
                m.invoke(t, "I");
            }else if("setGmtModified,setGmtCreate".indexOf(mName) > -1) {
                m.invoke(t, new Date());
            }else if("setCreateBy".equalsIgnoreCase(mName)){
                m.invoke(t, Long.parseLong("-1"));
            }else if("setLastModifiedBy".equalsIgnoreCase(mName)){
                m.invoke(t, Long.parseLong("-1"));
            }
        }
        return t;
    }


}
