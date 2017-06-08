package com.fly.heart.dao;

import com.fly.heart.bean.Board;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
public interface BoardDao extends CrudRepository<Board,Long> {

    @Override
    List<Board> findAll();

    @Override
    Board findOne(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from Board b where b.id = :id")
    int deleteBoardById(@Param("id") Long id);
}
