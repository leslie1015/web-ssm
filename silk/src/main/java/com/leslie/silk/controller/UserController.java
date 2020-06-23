package com.leslie.silk.controller;

import com.leslie.silk.annotaion.LoginCheck;
import com.leslie.silk.annotaion.RoleType;
import com.leslie.silk.feign.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BasicController{

  @Autowired
  private AuthClient authClient;

  @LoginCheck(roleType = RoleType.GENERAL_USER)
  @RequestMapping(value="/getByUsername",method = RequestMethod.GET)
  public String getByUsername(String username) {
    return authClient.getByUsername(username);
  }
}
