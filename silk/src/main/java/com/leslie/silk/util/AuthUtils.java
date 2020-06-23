package com.leslie.silk.util;

import com.leslie.silk.entity.UserThreadLocal;
import com.leslie.silk.feign.AuthClient;
import com.leslie.silk.vo.UserInfo;
import javax.annotation.PostConstruct;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

  @Autowired
  @Lazy
  private AuthClient authClient;

  private static AuthClient staticAuthClient;

  @PostConstruct
  public void init() {
    staticAuthClient = authClient;
  }

  public static UserInfo getCurrentUser() throws Exception {
    UserInfo userInfo = new UserInfo();
    try {
      String userName = UserThreadLocal.get().get("sub").toString();
      String userJson = staticAuthClient.getByUsername(userName);
      JSONObject result = new JSONObject(userJson);
      JSONObject userObj = (JSONObject)result.get("value");
      userInfo.setId((Integer)userObj.get("id"));
      userInfo.setUsername(String.valueOf(userObj.get("username")));
      userInfo.setNickname(String.valueOf(userObj.get("nickname")));
      userInfo.setAddress(String.valueOf(userObj.get("address")));
      userInfo.setAdminFlag(String.valueOf(userObj.get("adminFlag")));
      userInfo.setEmail(String.valueOf(userObj.get("email")));
      userInfo.setPhone(String.valueOf(userObj.get("phone")));
    } catch (JSONException e) {

      throw new Exception("获取用户信息失败");
    }
    return userInfo;
  }
}
