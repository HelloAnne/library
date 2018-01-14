package com.anne.library.enums;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public enum StatusEnum {
    DISABLED("停用","0"),
    ACTIVE("启用","1");

    private String description;
    private String value;

    StatusEnum(String description,String value){
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
