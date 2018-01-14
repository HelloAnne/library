package com.anne.library.enums;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public enum DeletedFlagEnum {

    DELETED("已删除","1"),
    ACTIVE("未删除","0");

    private String description;
    private String value;

    DeletedFlagEnum(String description,String value){
        this.description=description;
        this.value=value;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
}
