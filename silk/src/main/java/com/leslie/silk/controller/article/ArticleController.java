package com.leslie.silk.controller.article;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.annotaion.RoleType;
import com.leslie.silk.controller.BasicController;
import com.leslie.silk.entity.ActionResult;
import com.leslie.silk.entity.UserThreadLocal;
import com.leslie.silk.entity.article.Article;
import com.leslie.silk.enums.ArticleStatusEnum;
import com.leslie.silk.enums.ResultCode;
import com.leslie.silk.service.article.ArticleService;
import com.leslie.silk.util.AuthUtils;
import com.leslie.silk.vo.SearchCommonVO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author wangyong
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BasicController {

  @Autowired
  private ArticleService articleService;

  @RequestMapping(value="/getArticleInfo",method = RequestMethod.GET)
  public ActionResult getArticleInfo(Integer articleId) {
    return actionResult(articleService.getById(articleId));
  }

  @RequestMapping(value="/list",method = RequestMethod.POST)
  public ActionResult list(@RequestBody SearchCommonVO<Article> condition) {

    condition.getFilters().setStatus(ArticleStatusEnum.AUDIT_PASS.getStatus());

    return actionResult(articleService.list(condition));
  }

  @LoginCheck
  @ResponseBody
  @RequestMapping(value="/imgUpload",method = RequestMethod.POST)
  public ActionResult imgUpload(HttpServletRequest request) throws Exception {
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile(multipartRequest.getFileNames().next());
    return actionResult(articleService.uploadArticleImg(multipartFile));
  }

  @LoginCheck
  @RequestMapping(value="/submit",method = RequestMethod.POST)
  public ActionResult submit(@RequestBody Article article) {
    try {
      articleService.save(article);
    } catch (Exception e) {
      return actionResult(ResultCode.FAILURE, e.getMessage());
    }
    return actionResult(ResultCode.SUCCESS);
  }

  @LoginCheck
  @RequestMapping(value="/update",method = RequestMethod.POST)
  public ActionResult update(@RequestBody Article article) {
    try {
      articleService.update(article);
    } catch (Exception e) {
      return actionResult(ResultCode.FAILURE, e.getMessage());
    }
    return actionResult(ResultCode.SUCCESS);
  }

  @LoginCheck(roleType = RoleType.ADMIN)
  @RequestMapping(value="/audit",method = RequestMethod.POST)
  public ActionResult audit(@RequestBody AuditParam auditParam) {
    try {
      articleService.audit(auditParam);
    } catch (Exception e) {
      return actionResult(ResultCode.FAILURE, e.getMessage());
    }
    return actionResult(ResultCode.SUCCESS);
  }

  @LoginCheck(roleType = RoleType.ADMIN)
  @RequestMapping(value="/listAuditLogs",method = RequestMethod.GET)
  public ActionResult listAuditLogs(Integer articleId) {
    try {
      return actionResult(articleService.listAuditLogs(articleId));
    } catch (Exception e) {
      return actionResult(ResultCode.FAILURE, e.getMessage());
    }
  }

  @LoginCheck
  @RequestMapping(value="/listByStatus",method = RequestMethod.GET)
  public ActionResult listByStatus(Integer status) {
    try {
      return actionResult(articleService.listByStatus(status));
    } catch (Exception e) {
      return actionResult(ResultCode.FAILURE, e.getMessage());
    }
  }
}