package com.silk.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.silk.auth.config.JwtConfig;
import com.silk.auth.dao.UserInfoMapper;
import com.silk.auth.dto.ActionResult;
import com.silk.auth.dto.LoginResult;
import com.silk.auth.dto.ResultCode;
import com.silk.auth.entity.UserInfo;
import io.jsonwebtoken.Claims;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

@Service
public class AuthService {


  @Resource
  private JwtConfig jwtConfig;

  @Autowired
  private UserInfoMapper userInfoMapper;


  public Claims check(String token) throws Exception {
    Claims claims = jwtConfig.getTokenClaim(token);
    if (claims == null || jwtConfig.isTokenExpired(claims.getExpiration())) {
      throw new Exception(jwtConfig.getHeader() + "失效，请重新登录");
    }
    return claims;
  }

  public ActionResult login(HttpServletRequest request) throws Exception {

    String loginInfo = getParm(request);
    JSONObject jsonObject = JSONObject.parseObject(loginInfo);
    String username = jsonObject.getString("username");
    String password = jsonObject.getString("password");

    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
      throw new Exception("login is error!");
    }

    ActionResult actionResult = new ActionResult();
    LoginResult loginResult = new LoginResult();

    // 数据源校验
    UserInfo userInfo = userInfoMapper.getByUsername(username);
    if (null == userInfo || !StringUtils.equals(password, userInfo.getPassword())) {
      actionResult.setCode(ResultCode.FAILURE.getCode());
      actionResult.setMessage(ResultCode.FAILURE.getDesc());
      return actionResult;
    }
    if (userInfo.isFrozen()) {
      actionResult.setCode(ResultCode.FROZEN.getCode());
      actionResult.setMessage(ResultCode.FROZEN.getDesc());
      return actionResult;
    }

    String token = jwtConfig.getToken(userInfo);

    if (!StringUtils.isEmpty(token)) {
      loginResult.setToken(token);
    }
    loginResult.setUsername(username);
    loginResult.setAdminFlag(userInfo.getAdminFlag());
    actionResult.setCode(ResultCode.SUCCESS.getCode());
    actionResult.setMessage(ResultCode.SUCCESS.getDesc());
    actionResult.setValue(loginResult);

    // 登录成功更新最后登录时间

    userInfo.setLastIp(getRealIp(request));
    userInfo.setLastTime(new Date());
    userInfoMapper.update(userInfo);

    return actionResult;
  }


  /**
   * 获取真实IP
   *
   * @param request 请求体
   * @return 真实IP
   */
  private String getRealIp(HttpServletRequest request) {
    // 这个一般是Nginx反向代理设置的参数
    String ip = request.getHeader("X-Real-IP");
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("X-Forwarded-For");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    // 处理多IP的情况（只取第一个IP）
    if (ip != null && ip.contains(",")) {
      String[] ipArray = ip.split(",");
      ip = ipArray[0];
    }
    return ip;
  }

  /**
   * 获取POST请求中Body参数
   * @param request
   * @return 字符串
   */
  public String getParm(HttpServletRequest request) {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    String line = null;
    StringBuilder sb = new StringBuilder();
    try {
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }


  public UserInfo getByUsername(String username) {
    return userInfoMapper.getByUsername(username);
  }

}
