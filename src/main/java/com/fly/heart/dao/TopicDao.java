package com.fly.heart.dao;

import com.fly.heart.bean.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description: 帖子持久层操作接口
 **/
public interface TopicDao extends CrudRepository<Topic,Long>,PagingAndSortingRepository<Topic,Long>{

    List<Topic> findAllByBoardId(long boardId);

    List<Topic> findAllByUserId(long userId);

    // 分页查询
    @Query(value = "select t from Topic t where t.boardId = :boardId")
    Page<Topic> findAllByBoardIdAndGroupById(@Param("boardId") long boardId, Pageable pageable);

}
