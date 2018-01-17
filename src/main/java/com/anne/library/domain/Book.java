package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public class Book extends EntityBean<Long>{

    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private Long id;

    /**
     * 书架id
     */
    @Column(name = "BOOK_SHELF_ID")
    private Long bookshelfId;

    /**
     * 书名
     */
    @Column(name = "BOOK_NAME")
    private String bookName;

    /**
     * 作者名
     */
    @Column(name = "AUTHOR_NAME")
    private String authorName;

    /**
     * 封面路径
     */
    @Column(name = "BOOK_COVER_IMG")
    private String bookCoverImg;

    /**
     * 简介
     */
    @Column(name = "BOOK_INTRODUCTION")
    private String bookIntroduction;

    /**
     * 价格
     */
    @Column(name = "BOOK_PRICE")
    private Double bookPrice;

    /**
     * 库存
     */
    @Column(name = "BOOK_STOCK")
    private Integer bookStock;

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
