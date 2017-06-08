package com.fly.heart.service.impl;

import com.fly.heart.bean.Board;
import com.fly.heart.bean.Topic;
import com.fly.heart.dao.BoardDao;
import com.fly.heart.dao.TopicDao;
import com.fly.heart.service.BoardService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(0, 10, sort);
            Page<Topic> page = topicDao.findAllByBoardId(board.getId(),pageable);
            Map<String,Object> map = new HashMap<>();
            map.put("board",board);
            map.put("topicList",page);
            ls.add(map);
        }
        return ls;
    }

    @Override
    public Message saveBoard(Board board) {

        Message message = new Message();
        try {
            if(null == board.getName() || "".equals(board.getName().trim())){
                message.setContent("请填写版块名称");
                message.setSuccess(false);
            }else if (null == board.getDescription() || "".equals(board.getDescription().trim())){
                message.setContent("请填写版块描述");
                message.setSuccess(false);
            }else{
                board.setState(100L);
                board.setStateDisplay("上线");
                board.setCreateTime(new Timestamp(System.currentTimeMillis()));
                boardDao.save(board);
                message.setSuccess(true);
                message.setContent("添加成功！");
            }
        }catch (Exception e){
            message.setContent("添加失败:"+e.getMessage());
            message.setSuccess(false);
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public Message deleteBoardById(Long id) {
        Message message = new Message();
       try{
           int result = boardDao.deleteBoardById(id);
           if(result == 1){
                message.setSuccess(true);
                message.setContent("删除成功！");
           }else{
                message.setContent("当前帖子不存在！");
                message.setSuccess(false);
           }
       }catch (Exception e){
           message.setContent("删除失败:"+e.getMessage());
           message.setSuccess(false);
           e.printStackTrace();
       }
        return message;
    }
}
