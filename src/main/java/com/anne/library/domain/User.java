package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class User{

    /**
     * 主键
     */
    private int id;

    /**
     * 用户名（登录用，唯一）
     */
    private String userName;

    /**
     * 密码（md5加密后）
     */
    private String password;

    /**
     * 手机号码
     */
    private String telNum;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 状态（StatusEnum：停用0，激活1）
     */
    private String status;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
