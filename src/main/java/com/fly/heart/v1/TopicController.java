package com.fly.heart.v1;

import com.fly.heart.bean.Topic;
import com.fly.heart.service.TopicService;
import com.fly.heart.utils.Message;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@RequestMapping (value = "/v1/topic")
@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/getTopicsByBoardId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByBoardId(long boardId){
        return topicService.getTopicByBoardId(boardId);
    }

    @RequestMapping(value = "/getTopicsByUserId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByUserId(long userId){
        return topicService.getTopicByUserId(userId);
    }

    @RequestMapping(value = "/getTopicByCondition",method = RequestMethod.GET)
    @ResponseBody
    Page<Topic> getBoardByCondition(String conditionType,long conditionValue,int pageSize,int pageNum){
        return topicService.getTopicByConditionType(conditionType,conditionValue,pageSize,pageNum);
    }

    @RequestMapping(value = "/writeTopic",method = RequestMethod.POST)
    @ResponseBody
    Message writePost(long boardId,String title,String content){
        return topicService.writeTopic(boardId,title,content);
    }

    @RequestMapping(value = "/updateTopicState",method = RequestMethod.POST)
    @ResponseBody
    Message updateTopicState(int state, long topicId){
        return topicService.updateTopicState(state,topicId);
    }

    @RequestMapping(value = "/deleteTopicById",method = RequestMethod.POST)
    @ResponseBody
    Message deleteTopicById(long topicId){
        return topicService.deleteTopic(topicId);
    }

    @RequestMapping(value = "/getTopicByIdWithReply",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getTopicByIdWithReply(long topicId){
        return topicService.getTopicByIdWithReply(topicId);
    }
}
