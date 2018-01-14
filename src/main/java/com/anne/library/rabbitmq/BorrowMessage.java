package com.anne.library.rabbitmq;

/**
 * Author: Anne Zhang
 * Date: 2018/1/15
 * Description:
 */
public class BorrowMessage {

    private Long userId;
    private Long bookId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
