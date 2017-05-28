package com.fly.heart.service.impl;

import com.fly.heart.bean.Topic;
import com.fly.heart.dao.TopicDao;
import com.fly.heart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDao topicDao;

    @Override
    public List<Topic> getTopicByBoardId(long boardId) {
        return topicDao.findAllByBoardId(boardId);
    }

    @Override
    public List<Topic> getTopicByUserId(long userId) {
        return topicDao.findAllByUserId(userId);
    }
}
