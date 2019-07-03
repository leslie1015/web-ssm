package com.focus.ssm.service;

import com.focus.ssm.domain.User;

/**
 * Created by  on 2017/7/24.
 */
public interface UserService {

    User selectUserById(Integer userId);
}

