package com.anne.library.dao;

import com.anne.library.common.dao.CommonMapper;
import com.anne.library.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Mapper
public interface UserDAO extends CommonMapper<User> {
}
