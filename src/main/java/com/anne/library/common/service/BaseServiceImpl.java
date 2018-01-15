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

    /**
     * 得到一个填充了主键的业务实体类
     * @param id 主键id
     * @param <K> 主键类型
     * @return
     */
    protected  <K extends Serializable> T getBean(K id) {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<T> clazz = (Class) params[0] ;
        T bean;
        try {
            bean = clazz.newInstance();
        } catch (Exception e) {
            logger.error(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
            // TODO exception
            throw new RuntimeException(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
        }
        bean.setId(id);
        return bean;
    }


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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByExample(T record, Object example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByExampleSelective(T record, Object example) {
        return mapper.updateByExampleSelective(record,example);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return mapper.selectByRowBounds(record,rowBounds);
    }



}
