package com.anne.library.common.service;

import com.anne.library.common.dao.CommonMapper;
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
public interface BaseService <T extends EntityBean> extends CommonMapper<T> {

}