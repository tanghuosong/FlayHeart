package com.fly.heart.v1.impl;

import com.fly.heart.bean.Topic;
import com.fly.heart.service.TopicService;
import com.fly.heart.v1.TopicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Controller
public class TopicControllerImpl implements TopicController{

    @Autowired
    private TopicService topicService;

    @Override
    public List<Topic> getTopicByBoardId(long boardId) {
        return topicService.getTopicByBoardId(boardId);
    }

    @Override
    public List<Topic> getTopicByUserId(long userId) {
        return topicService.getTopicByUserId(userId);
    }

    @Override
    public Page<Topic> getBoardByBoardIdWithPage(long boardId, int pageSize, int pageNum) {
        return topicService.getBoardWithTopTen(boardId,pageSize,pageNum);
    }
}
