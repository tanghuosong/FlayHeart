package com.fly.heart.v1.impl;

import com.fly.heart.bean.Topic;
import com.fly.heart.service.TopicService;
import com.fly.heart.utils.Message;
import com.fly.heart.v1.TopicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

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
    public Page<Topic> getBoardByCondition(String conditionType, long conditionValue, int pageSize, int pageNum) {
        return topicService.getTopicByConditionType(conditionType,conditionValue,pageSize,pageNum);
    }

    @Override
    public Message writePost(long boardId, String title, String content) {
        return topicService.writeTopic(boardId,title,content);
    }

    @Override
    public Message updateTopicState(int state, long topicId) {
        return topicService.updateTopicState(state,topicId);
    }

    @Override
    public Message deleteTopicById(long topicId) {
        return topicService.deleteTopic(topicId);
    }

    @Override
    public Map<String, Object> getTopicByIdWithReply(long topicId) {
        return topicService.getTopicByIdWithReply(topicId);
    }
}
