package com.anne.library.utils;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class ReturnUtil {
    private ReturnUtil(){}

    /**
     * 200=成功
     */
    public static final String RETURN_CODE_SUCCESS = "200";
    public static final String RETURN_MSG_SUCCESS = "操作成功。";


    /**
     * 3001=book已下架
     */
    public static final String RETURN_CODE_BOOK_HAS_DELETED = "3001";
    public static final String RETURN_MSG_BOOK_HAS_DELETED = "图书已下架。";

    /**
     * 3002=book库存不足
     */
    public static final String RETURN_CODE_BOOK_SHORTAGE = "3002";
    public static final String RETURN_MSG_BOOK_SHORTAGE = "图书库存不足。";

    /**
     * 3003=重复借阅
     */
    public static final String RETURN_CODE_REPEAT_BORROW = "3003";
    public static final String RETURN_MSG_REPEAT_BORROW = "重复借阅";

    /**
     * 5001=实例化对象失败
     */
    public static final String RETURN_CODE_ERROR_CREATE_BEAN = "5001";
    public static final String RETURN_MSG_ERROR_CREATE_BEAN = "实例化更新对象失败";

    /**
     * 5002=对象不存在
     */
    public static final String RETURN_CODE_OBJECT_NOT_EXIST = "5002";
    public static final String RETURN_MSG_OBJECT_NOT_EXIST = "对象不存在";

}
