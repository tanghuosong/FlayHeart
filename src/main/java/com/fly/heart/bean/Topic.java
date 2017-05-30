package com.fly.heart.bean;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "content")
  private String content;
  @Column(name = "views")
  private int views;
  @Column(name = "state")
  private int state;
  @Column(name = "favorites")
  private Long favorites;
  @Column(name = "boardid")
  private Long boardId;
  @Column(name = "userid")
  private Long userId;
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "posttime")
  private Timestamp postTime;

  public Topic() {
  }

  public Topic(String title, String content, int views, int state, Long favorites, Long boardId, Long userId, String stateDisplay, Timestamp postTime) {
    this.title = title;
    this.content = content;
    this.views = views;
    this.state = state;
    this.favorites = favorites;
    this.boardId = boardId;
    this.userId = userId;
    this.stateDisplay = stateDisplay;
    this.postTime = postTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public Long getFavorites() {
    return favorites;
  }

  public void setFavorites(Long favorites) {
    this.favorites = favorites;
  }

  public Long getBoardId() {
    return boardId;
  }

  public void setBoardId(Long boardId) {
    this.boardId = boardId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getStateDisplay() {
    return stateDisplay;
  }

  public void setStateDisplay(String stateDisplay) {
    this.stateDisplay = stateDisplay;
  }

  public String getPostTime() {
    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Long time=new Long(postTime.getTime());
    String d = format.format(time);
    return d;
  }

  public void setPostTime(Timestamp postTime) {
    this.postTime = postTime;
  }
}
