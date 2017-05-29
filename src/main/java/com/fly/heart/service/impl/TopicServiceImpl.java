package com.fly.heart.service.impl;

import com.fly.heart.bean.Topic;
import com.fly.heart.dao.TopicDao;
import com.fly.heart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> getTopicByBoardId(long boardId) {
        return topicDao.findAllByBoardId(boardId);
    }

    @Override
    public List<Topic> getTopicByUserId(long userId) {
        return topicDao.findAllByUserId(userId);
    }

    @Override
    public Page<Topic> getBoardWithTopTen(long boardId, int pageSize, int pageNum) {

        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(pageNum,pageSize,sort);
        return topicDao.findAllByBoardIdAndGroupById(boardId,pageable);
    }
}
