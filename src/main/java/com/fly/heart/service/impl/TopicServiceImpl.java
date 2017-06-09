package com.fly.heart.service.impl;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fly.heart.bean.Board;
import com.fly.heart.bean.Reply;
import com.fly.heart.bean.Topic;
import com.fly.heart.bean.User;
import com.fly.heart.constants.TopicState;
import com.fly.heart.dao.ReplyDao;
import com.fly.heart.dao.TopicDao;
import com.fly.heart.service.TopicService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 ** created by tanghuosong 2017/5/28
 ** description:
 **/
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @Autowired
    ReplyDao replyDao;

    @Override
    public Message writeTopic(Board board, String title, String content) {

        Message message = new Message();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user != null){
            if(null == title || "".equals(title)){
                message.setContent( "请输入帖子主题");
                message.setSuccess(false);
            }else if(null == content || "".equals(content.trim())){
                message.setContent("请输入帖子内容");
                message.setSuccess(false);
            }else{
                Topic topic = new Topic(title,content,0,100,0L,board,user,"审核通过",new Timestamp(System.currentTimeMillis()));
                Topic topic1 = topicDao.save(topic);
                if(topic1 != null){
                    message.setContent("发帖成功");
                    message.setSuccess(true);
                }else{
                    message.setContent("发帖失败，请联系管理员");
                    message.setSuccess(false);
                }
            }
        }else{
            message.setSuccess(false);
            message.setContent("尚未登录，无法发帖！");
        }
        return message;
    }

    @Override
    public Message deleteTopic(long topicId) {
        Message message = new Message();
        User user = (User) session.getAttribute("user");
        if(user != null){
            // 首先判断该用户是否有权限更新该帖子状态
            Topic topic = topicDao.findOne(topicId);
            if(topic !=null){
                if(user.getId() == topic.getUser().getId()){
                    try{
                        topicDao.delete(topicId);
                        message.setContent("删除成功！");
                        message.setSuccess(true);
                    }catch (Exception e){
                        message.setContent("删除失败！"+e.getMessage());
                        message.setSuccess(false);
                        e.printStackTrace();
                    }
                }else{
                    message.setSuccess(false);
                    message.setContent("您没有权限操作该帖子！");
                }
            }else{
                message.setContent("该帖子不存在");
                message.setSuccess(false);
            }
        }else{
            message.setContent("您尚未登录，请登录后操作！");
            message.setSuccess(false);
        }

        return message;
    }

    @Override
    public Message updateTopicState(int state,long topicId) {

        Message message = new Message();
        User user = (User) session.getAttribute("user");
        if(user != null){
            // 首先判断该用户是否有权限更新该帖子状态
            Topic topic = topicDao.findOne(topicId);
            if(user.getId() == topic.getUser().getId()){
                String stateDisplay = TopicState.NORMAL_DISPLAY;
                switch (state){
                    case TopicState.NORMAL:
                        stateDisplay = TopicState.NORMAL_DISPLAY;
                        break;
                    case 200:
                        stateDisplay = TopicState.NO_REPLAY_DISPLAY;
                        break;
                    case 300:
                        stateDisplay = TopicState.INVISIBLE_DISPLAY;
                        break;
                }
                int result  = topicDao.updateTopicState(state,stateDisplay,topicId);
                if(result == 1){
                    message.setContent("修改成功");
                    message.setSuccess(true);
                }else{
                    message.setContent("修改失败");
                    message.setSuccess(false);
                }
            }else{
                message.setSuccess(false);
                message.setContent("您没有权限操作该帖子！");
            }
        }else{
            message.setContent("您尚未登录，请登录后操作！");
            message.setSuccess(false);
        }

        return message;
    }

    @Override
    public List<Topic> getTopicByBoardId(long boardId) {
        return topicDao.findAllByBoardId(boardId);
    }

    @Override
    public List<Topic> getTopicByUserId(long userId) {
        return topicDao.findAllByUserId(userId);
    }


    @Override
    public Page<Topic> getTopicByConditionType(String conditionType, long conditionValue, int pageSize, int pageNum) {

        Page<Topic> page = null;
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(pageNum-1,pageSize,sort);
        switch (conditionType){
            case "userId":
                page =topicDao.findAllByUserId(conditionValue,pageable);
                break;
            case "boardId":
                page = topicDao.findAllByBoardId(conditionValue,pageable);
                break;
            case "state":
                page = topicDao.findAllByState(conditionValue,pageable);
                break;
            case "all":
                page = topicDao.findAll(pageable);
                break;
            default:
                break;
        }
        return page;
    }

    @Override
    public Map<String, Object> getTopicByIdWithReply(long topicId) {
        Map<String,Object> map = new HashMap<>();
        Topic topic = topicDao.findOne(topicId);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(0,10,sort);
        Page<Reply> page = replyDao.findByTopicId(topicId,pageable);
        map.put("topic",topic);
        map.put("replyList",page);

        return map;
    }


}
