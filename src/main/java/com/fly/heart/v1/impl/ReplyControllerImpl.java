package com.fly.heart.v1.impl;

import com.fly.heart.bean.Reply;
import com.fly.heart.service.ReplyService;
import com.fly.heart.v1.ReplyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
@Controller
public class ReplyControllerImpl implements ReplyController{

    @Autowired
    ReplyService replyService;

    @Override
    public Page<Reply> getReplyByTopicId(long topicId,int pageSize, int pageNum) {
        return replyService.getReplyByTopicId(topicId,pageSize,pageNum);
    }
}
