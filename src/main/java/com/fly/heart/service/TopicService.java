package com.fly.heart.service;

import com.fly.heart.bean.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public interface TopicService {

    List<Topic> getTopicByBoardId(long boardId);

    List<Topic> getTopicByUserId(long userId);
}
