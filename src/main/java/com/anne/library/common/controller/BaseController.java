package com.anne.library.common.controller;

import com.anne.library.common.domain.EntityBean;
import com.anne.library.common.service.BaseService;
import com.anne.library.enums.DeletedFlagEnum;
import com.anne.library.utils.CommonUtil;
import com.anne.library.utils.Result;
import com.anne.library.utils.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Anne Zhang
 * Date: 2018/1/15 0015
 * Description:
 */
public abstract class BaseController <T extends EntityBean<Long>,DTO,SERVICE extends BaseService<T>>{

    @Autowired
    protected SERVICE service;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/{id}/view",method= RequestMethod.GET)
    public @ResponseBody Result<DTO> getOne(@PathVariable("id") String id){
        T entityBean = getEntityBean();
        entityBean.setId(new Long(id));
        entityBean = service.selectByPrimaryKey(entityBean);
        if(null == entityBean){
            return Result.fail(ReturnUtil.RETURN_CODE_OBJECT_NOT_EXIST,ReturnUtil.RETURN_MSG_OBJECT_NOT_EXIST);
        }
        DTO dto = getDtoBean();
        BeanUtils.copyProperties(entityBean, dto);
        return Result.ok(dto);
    }

    @RequestMapping(value="/byParam/query",method=RequestMethod.POST)
    public @ResponseBody Result<List<DTO>> queryByParam(@RequestBody DTO dto) {
        Result<List<DTO>> result = new Result<>();
        T entityBean = getEntityBeanAndCopyProperties(dto);
        entityBean.setDeletedFlag(DeletedFlagEnum.ACTIVE.getValue());
        List<T> entities = service.select(entityBean);
        List<DTO> dtos = new ArrayList<>();
        for(T entity:entities){
            DTO dtobean = getDtoBean();
            BeanUtils.copyProperties(entity, dtobean);
            dtos.add(dtobean);
        }
        result.setDatas(dtos);
        return result;
    }

    @RequestMapping(value = "/byParam/queryOne", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Result<DTO> selectOne(@RequestBody DTO dto) {
        T entityBean = getEntityBeanAndCopyProperties(dto);
        entityBean = service.selectOne(entityBean);
        DTO dtobean = getDtoBean();
        if (entityBean == null) {
            return Result.fail(ReturnUtil.RETURN_CODE_OBJECT_NOT_EXIST,ReturnUtil.RETURN_MSG_OBJECT_NOT_EXIST);
        }else{
            BeanUtils.copyProperties(entityBean, dtobean);
            return Result.ok(dtobean);
        }
    }


    @RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
    public @ResponseBody Result saveOrUpdate(@RequestBody DTO dto){
        Result<T> result = new Result<>();
        T entityBean = getEntityBeanAndCopyProperties(dto);
        if(null == entityBean.getId()){
            // 初始化基础值
            try {
                CommonUtil.initBean(entityBean);
            } catch (Exception e) {
                logger.error(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
                // TODO exception
                throw new RuntimeException(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
            }
            this.service.insert(entityBean);
        }else{
            // 只更新not null的字段
            this.service.updateByPrimaryKeySelective(entityBean);
        }
        result.setDatas(entityBean);
        return result;
    }

    private T getEntityBeanAndCopyProperties(DTO dto){
        T entityBean = getEntityBean();
        BeanUtils.copyProperties(dto, entityBean);
        return entityBean;
    }

    private T getEntityBean(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<T> clazz = (Class) params[0] ;
        T entityBean;
        try {
            entityBean = clazz.newInstance();
        } catch (Exception e) {
            logger.error(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
            // TODO exception
            throw new RuntimeException(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
        }
        return entityBean;
    }

    private DTO getDtoBean(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<DTO> clazz = (Class) params[1] ;
        DTO dtoBean;
        try {
            dtoBean = clazz.newInstance();
        } catch (Exception e) {
            logger.error(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
            // TODO exception
            throw new RuntimeException(ReturnUtil.RETURN_MSG_ERROR_CREATE_BEAN, e);
        }
        return dtoBean;
    }
}

