package com.flay.heart.service;

import com.flay.heart.bean.Board;
import com.flay.heart.bean.Topic;
import com.flay.heart.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public interface BoardService {

    List<Board> getAllBoard();

    Board getBoardById(Long id);

    List<Map<String,Object>> getBoardWithTopics();
}
