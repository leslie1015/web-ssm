package com.leslie.silk.mapper.article;

import com.leslie.silk.entity.article.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {

  List<Article> list(Article condition);

  List<Article> listForHome(Article condition);

  int insert(Article article);

  int updateByPrimaryKeySelective(Article bean);

  int deleteByPrimaryKeySelective(String id);

  Article getById(@Param("id") Integer id);

  List<Article> listByStatus(@Param("status") Integer status, @Param("addNo") String addNo);
}
