package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

import javax.persistence.*;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Table(name = "user")
public class User extends EntityBean<Long> {

    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名（登录用，唯一）
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 密码（md5加密后）
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 手机号码
     */
    @Column(name = "TEL_NUM")
    private String telNum;

    /**
     * 真实姓名
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * 状态（StatusEnum：停用0，激活1）
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 记录创建人ID
     */
    @Column(name = "CREATE_BY")
    private Long createBy;

    /**
     * 记录最近修改人ID
     */
    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    @Override
    public Long getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
