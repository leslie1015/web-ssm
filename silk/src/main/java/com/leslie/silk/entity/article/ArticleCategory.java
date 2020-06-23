package com.leslie.silk.entity.article;

import java.util.List;

public class ArticleCategory {

  public static final Short ACTIVE_FLAG_YES = 1;

  private Integer id;

  private String categoryName;

  private Short activeFlag;

  private Short orderNum;

  List<Article> articleList;

  public List<Article> getArticleList() {
    return articleList;
  }

  public void setArticleList(List<Article> articleList) {
    this.articleList = articleList;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public Short getActiveFlag() {
    return activeFlag;
  }

  public void setActiveFlag(Short activeFlag) {
    this.activeFlag = activeFlag;
  }

  public Short getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(Short orderNum) {
    this.orderNum = orderNum;
  }
}
