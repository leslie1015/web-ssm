package com.silk.auth.controller;

import com.silk.auth.dto.ActionResult;
import com.silk.auth.service.AuthService;
import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController extends BasicController {

  @Autowired
  private AuthService authService;

  @GetMapping("/certification")
  public Claims certification(@RequestParam("token") String token) throws Exception {
    return authService.check(token);
  }

  @PostMapping("/login")
  public ActionResult login(HttpServletRequest request) throws Exception {

    return authService.login(request);
  }

  @GetMapping("/getByUsername")
  public ActionResult getByUsername(String username) {
    return actionResult(authService.getByUsername(username));
  }
}