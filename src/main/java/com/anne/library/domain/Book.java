package com.anne.library.domain;

import com.anne.library.common.domain.EntityBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Table(name = "book")
public class Book extends EntityBean<Long>{

    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "JDBC")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (bookshelfId != null ? !bookshelfId.equals(book.bookshelfId) : book.bookshelfId != null) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (authorName != null ? !authorName.equals(book.authorName) : book.authorName != null) return false;
        if (bookCoverImg != null ? !bookCoverImg.equals(book.bookCoverImg) : book.bookCoverImg != null) return false;
        if (bookIntroduction != null ? !bookIntroduction.equals(book.bookIntroduction) : book.bookIntroduction != null)
            return false;
        if (bookPrice != null ? !bookPrice.equals(book.bookPrice) : book.bookPrice != null) return false;
        if (bookStock != null ? !bookStock.equals(book.bookStock) : book.bookStock != null) return false;
        if (createBy != null ? !createBy.equals(book.createBy) : book.createBy != null) return false;
        return lastModifiedBy != null ? lastModifiedBy.equals(book.lastModifiedBy) : book.lastModifiedBy == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookshelfId != null ? bookshelfId.hashCode() : 0);
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (bookCoverImg != null ? bookCoverImg.hashCode() : 0);
        result = 31 * result + (bookIntroduction != null ? bookIntroduction.hashCode() : 0);
        result = 31 * result + (bookPrice != null ? bookPrice.hashCode() : 0);
        result = 31 * result + (bookStock != null ? bookStock.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        return result;
    }
}
