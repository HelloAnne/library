package com.anne.library.common.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

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

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Timestamp LastModifiedDate;

    @Column(name = "DELETED_FLAG")
    private String deletedFlag;

    @Column(name = "MODIFICATION_NUM")
    private Integer modificationNum;

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Integer getModificationNum() {
        return modificationNum;
    }

    public void setModificationNum(Integer modificationNum) {
        this.modificationNum = modificationNum;
    }


}

