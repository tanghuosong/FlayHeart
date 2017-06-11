package com.fly.heart.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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
  @Column(name = "statedisplay")
  private String stateDisplay;
  @Column(name = "email")
  private String email;
  @Column(name = "registtime")
  private Timestamp registerTime;
  @Column(name = "lastlogintime")
  private Timestamp lastLoginTime;
  @Column(name = "focuscount")
  private Long focusCount;

  public User() {
  }

  public User(String name, String phone, String password, String sex, Long state, String email, Timestamp registerTime, Timestamp lastLoginTime, String stateDisplay, Long focusCount) {
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

  public User(Long id,String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", sex='" + sex + '\'' +
            ", state=" + state +
            ", email='" + email + '\'' +
            ", registerTime=" + registerTime +
            ", lastLoginTime=" + lastLoginTime +
            ", stateDisplay='" + stateDisplay + '\'' +
            ", focusCount=" + focusCount +
            '}';
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

  @JsonIgnore
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

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  public Date getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(Timestamp registerTime) {
    this.registerTime = registerTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Timestamp lastLoginTime) {
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
