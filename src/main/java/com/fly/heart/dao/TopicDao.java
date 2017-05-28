package com.fly.heart.dao;

import com.fly.heart.bean.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
public interface TopicDao extends CrudRepository<Topic,Long>,PagingAndSortingRepository<Topic,Long>{

    List<Topic> findAllByBoardId(long boardId);

    List<Topic> findAllByUserId(long userId);

}
