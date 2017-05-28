package com.flay.heart.bean;

import javax.persistence.*;
import java.io.Serializable;

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
  private Long views;
  @Column(name = "state")
  private Long state;
  @Column(name = "favorites")
  private Long favorites;
  @Column(name = "boardid")
  private Long boardId;
  @Column(name = "userid")
  private Long userId;
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "posttime")
  private String postTime;

  public Topic() {
  }

  public Topic(String title, String content, Long views, Long state, Long favorites, Long boardId, Long userId, String stateDisplay, String postTime) {
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

  public Long getViews() {
    return views;
  }

  public void setViews(Long views) {
    this.views = views;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
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
    return postTime;
  }

  public void setPostTime(String postTime) {
    this.postTime = postTime;
  }
}
