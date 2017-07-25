package com.focus.ssm.controller;

import com.focus.ssm.domain.User;
import com.focus.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by wangyong1015 on 2017/7/24.
 */
@Controller

public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/showUser",method = RequestMethod.GET)
    public String getIndex(Model model,int userId){
        //ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(userId);
        //mav.addObject("user", user);
        model.addAttribute("user",user);
        return "index";
    }
}
