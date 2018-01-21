package com.anne.library.controller;

import com.anne.library.common.controller.BaseController;
import com.anne.library.dao.ReadingRoomDAO;
import com.anne.library.domain.ReadingRoom;
import com.anne.library.domain.dto.ReadingRoomDTO;
import com.anne.library.service.ReadingRoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Anne Zhang
 * Date: 2018/1/17 0017
 * Description:
 */
@RestController
@RequestMapping("/readingRoom")
public class ReadingRoomController extends BaseController<ReadingRoom,ReadingRoomDTO,ReadingRoomService> {
}
