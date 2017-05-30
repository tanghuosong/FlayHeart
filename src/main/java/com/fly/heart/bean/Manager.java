package com.fly.heart.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_manager")
public class Manager implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;
  @Column(name = "permission")
  private Long permission;
  @Column(name = "permissiondisplay")
  private String permissionDisplay;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;

  public Manager() {
  }

  public Manager(String name, String password, Long permission, String permissionDisplay, String email, String phone) {
    this.name = name;
    this.password = password;
    this.permission = permission;
    this.permissionDisplay = permissionDisplay;
    this.email = email;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Manager{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", permission=" + permission +
            ", permissionDisplay='" + permissionDisplay + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getPermission() {
    return permission;
  }

  public void setPermission(Long permission) {
    this.permission = permission;
  }

  public String getPermissionDisplay() {
    return permissionDisplay;
  }

  public void setPermissionDisplay(String permissionDisplay) {
    this.permissionDisplay = permissionDisplay;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
