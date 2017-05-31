package com.fly.heart.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "topicid")
  private Long topicId;
  @Column(name = "userid")
  private Long userId;
  @Column(name = "content")
  private String content;
  @Column(name = "replaytime")
  private java.sql.Timestamp replayTime;

  public Reply() {

  }
  public Reply(Long topicId, Long userId, String content, Timestamp replayTime) {
    this.topicId = topicId;
    this.userId = userId;
    this.content = content;
    this.replayTime = replayTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getReplayTime() {
      SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Long time=new Long(replayTime.getTime());
      String d = format.format(time);
      return d;
  }

  public void setReplayTime(Timestamp replayTime) {
    this.replayTime = replayTime;
  }
}
