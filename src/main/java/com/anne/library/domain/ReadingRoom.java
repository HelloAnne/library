package com.anne.library.domain;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class ReadingRoom {
    /**
     * 主键
     */
    private Long id;

    /**
     * 阅览室名
     */
    private String readingRoomName;

    /**
     * 阅览室位置
     */
    private String location;

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

    public String getReadingRoomName() {
        return readingRoomName;
    }

    public void setReadingRoomName(String readingRoomName) {
        this.readingRoomName = readingRoomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
