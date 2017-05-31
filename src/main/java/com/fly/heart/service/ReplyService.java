package com.fly.heart.service;

import com.fly.heart.bean.Reply;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
@Service
public interface ReplyService {

    Page<Reply> getReplyByTopicId(long topicId,int pageSize,int pageNum);
}
