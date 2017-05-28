package com.flay.heart.service.impl;

import com.flay.heart.bean.Topic;
import com.flay.heart.dao.TopicDao;
import com.flay.heart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class TopicServiceImpl implements TopicService{

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
