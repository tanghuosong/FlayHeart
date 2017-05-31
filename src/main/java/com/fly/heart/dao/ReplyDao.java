package com.fly.heart.dao;

import com.fly.heart.bean.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
public interface ReplyDao extends CrudRepository<Reply,Long>,PagingAndSortingRepository<Reply,Long>{

    // 通过帖子id 获取所有的回复并实现分页
    @Query(value = "select r from Reply r where r.topicId = :topicId")
    Page<Reply> findByTopicId(@Param("topicId") long boardId, Pageable pageable);

    // 通过帖子Id删除所有回帖
    void deleteByTopicId(long topicId);


}
