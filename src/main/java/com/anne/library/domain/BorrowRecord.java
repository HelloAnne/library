package com.anne.library.domain;

import java.sql.Timestamp;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class BorrowRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 借阅人id
     */
    private Long userId;

    /**
     * 图书id
     */
    private Long bookId;

    /**
     * 借出时间
     */
    private Timestamp borrowTime;

    /**
     * 归还时间
     */
    private Timestamp returnTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }
}
