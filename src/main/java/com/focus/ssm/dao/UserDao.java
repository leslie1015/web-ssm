package com.focus.ssm.dao;

import com.focus.ssm.domain.User;

/**
 * Created by wangyong1015 on 2017/7/24.
 */
public interface UserDao {

    public User selectUserById(Integer userId);

}
