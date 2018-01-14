package com.anne.library.common.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public abstract class EntityBean<K extends Serializable> implements Serializable {
    private static final long serialVersionUID = 2741604299092756219L;

    public abstract K getId();

    public abstract void setId(K id);

    public abstract K getLastModifiedBy();

    public abstract void setLastModifiedBy(K lastModifiedBy);

    public abstract K getCreateBy();

    public abstract void setCreateBy(K createBy);

    @Column(name = "DELETED_FLAG")
    private String deletedFlag;

    @Column(name = "GMT_CREATE")
    private Date gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date gmtModified;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;


    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getModificationNum() {
        return modificationNum;
    }

    public void setModificationNum(Integer modificationNum) {
        this.modificationNum = modificationNum;
    }


}

