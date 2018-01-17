package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Table(name = "book_record")
public class BorrowRecord  extends EntityBean<Long> {

    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 借阅人id
     */
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 图书id
     */
    @Column(name = "BOOK_ID")
    private Long bookId;

    /**
     * 借出时间
     */
    @Column(name = "BORROW_TIME")
    private Timestamp borrowTime;

    /**
     * 归还时间
     */
    @Column(name = "RETURN_TIME")
    private Timestamp returnTime;

    /**
     * 记录创建人ID
     */
    @Column(name = "CREATE_BY")
    private Long createBy;

    /**
     * 记录最近修改人ID
     */
    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

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

    @Override
    public Long getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

}
