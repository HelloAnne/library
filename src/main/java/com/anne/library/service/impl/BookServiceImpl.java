package com.anne.library.service.impl;

import com.anne.library.common.service.BaseServiceImpl;
import com.anne.library.domain.Book;
import com.anne.library.domain.BorrowRecord;
import com.anne.library.enums.DeletedFlagEnum;
import com.anne.library.rabbitmq.BorrowMessage;
import com.anne.library.rabbitmq.MQSender;
import com.anne.library.redis.BookKey;
import com.anne.library.redis.RedisService;
import com.anne.library.service.BookService;
import com.anne.library.utils.Result;
import com.anne.library.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Anne Zhang
 * Date: 2018/1/14
 * Description:
 */
@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService{

    @Autowired
    private RedisService redisService;

    @Autowired
    private MQSender mqSender;

    /**
     * 根据主键逻辑删除book
     * 1. 系统初始化，将book属性加载到redis；
     * 2. 收到请求，redis预变更状态，若已删除直接返回，否则执行第3步；
     * 3. 请求入队，返回排队中；
     * 4. 请求出队，更改状态；
     * 5. 客户端轮询，是否删除成功。
     * @param bookId
     * @return
     */
    @Override
    public int logicalDeleteBookPrimaryKey(Long bookId) {

        return 0;
    }

    /**
     * 产生借阅、更新库存、生成节约记录。
     * 1. 系统初始化，将book属性加载到redis；
     * 2. 收到请求，redis预变更状态，若库存<1直接返回，否则执行第3步；
     * 3. 请求入队，返回排队中；
     * 4. 请求出队，更改状态；
     * 5. 客户端轮询，是否删除成功。
     * @param bookId
     * @return
     */
    @Override
    public Result<Object> borrowBook(Long bookId) {
        // TODO 获取当前登录人
        Long userId = 0l;

        // 判断是否上架
        String deletedFlag = redisService.get(BookKey.deletedFlag, ""+bookId, String.class);
        if (DeletedFlagEnum.ACTIVE.equals(deletedFlag)){
            return Result.fail(ReturnUtil.RETURN_CODE_BOOK_HAS_DELETED, ReturnUtil.RETURN_MSG_BOOK_HAS_DELETED);
        }

        // 预减库存
        long stock = redisService.decr(BookKey.bookStocks, ""+bookId);
        if(stock < 0) {
            return Result.fail(ReturnUtil.RETURN_CODE_BOOK_SHORTAGE, ReturnUtil.RETURN_MSG_BOOK_SHORTAGE);
        }

        // TODO
        //判断是否已经借了这本书
        BorrowRecord borrowRecord = null;
        if(borrowRecord != null) {
            return Result.fail(ReturnUtil.RETURN_CODE_REPEAT_BORROW, ReturnUtil.RETURN_MSG_REPEAT_BORROW);
        }

        // 入队
        BorrowMessage borrowMessage = new BorrowMessage();
        borrowMessage.setUserId(userId);
        borrowMessage.setBookId(bookId);
        mqSender.sendBorrowMessage(borrowMessage);
        return Result.ok();//排队中
    }


    @Override
    public List<Book> selectAllBooks(){
        // TODO
        return null;
    }
}
