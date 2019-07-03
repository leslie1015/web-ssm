package com.focus.ssm.dao;

import com.focus.ssm.domain.User;

/**
 * Created by  on 2017/7/24.
 */
public interface UserDao {

    User selectUserById(Integer userId);

}
