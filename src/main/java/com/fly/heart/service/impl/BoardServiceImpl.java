package com.fly.heart.service.impl;

import com.fly.heart.bean.Board;
import com.fly.heart.bean.Topic;
import com.fly.heart.dao.BoardDao;
import com.fly.heart.dao.TopicDao;
import com.fly.heart.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDao boardDao;
    @Autowired
    TopicDao topicDao;
    @Override
    public List<Board> getAllBoard() {
        return boardDao.findAll();
    }

    @Override
    public Board getBoardById(Long id) {
        return boardDao.findOne(id);
    }

    @Override
    public List<Map<String,Object>> getBoardWithTopics() {
        List<Map<String,Object>> ls = new ArrayList<>();
        for(Board board :boardDao.findAll()){
            List<Topic> list = topicDao.findAllByBoardId(board.getId());
            Map<String,Object> map = new HashMap<>();
            map.put("board",board);
            map.put("topicCount",list.size());
            map.put("topicList",list);
            ls.add(map);
        }
        return ls;
    }
}
