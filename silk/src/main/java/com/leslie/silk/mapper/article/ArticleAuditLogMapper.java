package com.leslie.silk.mapper.article;

import com.leslie.silk.entity.article.ArticleAuditLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章审核记录表(ArticleAuditLog)表数据库访问层
 *
 * @author makejava
 * @since 2019-09-26 10:50:11
 */
public interface ArticleAuditLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param  articleId
     * @return 实例对象list
     */
    List<ArticleAuditLog> listByArticleId(Integer articleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ArticleAuditLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleAuditLog 实例对象
     * @return 对象列表
     */
    List<ArticleAuditLog> queryAll(ArticleAuditLog articleAuditLog);

    /**
     * 新增数据
     *
     * @param articleAuditLog 实例对象
     * @return 影响行数
     */
    int insert(ArticleAuditLog articleAuditLog);

    /**
     * 修改数据
     *
     * @param articleAuditLog 实例对象
     * @return 影响行数
     */
    int update(ArticleAuditLog articleAuditLog);

    /**
     * 通过主键删除数据
     *
     * @param  articleId
     * @return 影响行数
     */
    int deleteByArticleId(Integer articleId);

}