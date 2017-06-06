package com.fly.heart.dao;

import com.fly.heart.bean.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description: 帖子持久层操作接口
 **/
public interface TopicDao extends CrudRepository<Topic,Long>,PagingAndSortingRepository<Topic,Long>{

    List<Topic> findAllByBoardId(long boardId);

    List<Topic> findAllByUserId(long userId);

    @Override
    Page<Topic> findAll(Pageable pageable);

    /* 根据分类ID分页查询 */
    @Query(value = "select t from Topic t where t.boardId = :boardId")
    Page<Topic> findAllByBoardId(@Param("boardId") long boardId, Pageable pageable);

    /* 根据用户Id,分页查询帖子信息*/
    @Query(value = "select t from Topic t where t.userId = :userId")
    Page<Topic> findAllByUserId(@Param("userId") long userId, Pageable pageable);

    /* 根据状态查询所有帖子 */
    @Query(value = "select t from Topic t where t.state = :state")
    Page<Topic> findAllByState(@Param("state") long boardId, Pageable pageable);

    /* 修改帖子状态 */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Topic t set t.state= :state ,t.stateDisplay = :stateDisplay where t.id =:id")
    int updateTopicState(@Param("state") int state,@Param("stateDisplay")String stateDisplay,@Param("id")long id);

}
