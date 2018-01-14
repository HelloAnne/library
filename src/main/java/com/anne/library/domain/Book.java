package com.anne.library.domain;

import java.io.Serializable;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class Book {

    /**
     * 主键
     */
    private Long id;

    /**
     * 书架id
     */
    private Long bookshelfId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者名
     */
    private String authorName;

    /**
     * 封面路径
     */
    private String bookCoverImg;

    /**
     * 简介
     */
    private String bookIntroduction;

    /**
     * 价格
     */
    private Double bookPrice;

    /**
     * 库存
     */
    private Integer bookStock;

    /**
     * 是否下架（DeletedFlagEnum：未下架0，已下架1）
     */
    private String deletedFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(Long bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookCoverImg() {
        return bookCoverImg;
    }

    public void setBookCoverImg(String bookCoverImg) {
        this.bookCoverImg = bookCoverImg;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}
