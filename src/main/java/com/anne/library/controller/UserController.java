package com.anne.library.controller;

import com.anne.library.common.controller.BaseController;
import com.anne.library.dao.UserDAO;
import com.anne.library.domain.User;
import com.anne.library.domain.dto.UserDTO;
import com.anne.library.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Anne Zhang
 * Date: 2018/1/17 0017
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User,UserDTO,UserService> {
}
