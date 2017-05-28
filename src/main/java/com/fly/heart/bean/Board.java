package com.fly.heart.bean;

import javax.persistence.*;

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

  public Board() {
  }

  public Board(String name, String description, Long state, String stateDisplay) {
    this.name = name;
    this.description = description;
    this.state = state;
    this.stateDisplay = stateDisplay;
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
}
