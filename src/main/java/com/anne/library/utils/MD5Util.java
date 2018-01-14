package com.anne.library.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class MD5Util {
    public static String md5(String password){
        return DigestUtils.md5Hex(password);
    }
}
