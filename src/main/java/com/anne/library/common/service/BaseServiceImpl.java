package com.anne.library.common.service;

import com.anne.library.common.dao.CommonMapper;
import com.anne.library.common.domain.EntityBean;
import com.anne.library.enums.DeletedFlagEnum;
import com.anne.library.utils.ReturnUtil;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public abstract class BaseServiceImpl<T extends EntityBean> implements BaseService<T> {

    @Autowired
    protected CommonMapper<T> mapper;

    protected static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Object key){
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(T record) {
        return mapper.delete(record);
    }


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
    public boolean existsWithPrimaryKey(Object key) {
        return mapper.existsWithPrimaryKey(key);
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
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> select(T record) {
        return mapper.select(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public T selectOne(T record) {
        return  mapper.selectOne(record);
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

}
