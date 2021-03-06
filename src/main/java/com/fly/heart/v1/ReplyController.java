package com.fly.heart.v1;

import com.fly.heart.bean.Reply;
import com.fly.heart.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
@Controller
@RequestMapping(value = "/v1/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/getReplyByTopicId",method = RequestMethod.GET)
    @ResponseBody
    Page<Reply> getReplyByTopicId(long topicId,int pageSize,int pageNum){
        return replyService.getReplyByTopicId(topicId,pageSize,pageNum);
    }
}
