package com.fly.heart.v1;

import com.fly.heart.bean.Board;
import com.fly.heart.bean.Topic;
import com.fly.heart.service.BoardService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@RequestMapping(value = "/v1/board")
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/getAllBoard",method = RequestMethod.GET)
    @ResponseBody
    List<Board> getAllBoard(){
        return boardService.getAllBoard();
    }

    @RequestMapping(value = "/getBoardById",method = RequestMethod.GET)
    @ResponseBody
    Board getBoardById(long id){
        return boardService.getBoardById(id);
    }

    @RequestMapping(value = "/getBoardWithTopic",method = RequestMethod.GET)
    @ResponseBody
    List<Map<String,Object>> getBoardWithTopic(){
        return boardService.getBoardWithTopics();
    }

    @RequestMapping(value = "/saveBoard",method = RequestMethod.POST)
    @ResponseBody
    Message savaBoard(Board board){
        return boardService.saveBoard(board);
    }

    @RequestMapping(value = "/deleteBoardById",method = RequestMethod.POST)
    @ResponseBody
    Message deleteBoardById(Long id){
        return boardService.deleteBoardById(id);
    }

    @RequestMapping(value = "/updateBoard",method = RequestMethod.POST)
    @ResponseBody
    Message updateBoard(Board board){
        return boardService.updateBoard(board);
    }
}
