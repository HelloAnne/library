package com.anne.library.redis;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

public abstract class BasePrefix implements KeyPrefix {

    private int expiredSeconds;
    private String prefix;

    public BasePrefix(String prefix){ //永不过期
        this(0, prefix);
    }
    public BasePrefix(int expiredSeconds, String prefix){
        this.expiredSeconds = expiredSeconds;
        this.prefix = prefix;
    }

    @Override
    public int getExpiredSeconds() {
        // 默认0代表永不过期
        return 0;
    }

    @Override
    public String getPrefix() {
        String classMame = getClass().getSimpleName();
        return classMame + ":" + prefix;
    }
}


