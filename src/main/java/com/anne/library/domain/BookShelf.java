package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Table(name = "book_shelf")
public class BookShelf extends EntityBean<Long>{

    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 阅览室id
     */
    @Column(name = "READING_ROOM_ID")
    private Long readingRoomId;

    /**
     * 书架名称
     */
    @Column(name = "BOOK_SHELF_NAME")
    private String bookShelfName;

    /**
     * 状态（StatusEnum：停用0，激活1）
     */
    @Column(name = "STATUS")
    private String status;

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

    public Long getReadingRoomId() {
        return readingRoomId;
    }

    public void setReadingRoomId(Long readingRoomId) {
        this.readingRoomId = readingRoomId;
    }

    public String getBookShelfName() {
        return bookShelfName;
    }

    public void setBookShelfName(String bookShelfName) {
        this.bookShelfName = bookShelfName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Long getLastModifiedBy() {
        return null;
    }

    @Override
    public void setLastModifiedBy(Long lastModifiedBy) {

    }

    @Override
    public Long getCreateBy() {
        return null;
    }

    @Override
    public void setCreateBy(Long createBy) {

    }
}
