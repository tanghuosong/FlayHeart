package com.flay.heart.controller;

import com.flay.heart.bean.Board;
import com.flay.heart.bean.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:Board 类控制器
 **/

@RequestMapping(value = "/board")
@Controller
public interface BoardController {

    @RequestMapping(value = "/getAllBoard",method = RequestMethod.GET)
    @ResponseBody
    List<Board> getAllBoard();

    @RequestMapping(value = "/getBoardById",method = RequestMethod.GET)
    @ResponseBody
    Board getBoardById(long id);

    @RequestMapping(value = "/getBoardWithTopic",method = RequestMethod.GET)
    @ResponseBody
    List<Map<String,Object>> getBoardWithTopic();

}
