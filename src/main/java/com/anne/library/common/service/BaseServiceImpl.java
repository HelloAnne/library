package com.anne.library.common.service;

import com.anne.library.common.dao.CommonMapper;
import com.anne.library.common.domain.EntityBean;
import com.anne.library.enums.DeletedFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public abstract class BaseServiceImpl<T extends EntityBean> implements BaseService<T> {
    @Autowired
    protected CommonMapper<T> mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(T record) {
        return mapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T selectByPrimaryKey(Object key) {
        return  mapper.selectByPrimaryKey(key);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKeyLogical(T record) {
        record.setDeletedFlag(DeletedFlagEnum.DELETED.getValue());
        record.setGmtModified(new Date());
        return mapper.updateByPrimaryKeySelective(record);
    }

}
