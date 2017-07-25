package com.focus.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.focus.ssm.dao.UserDao;
import com.focus.ssm.domain.User;
import com.focus.ssm.service.UserService;

/**
 * Created by wangyong1015 on 2017/7/24.
 */


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);

    }
}
