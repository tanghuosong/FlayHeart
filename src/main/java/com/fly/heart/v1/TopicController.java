package com.fly.heart.v1;

import com.fly.heart.bean.Topic;
import com.fly.heart.utils.Message;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@RequestMapping (value = "/v1/topic")
@Controller
public interface TopicController {

    @RequestMapping(value = "/getTopicsByBoardId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByBoardId(long boardId);

    @RequestMapping(value = "/getTopicsByUserId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByUserId(long boardId);

    @RequestMapping(value = "/getTopicByCondition",method = RequestMethod.GET)
    @ResponseBody
    Page<Topic> getBoardByCondition(String conditionType,long conditionValue,int pageSize,int pageNum);

    @RequestMapping(value = "/writeTopic",method = RequestMethod.POST)
    @ResponseBody
    Message writePost(long boardId,String title,String content);

    @RequestMapping(value = "/updateTopicState",method = RequestMethod.POST)
    @ResponseBody
    Message updateTopicState(int state, long topicId);

    @RequestMapping(value = "/deleteTopicById",method = RequestMethod.POST)
    @ResponseBody
    Message deleteTopicById(long topicId);
}
