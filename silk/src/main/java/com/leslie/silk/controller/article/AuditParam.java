package com.leslie.silk.controller.article;

public class AuditParam {

  private Integer id;

  /**
   * 审核意见
   */
  private String auditAdvice;

  /**
   * 审核后状态
   */
  private Integer afterStatus;

  public Integer getAfterStatus() {
    return afterStatus;
  }

  public void setAfterStatus(Integer afterStatus) {
    this.afterStatus = afterStatus;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAuditAdvice() {
    return auditAdvice;
  }

  public void setAuditAdvice(String auditAdvice) {
    this.auditAdvice = auditAdvice;
  }
}
