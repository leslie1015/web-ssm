package com.leslie.silk.service.article;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leslie.silk.config.AliyunOssConfig;
import com.leslie.silk.controller.article.AuditParam;
import com.leslie.silk.entity.article.Article;
import com.leslie.silk.entity.article.ArticleAuditLog;
import com.leslie.silk.enums.ArticleStatusEnum;
import com.leslie.silk.mapper.article.ArticleAuditLogMapper;
import com.leslie.silk.mapper.article.ArticleMapper;
import com.leslie.silk.util.AliyunOssUtils;
import com.leslie.silk.util.AuthUtils;
import com.leslie.silk.util.StrUtils;
import com.leslie.silk.vo.SearchCommonVO;
import com.leslie.silk.vo.UserInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ArticleService {

  @Autowired
  private ArticleMapper articleMapper;

  @Autowired
  private ArticleAuditLogMapper articleAuditLogMapper;

  public Article getById(Integer id) {
    return articleMapper.getById(id);
  }

  public PageInfo list(SearchCommonVO<Article> condition) {
    PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
//    PageHelper.orderBy(condition.getSort());
    PageHelper.orderBy("top_flag desc, add_time desc");
    List<Article> articles = articleMapper.list(condition.getFilters());
    return new PageInfo(articles);
  }

  public String uploadArticleImg(MultipartFile file) throws Exception {
    StringBuilder imgUrl = new StringBuilder();
    String ossFilePrefix = StrUtils.genUUID();
    String ossFileName = ossFilePrefix + file.getOriginalFilename()
        .substring(file.getOriginalFilename().lastIndexOf("."));
    String fileName = new String(file.getOriginalFilename().getBytes("utf-8"));
    AliyunOssUtils.uploadFile(file, ossFileName);
    imgUrl.append("http://").append(AliyunOssConfig.getDefaultBucketName()).append(".")
        .append(AliyunOssConfig.getEndpointContent()).append("/")
        .append(ossFileName);
    return imgUrl.toString();
  }

  public void save(Article article) throws Exception {
    article.setStatus(ArticleStatusEnum.WAIT_AUDIT.getStatus());
    article.setDeleteFlag(0);
    UserInfo userInfo = AuthUtils.getCurrentUser();
    article.setAddNo(String.valueOf(userInfo.getId()));
    article.setAddName(userInfo.getUsername());
    article.setAddTime(new Date());
    articleMapper.insert(article);
  }

  public void update(Article article) throws Exception {
    if (null == article.getId()) {
      throw new Exception("id不能为空");
    }
    Article articleDB = articleMapper.getById(article.getId());
    if (null == articleDB) {
      throw new Exception("未查询到数据");
    }
    BeanUtils.copyProperties(article, articleDB);
    articleDB.setStatus(ArticleStatusEnum.WAIT_AUDIT.getStatus());
    UserInfo userInfo = AuthUtils.getCurrentUser();
    articleDB.setUpdateNo(String.valueOf(userInfo.getId()));
    articleDB.setUpdateName(userInfo.getUsername());
    articleDB.setUpdateTime(new Date());
    articleMapper.updateByPrimaryKeySelective(articleDB);
  }


  @Transactional(rollbackFor = Exception.class)
  public void audit(AuditParam auditParam) throws Exception {

    Article article = articleMapper.getById(auditParam.getId());
    if (null == article) {
      throw new Exception("数据不存在");
    }
    if (!ArticleStatusEnum.getByStatus(article.getStatus()).isCanAudit()) {
      throw new Exception("当前状态不能审核");
    }
    article.setStatus(auditParam.getAfterStatus());
    articleMapper.updateByPrimaryKeySelective(article);

    ArticleAuditLog log = new ArticleAuditLog();
    log.setArticleId(auditParam.getId());
    log.setAuditStatus(auditParam.getAfterStatus());
    log.setStatusDesc(ArticleStatusEnum.getByStatus(auditParam.getAfterStatus()).getStatusDesc());
    log.setAuditAdvice(auditParam.getAuditAdvice());

    UserInfo userInfo = AuthUtils.getCurrentUser();
    log.setAuditId(userInfo.getId());
    log.setAuditName(userInfo.getUsername());
    log.setAuditTime(new Date());
    articleAuditLogMapper.insert(log);
  }

  public List<ArticleAuditLog> listAuditLogs(Integer articleId) {
    return articleAuditLogMapper.listByArticleId(articleId);
  }

  public List<Article> listByStatus(Integer status) throws Exception {
    return articleMapper.listByStatus(status, String.valueOf(AuthUtils.getCurrentUser().getId()));
  }
}
