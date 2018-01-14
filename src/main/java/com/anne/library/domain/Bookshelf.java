package com.anne.library.domain;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class Bookshelf {

    /**
     * 主键
     */
    private Long id;

    /**
     * 阅览室id
     */
    private Long readingRoomId;

    /**
     * 书架名称
     */
    private String bookShelfName;

    /**
     * 状态（StatusEnum：停用0，激活1）
     */
    private String status;

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
}
