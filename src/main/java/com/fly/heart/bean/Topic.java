package com.fly.heart.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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

  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "boardid")
  private Board board;

  @OneToOne(cascade = { CascadeType.ALL })
  @JoinColumn(name = "userid")
  private User user;
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "posttime")
  private Timestamp postTime;

  public Topic() {
  }

  public Topic(String title, String content, int views, int state, Long favorites, Board board, User user, String stateDisplay, Timestamp postTime) {
    this.title = title;
    this.content = content;
    this.views = views;
    this.state = state;
    this.favorites = favorites;
    this.board = board;
    this.user = user;
    this.stateDisplay = stateDisplay;
    this.postTime = postTime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public String getStateDisplay() {
    return stateDisplay;
  }

  public void setStateDisplay(String stateDisplay) {
    this.stateDisplay = stateDisplay;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getPostTime() {
    return postTime;
  }

  public void setPostTime(Timestamp postTime) {
    this.postTime = postTime;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }
}
