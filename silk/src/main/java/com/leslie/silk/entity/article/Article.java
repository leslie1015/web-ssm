package com.leslie.silk.entity.article;

import java.util.Date;

/**
 * @author wangyong
 */
public class Article {

  public static final Integer DELETE_FLAG_NO = 0;

  private Integer id;
  //文章标题
  private String articleTitle;
  //文章副标题
  private String subTitle;
  //文章分类ID，对应basic_parameter.param_name=CATEGORY_PARAM时param_key的值
  private Integer typeId;
  //文章分类名称
  private String typeName;
  //简介
  private String simpleIntro;
  // 文章内容
  private String content;
  //标题颜色，默认黑色。0黑色，1红色，2蓝色，3绿色
  private String titleColor;
  //标题是否加粗。0否，1是
  private Integer boldFlag;
  //文章是否置顶
  private Integer topFlag;
  //是否删除。0否1是
  private Integer deleteFlag;
  //是否推荐。0否1是
  private Integer recommendFlag;
  //是否广告。0否1是
  private Integer adFlag;
  //关键字
  private String keyword;
  //1草稿，2待审核，3审核通过，4返回修改，5拒绝通过
  private Integer status;
  //删除人编号
  private String deleteNo;
  //删除人姓名
  private String deleteName;
  //删除时间
  private Date deleteTime;
  //添加人编号
  private String addNo;
  //添加人姓名
  private String addName;
  //添加时间
  private Date addTime;
  //修改人编号
  private String updateNo;
  //修改人姓名
  private String updateName;
  //修改时间
  private Date updateTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getArticleTitle() {
    return articleTitle;
  }

  public void setArticleTitle(String articleTitle) {
    this.articleTitle = articleTitle;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getSimpleIntro() {
    return simpleIntro;
  }

  public void setSimpleIntro(String simpleIntro) {
    this.simpleIntro = simpleIntro;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitleColor() {
    return titleColor;
  }

  public void setTitleColor(String titleColor) {
    this.titleColor = titleColor;
  }

  public Integer getBoldFlag() {
    return boldFlag;
  }

  public void setBoldFlag(Integer boldFlag) {
    this.boldFlag = boldFlag;
  }

  public Integer getAdFlag() {
    return adFlag;
  }

  public void setAdFlag(Integer adFlag) {
    this.adFlag = adFlag;
  }

  public Integer getTopFlag() {
    return topFlag;
  }

  public void setTopFlag(Integer topFlag) {
    this.topFlag = topFlag;
  }

  public Integer getDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(Integer deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public Integer getRecommendFlag() {
    return recommendFlag;
  }

  public void setRecommendFlag(Integer recommendFlag) {
    this.recommendFlag = recommendFlag;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getDeleteNo() {
    return deleteNo;
  }

  public void setDeleteNo(String deleteNo) {
    this.deleteNo = deleteNo;
  }

  public String getDeleteName() {
    return deleteName;
  }

  public void setDeleteName(String deleteName) {
    this.deleteName = deleteName;
  }

  public Date getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(Date deleteTime) {
    this.deleteTime = deleteTime;
  }

  public String getAddNo() {
    return addNo;
  }

  public void setAddNo(String addNo) {
    this.addNo = addNo;
  }

  public String getAddName() {
    return addName;
  }

  public void setAddName(String addName) {
    this.addName = addName;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public String getUpdateNo() {
    return updateNo;
  }

  public void setUpdateNo(String updateNo) {
    this.updateNo = updateNo;
  }

  public String getUpdateName() {
    return updateName;
  }

  public void setUpdateName(String updateName) {
    this.updateName = updateName;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
