package com.anne.library.utils;

import java.io.Serializable;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class Result <T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回结果数据
     */
    private T datas;
    /**
     * 提示消息
     */
    private String returnMessage;

    /**
     * 编码
     */
    private String code="200";

    /**
     * 异常信息
     */
    private Throwable throwable;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public static <T> Result<T> ok(T data) {
        Result<T> resp = new Result<T>();
        resp.setDatas(data);
        resp.setCode(ReturnUtil.RETURN_CODE_SUCCESS);

        return resp;
    }

    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    public static <T> Result<T> fail(String code,String errorMsg) {
        Result<T> resp = new Result<T>();
        resp.setCode(code);
        resp.setReturnMessage(errorMsg);
        return resp;
    }

}

