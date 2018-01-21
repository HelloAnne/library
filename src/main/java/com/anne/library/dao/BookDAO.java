package com.anne.library.dao;

import com.anne.library.common.dao.CommonMapper;
import com.anne.library.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Mapper
public interface BookDAO extends CommonMapper<Book>{

}
