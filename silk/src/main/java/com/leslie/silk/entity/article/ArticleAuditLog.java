package com.leslie.silk.entity.article;

import java.util.Date;
import java.io.Serializable;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 文章审核记录表(ArticleAuditLog)实体类
 *
 * @author makejava
 * @since 2019-09-26 10:50:11
 */
public class ArticleAuditLog implements Serializable {
    private static final long serialVersionUID = 416233921398361763L;
    //article表主键
    private Integer articleId;
    //审核状态
    private Integer auditStatus;
    //状态描述
    private String statusDesc;
    //审核意见
    private String auditAdvice;
    //审核人名称
    private String auditName;
    //审核时间
    private Date auditTime;
    //审核人ID
    private Integer auditId;

    /**
     * 格式化后的时间
     */
    private String auditTimeFormat;

    public String getAuditTimeFormat() {
        if (null ==  this.auditTime) {
            return "";
        }
        return DateFormatUtils.format(this.auditTime, "yyyy-MM-dd HH:mm:ss");
    }

    public void setAuditTimeFormat(String auditTimeFormat) {
        this.auditTimeFormat = auditTimeFormat;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getAuditAdvice() {
        return auditAdvice;
    }

    public void setAuditAdvice(String auditAdvice) {
        this.auditAdvice = auditAdvice;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
}