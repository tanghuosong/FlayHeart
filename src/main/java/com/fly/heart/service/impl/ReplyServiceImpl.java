package com.fly.heart.service.impl;

import com.fly.heart.bean.Reply;
import com.fly.heart.dao.ReplyDao;
import com.fly.heart.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    ReplyDao replyDao;

    @Override
    public Page<Reply> getReplyByTopicId(long topicId, int pageSize, int pageNum) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(pageNum,pageSize,sort);
        return replyDao.findByTopicId(topicId,pageable);
    }
}
