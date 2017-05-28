package com.flay.heart.controller.impl;

import com.flay.heart.bean.Topic;
import com.flay.heart.controller.TopicController;
import com.flay.heart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Controller
public class TopicControllerImpl implements TopicController{

    @Autowired
    TopicService topicService;

    @Override
    public List<Topic> getTopicByBoardId(long boardId) {
        return topicService.getTopicByBoardId(boardId);
    }

    @Override
    public List<Topic> getTopicByUserId(long userId) {
        return topicService.getTopicByUserId(userId);
    }
}
