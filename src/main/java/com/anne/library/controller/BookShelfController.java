package com.anne.library.controller;

import com.anne.library.common.controller.BaseController;
import com.anne.library.dao.BookShelfDAO;
import com.anne.library.domain.BookShelf;
import com.anne.library.service.BookShelfService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Anne Zhang
 * Date: 2018/1/17 0017
 * Description:
 */
@RestController
@RequestMapping("/bookShelf")
public class BookShelfController extends BaseController<BookShelf,BookShelfDAO,BookShelfService>{
}
