package com.leslie.silk.service.article;

import com.github.pagehelper.PageHelper;
import com.leslie.silk.entity.article.Article;
import com.leslie.silk.entity.article.ArticleCategory;
import com.leslie.silk.enums.ArticleStatusEnum;
import com.leslie.silk.mapper.article.ArticleCategoryMapper;
import com.leslie.silk.mapper.article.ArticleMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author wangyong
 * @date 2019-07-11 17:28:00
 */
@Service
@Transactional
public class ArticleCategoryService {

  @Autowired
  private ArticleCategoryMapper articleCategoryMapper;

  @Autowired
  private ArticleMapper articleMapper;

  private Logger log = LoggerFactory.getLogger(getClass());

  /**
   * 首页展示文章数据
   *
   * @return
   */
  public List<ArticleCategory> list4Home() {
    List<ArticleCategory> categoryList = articleCategoryMapper.listAllActives();
    log.info("ArticleCategoryService#list4Home6666666666666");


    if (CollectionUtils.isEmpty(categoryList)) {
      return new ArrayList<>();
    }
    Article cond = new Article();
    cond.setDeleteFlag(Article.DELETE_FLAG_NO);
    cond.setStatus(ArticleStatusEnum.AUDIT_PASS.getStatus());
    List<Article> articles;
    for (ArticleCategory category : categoryList) {
      cond.setTypeId(category.getId());
      PageHelper.startPage(1, 6);
      PageHelper.orderBy("top_flag desc, add_time desc");
      articles = articleMapper.listForHome(cond);
      category.setArticleList(articles);
    }
    return categoryList;
  }

  public List<ArticleCategory> listAllCategory() {
    return articleCategoryMapper.listAllActives();
  }


  public void add(ArticleCategory category) {
    articleCategoryMapper.insert(category);
  }

  public void update(ArticleCategory category) {
    articleCategoryMapper.update(category);
  }


  public ArticleCategory getById(Integer id) {
    return articleCategoryMapper.getById(id);
  }

}
