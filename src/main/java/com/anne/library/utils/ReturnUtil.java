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
    public static String RETURN_CODE_SUCCESS = "200";
    public static String RETURN_MSG_SUCCESS = "操作成功。";


    /**
     * 3001=book已下架
     */
    public static String RETURN_CODE_BOOK_HAS_DELETED = "3001";
    public static String RETURN_MSG_BOOK_HAS_DELETED = "图书已下架。";

    /**
     * 3002=book库存不足
     */
    public static String RETURN_CODE_BOOK_SHORTAGE = "3002";
    public static String RETURN_MSG_BOOK_SHORTAGE = "图书库存不足。";

    /**
     * 3003=重复借阅
     */
    public static String RETURN_CODE_REPEAT_BORROW = "3003";
    public static String RETURN_MSG_REPEAT_BORROW = "重复借阅";

}
