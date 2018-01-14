package com.anne.library.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{8}$");

    public static boolean isTelNum(String telNum){
        if(StringUtils.isEmpty(telNum)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(telNum);
        return m.matches();
    }
}
