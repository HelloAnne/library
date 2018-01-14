package com.anne.library.redis;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class BookKey  extends BasePrefix{

    private BookKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static BookKey deletedFlag = new BookKey(0,"deletedFlag");
    public static BookKey bookStocks = new BookKey(0,"bookStocks");
}
