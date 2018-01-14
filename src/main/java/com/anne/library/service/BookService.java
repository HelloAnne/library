package com.anne.library.service;

import com.anne.library.domain.Book;
import com.anne.library.utils.Result;

import java.util.List;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
public interface BookService {

    int logicalDeleteBookPrimaryKey(Long bookId);

    Result<Object> borrowBook(Long bookId);

    List<Book> selectAllBooks();
}
