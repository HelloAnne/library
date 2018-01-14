package com.anne.library.common.service;

import com.anne.library.common.domain.EntityBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public interface BaseService <T extends EntityBean> extends Mapper<T> {


    /**
     * 公用逻辑删除
     * @param key 对象中的属性是要删除的条件
     * @return 删除条数
     */
    int deleteByPrimaryKeyLogical(T key);
}