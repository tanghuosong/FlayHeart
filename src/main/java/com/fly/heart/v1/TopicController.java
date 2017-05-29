package com.fly.heart.v1;

import com.fly.heart.bean.Topic;
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
@RequestMapping (value = "/topic")
@Controller
public interface TopicController {

    @RequestMapping(value = "/getTopicsByBoardId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByBoardId(long boardId);

    @RequestMapping(value = "/getTopicsByUserId",method = RequestMethod.GET)
    @ResponseBody
    List<Topic> getTopicByUserId(long boardId);

    @RequestMapping(value = "/getBoardByBoardIdWithPage",method = RequestMethod.GET)
    @ResponseBody
    Page<Topic> getBoardByBoardIdWithPage(long boardId, int pageSize, int pageNum);
}