package com.focus.ssm.controller;

import com.focus.ssm.domain.User;
import com.focus.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by  on 2017/7/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/showUser",method = RequestMethod.GET)
    public String getIndex(Model model,int userId){
        User user = userService.selectUserById(userId);
        model.addAttribute("user",user);
        return "index";
    }
}