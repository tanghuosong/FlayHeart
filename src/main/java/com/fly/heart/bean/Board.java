package com.fly.heart.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tb_board")
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "state")
  private Long state;
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "createtime")
  private Timestamp createTime;

  public Board() {
  }

  public Board(String name, String description, Long state, String stateDisplay, Timestamp createTime) {
    this.name = name;
    this.description = description;
    this.state = state;
    this.stateDisplay = stateDisplay;
    this.createTime = createTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public String getStateDisplay() {
    return stateDisplay;
  }

  public void setStateDisplay(String stateDisplay) {
    this.stateDisplay = stateDisplay;
  }

  public String getCreateTime() {
    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Long time=new Long(createTime.getTime());
    String d = format.format(time);
//    Date date = null;
    return d;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }
}
