package com.fly.heart.v1.impl;

import com.fly.heart.bean.Board;
import com.fly.heart.v1.BoardController;
import com.fly.heart.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Controller
public class BoardControllerImpl implements BoardController {

    public BoardControllerImpl(){
        System.out.println("进入-----BoardControllerImpl");
    }

    @Autowired
    BoardService boardService;

    public List<Board> getAllBoard(){
        return boardService.getAllBoard();
    }

    @Override
    public Board getBoardById(long id) {
        return boardService.getBoardById(id);
    }

    @Override
    public List<Map<String, Object>> getBoardWithTopic() {
        return boardService.getBoardWithTopics();
    }
}
