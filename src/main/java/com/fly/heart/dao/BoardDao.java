package com.fly.heart.dao;

import com.fly.heart.bean.Board;
import org.springframework.data.repository.CrudRepository;

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

}
