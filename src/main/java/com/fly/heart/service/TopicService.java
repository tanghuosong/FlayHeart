package com.fly.heart.service;

import com.fly.heart.bean.Topic;
import com.fly.heart.utils.Message;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public interface TopicService {

    Message writeTopic(long boardId,String title,String content);

    Message deleteTopic(long topicId);

    Message updateTopicState(int state,long topicId);

    List<Topic> getTopicByBoardId(long boardId);

    List<Topic> getTopicByUserId(long userId);

    /* 根据条件查询帖子信息
    * conditionType  为查询条件，
    * conditionValue 为查询条件的值
    * pageSize       为查询一页的数量
    * pageNum        为查询第几页
    * */
    Page<Topic> getTopicByConditionType(String conditionType, long conditionValue,int pageSize,int pageNum);

    Map<String,Object> getTopicByIdWithReply(long topicId);
}
