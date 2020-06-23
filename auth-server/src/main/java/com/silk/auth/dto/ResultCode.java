package com.silk.auth.dto;

public enum ResultCode {

  SUCCESS(0, "success"),
  FAILURE(1, "用户不存在或者密码错误"),
  FROZEN(1, "该账号已被冻结");
  private String desc;
  private int code;

  private ResultCode(int code, String desc) {
    this.desc = desc;
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public int getCode() {
    return code;
  }

  public static ResultCode getByCode(int code) {
    for (ResultCode errorCode : ResultCode.values()) {
      if (errorCode.getCode() == code) {
        return errorCode;
      }
    }
    return null;
  }
}
