package com.fly.heart.bean;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "phone")
  private String phone;
  @Column(name = "password")
  private String password;
  @Column(name = "sex")
  private String sex;
  @Column(name = "state")
  private Long state;
  @Column(name = "email")
  private String email;
  @Column(name = "registtime")
  private String registerTime;
  @Column(name = "lastlogintime")
  private String lastLoginTime;
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "focuscount")
  private Long focusCount;

  public User() {
  }

  public User(String name, String phone, String password, String sex, Long state, String email, String registerTime,
              String lastLoginTime, String stateDisplay, Long focusCount) {
    this.name = name;
    this.phone = phone;
    this.password = password;
    this.sex = sex;
    this.state = state;
    this.email = email;
    this.registerTime = registerTime;
    this.lastLoginTime = lastLoginTime;
    this.stateDisplay = stateDisplay;
    this.focusCount = focusCount;
  }

  public User(String name, String phone, String sex, Long state, String email, String registerTime,
              String lastLoginTime, String stateDisplay, Long focusCount) {
    this.name = name;
    this.phone = phone;
    this.sex = sex;
    this.state = state;
    this.email = email;
    this.registerTime = registerTime;
    this.lastLoginTime = lastLoginTime;
    this.stateDisplay = stateDisplay;
    this.focusCount = focusCount;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(String registerTime) {
    this.registerTime = registerTime;
  }

  public String getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(String lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getStateDisplay() {
    return stateDisplay;
  }

  public void setStateDisplay(String stateDisplay) {
    this.stateDisplay = stateDisplay;
  }

  public Long getFocusCount() {
    return focusCount;
  }

  public void setFocusCount(Long focusCount) {
    this.focusCount = focusCount;
  }
}
