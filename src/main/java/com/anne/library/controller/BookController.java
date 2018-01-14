package com.anne.library.controller;

import com.anne.library.domain.Book;
import com.anne.library.domain.BorrowRecord;
import com.anne.library.enums.DeletedFlagEnum;
import com.anne.library.redis.BookKey;
import com.anne.library.redis.RedisService;
import com.anne.library.service.impl.BookServiceImpl;
import com.anne.library.utils.Result;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */

@RestController
@RequestMapping("/book")
public class BookController implements InitializingBean {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private RedisService redisService;

    /**
     * 系统初始化，向缓存中加载数据。
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<Book> books = bookService.selectAllBooks();
        books.stream().forEach(book->{

            // 将book的下架标示读取到缓存中。
            redisService.set(BookKey.deletedFlag, ""+book.getId(), book.getDeletedFlag());

            // 若book未下架，将其库存加载到缓存中。
            if (DeletedFlagEnum.ACTIVE.equals(book.getDeletedFlag())){
                redisService.set(BookKey.bookStocks, ""+book.getId(), book.getBookStock());
            }
        });
    }

    @RequestMapping(value="/{bookId}/borrow", method=RequestMethod.POST)
    public Result borrowBook(@PathVariable("bookId") Long bookId){
        return bookService.borrowBook(bookId);
    }
}
