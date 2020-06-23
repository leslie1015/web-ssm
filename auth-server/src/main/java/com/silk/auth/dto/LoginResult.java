package com.silk.auth.dto;

public class LoginResult {

  private String token;

  private String username;

  private Short adminFlag;

  public Short getAdminFlag() {
    return adminFlag;
  }

  public void setAdminFlag(Short adminFlag) {
    this.adminFlag = adminFlag;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
